package com.mindscape.aayu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;


import com.mindscape.aayu.ml.Resnetmodelfin;
import com.mindscape.aayu.ml.Aayualexnet;

import org.json.JSONException;
import org.json.JSONObject;
import org.tensorflow.lite.DataType;
import org.tensorflow.lite.support.image.TensorImage;
import org.tensorflow.lite.support.tensorbuffer.TensorBuffer;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.ByteBuffer;

import static androidx.constraintlayout.motion.widget.Debug.getLocation;
import static com.mindscape.aayu.ScanResultHandler.sendData;

public class ScanResults extends AppCompatActivity implements LocationListener {

    private Bitmap scannedImage;
    private ImageView imageView;
    @SuppressLint("StaticFieldLeak")
    static TextView description, treatments, familyName, localName, plantStatus, similarPlants, scientificName;
    @SuppressLint("StaticFieldLeak")
    static ProgressBar spinner;
    static int languageId;
    static int index = 0;
    private Button fetchLocation;
    private LocationManager locationManager;
    private static final String[] LOCATION_PERMS = {Manifest.permission.ACCESS_FINE_LOCATION};
    private static final int LOCATION_REQUEST = 1340;
    private double latitude;
    private double longitude;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scan_results);
        scannedImage = Global.img;
        imageView = (ImageView) findViewById(R.id.scanned_imageView);
        treatments = (TextView) findViewById(R.id.scan_treatments);
        familyName = (TextView) findViewById(R.id.scan_familyname);
        localName = (TextView) findViewById(R.id.scan_localname);
        scientificName = (TextView) findViewById(R.id.scan_scieName);
        plantStatus = (TextView) findViewById(R.id.scan_status);
        similarPlants = (TextView) findViewById(R.id.scan_similar);
        description = (TextView) findViewById(R.id.scan_plantDescription);
        spinner = (ProgressBar) findViewById(R.id.progressBar1);
        fetchLocation = (Button) findViewById(R.id.scan_fetchLocation);
        fetchLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getLocation();
            }
        });

        spinner.setVisibility(View.GONE);
        if (scannedImage != null) {

            imageView.setImageBitmap(scannedImage);
            if (Global.leafType == 1) {
                AlexNet();
            } else if (Global.leafType == 2) {
                ResNet();
            }
        }


    }

    public void AlexNet() {
        System.out.println("alex");
        scannedImage = Bitmap.createScaledBitmap(scannedImage, 224, 224, true);

        try {
            Aayualexnet model = Aayualexnet.newInstance(getApplicationContext());

            TensorImage tensorImage = new TensorImage(DataType.FLOAT32);
            tensorImage.load(scannedImage);

            ByteBuffer byteBuffer = tensorImage.getBuffer();

            // Creates inputs for reference.
            TensorBuffer inputFeature0 = TensorBuffer.createFixedSize(new int[]{1, 224, 224, 3}, DataType.FLOAT32);
            inputFeature0.loadBuffer(byteBuffer);

            // Runs model inference and gets result.
            Aayualexnet.Outputs outputs = model.process(inputFeature0);
            TensorBuffer outputFeature0 = outputs.getOutputFeature0AsTensorBuffer();

            // Releases model resources if no longer used.
            model.close();

            float max = outputFeature0.getFloatArray()[0];

            for (int i = 0; i < outputFeature0.getFloatArray().length; i++) {
                if (max < outputFeature0.getFloatArray()[i]) {
                    max = outputFeature0.getFloatArray()[i];

                    // if (max >= 0.50){

                    index = i;


                    // }else {
                    // index = -1;
                    //   }

                    System.out.println("index value: " + index);

                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


        handlerExecution(index);
    }

    public void ResNet() {

        scannedImage = Bitmap.createScaledBitmap(scannedImage, 224, 224, true);
        try {
            Resnetmodelfin model = Resnetmodelfin.newInstance(getApplicationContext());
            TensorImage tensorImage = new TensorImage(DataType.FLOAT32);
            tensorImage.load(scannedImage);

            ByteBuffer byteBuffer = tensorImage.getBuffer();
            // Creates inputs for reference.
            TensorBuffer inputFeature0 = TensorBuffer.createFixedSize(new int[]{1, 224, 224, 3}, DataType.FLOAT32);
            inputFeature0.loadBuffer(byteBuffer);

            // Runs model inference and gets result.
            Resnetmodelfin.Outputs outputs = model.process(inputFeature0);
            TensorBuffer outputFeature0 = outputs.getOutputFeature0AsTensorBuffer();

            // Releases model resources if no longer used.
            model.close();

            float max = outputFeature0.getFloatArray()[0];

            for (int i = 0; i < outputFeature0.getFloatArray().length; i++) {
                // System.out.print("hii"+outputFeature0.getFloatArray()[i]);
                Log.d("array list", String.valueOf(outputFeature0.getFloatArray()[i]));
            }

            for (int i = 0; i < outputFeature0.getFloatArray().length; i++) {
                if (max < outputFeature0.getFloatArray()[i]) {
                    max = outputFeature0.getFloatArray()[i];

                    // if (max >= 0.50){

                    index = i;


                    // }else {
                    // index = -1;
                    //   }

                    System.out.println("index value: " + index);
                    System.out.println("------------------------------------------");
                    System.out.println("Guava - INDEX 1");
                    System.out.println("Jamun - INDEX 2");
                    System.out.println("Jatropha - INDEX 3");
                    System.out.println("------------------------------------------");
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        handlerExecution(index);

    }

    public void handlerExecution(int plantIdNo) {
        ScanResultHandler scanResultHandler = new ScanResultHandler();
        ScanResultHandler.plantId = plantIdNo;
        ScanResultHandler.handler_languageId = languageId;
        scanResultHandler.execute();

    }

    void getLocation() {
        try {
            if (canAccessLocation()) {
                locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
                locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 10, 5, this);
            } else {
                requestPermissions(LOCATION_PERMS, LOCATION_REQUEST);
            }

        } catch (SecurityException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onLocationChanged(@NonNull Location location) {
        //the API link relevant to the Fetch location method goes here
        System.out.println(location.getLatitude() + " " + location.getLongitude());
        latitude = location.getLatitude();
        longitude = location.getLongitude();
        System.out.println(Global.loggedName);
        sendData(latitude, longitude);
//
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(@NonNull String provider) {

    }

    @Override
    public void onProviderDisabled(@NonNull String provider) {

    }

    private boolean canAccessLocation() {
        return (hasPermission(Manifest.permission.ACCESS_FINE_LOCATION));
    }

    private boolean hasPermission(String perm) {
        return (PackageManager.PERMISSION_GRANTED == checkSelfPermission(perm));
    }




}