package com.mindscape.aayu;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;


import com.mindscape.aayu.ml.Alexnetmodelaayu;
import com.mindscape.aayu.ml.Resnetmodelfin;


import org.tensorflow.lite.DataType;
import org.tensorflow.lite.support.image.TensorImage;
import org.tensorflow.lite.support.tensorbuffer.TensorBuffer;

import java.io.IOException;
import java.nio.ByteBuffer;

import static com.mindscape.aayu.ScanResultHandler.sendData;

public class ScanResults extends AppCompatActivity  {

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
        LocationServices gps = new LocationServices(this);
        if (gps.canGetLocation()) {
            LocationManager locationManager = (LocationManager)    getSystemService(LOCATION_SERVICE);
            if (locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER)) {
                longitude = gps.getLongitude();
                latitude= gps.getLatitude();
            }
        }
        fetchLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    getLocation();
                    Toast.makeText(ScanResults.this,"Successfully Added",Toast.LENGTH_LONG).show();



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
            Alexnetmodelaayu model = Alexnetmodelaayu.newInstance(getApplicationContext());

            TensorImage tensorImage = new TensorImage(DataType.FLOAT32);
            tensorImage.load(scannedImage);

            ByteBuffer byteBuffer = tensorImage.getBuffer();

            // Creates inputs for reference.
            TensorBuffer inputFeature0 = TensorBuffer.createFixedSize(new int[]{1, 224, 224, 3}, DataType.FLOAT32);
            inputFeature0.loadBuffer(byteBuffer);

            // Runs model inference and gets result.
            Alexnetmodelaayu.Outputs outputs = model.process(inputFeature0);
            TensorBuffer outputFeature0 = outputs.getOutputFeature0AsTensorBuffer();

            // Releases model resources if no longer used.
            model.close();

            float max = outputFeature0.getFloatArray()[0];

            for (int i = 0; i < outputFeature0.getFloatArray().length; i++) {
                // System.out.print("hii"+outputFeature0.getFloatArray()[i]);
                Log.d
                        ("array list", String.valueOf(outputFeature0.getFloatArray()[i]));
            }

            for (int i = 0; i < outputFeature0.getFloatArray().length; i++) {
                if (max < outputFeature0.getFloatArray()[i]) {
                    max = outputFeature0.getFloatArray()[i];

                    // if (max >= 0.50){

                    index = i+5;


                    // }else {
                    // index = -1;
                    //   }

                    System.out.println("index value: " + index);

                    System.out.println("Jatropha - 6  |  Kudaludehi - 7 | Neem - 8 | Pennywort - 9 | Black pepper - 10");

                }
            }


        } catch (IOException e) {
            e.printStackTrace();
        }


        handlerExecution(index);
        System.out.println(index);
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

                    System.out.println("Guava -  1  |  Jamun -  2  |  Jatropha -  3");

                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        handlerExecution(index);
        System.out.println(index);

    }

    public void handlerExecution(int plantIdNo) {
        ScanResultHandler scanResultHandler = new ScanResultHandler();
        ScanResultHandler.plantId = plantIdNo;
        ScanResultHandler.handler_languageId = languageId;
        scanResultHandler.execute();


    }

    void getLocation() {
        sendData(latitude, longitude);
    }



}