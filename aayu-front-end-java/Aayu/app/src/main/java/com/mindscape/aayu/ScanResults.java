package com.mindscape.aayu;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.mindscape.aayu.ml.AayuAlexnet;

import org.tensorflow.lite.DataType;
import org.tensorflow.lite.support.image.TensorImage;
import org.tensorflow.lite.support.tensorbuffer.TensorBuffer;

import java.io.IOException;
import java.nio.ByteBuffer;

public class ScanResults extends AppCompatActivity {

    private Bitmap scannedImage;
    private ImageView imageView;
    static TextView description, treatments, familyName, localName, plantStatus, similarPlants, scientificName;
    static ProgressBar spinner;
    static int leafType;
    static int languageId;
    static int index = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scan_results);
scannedImage=Global.img;
        languageId = getIntent().getIntExtra("langId", 2);
        leafType = getIntent().getIntExtra("leafType", 0);
        imageView = (ImageView) findViewById(R.id.scanned_imageView);
        treatments = (TextView) findViewById(R.id.scan_treatments);
        familyName = (TextView) findViewById(R.id.scan_familyname);
        localName = (TextView) findViewById(R.id.scan_localname);
        scientificName = (TextView) findViewById(R.id.scan_scieName);
        plantStatus = (TextView) findViewById(R.id.scan_status);
        similarPlants = (TextView) findViewById(R.id.scan_similar);
        description = (TextView) findViewById(R.id.scan_plantDescription);
        spinner = (ProgressBar) findViewById(R.id.progressBar1);

        spinner.setVisibility(View.GONE);
        if (scannedImage != null) {

            imageView.setImageBitmap(scannedImage);
            if (leafType == 1) {
                AlexNet();
            } else if (leafType == 2) {
                ResNet();
            }
        }


    }

    public void AlexNet() {

        scannedImage = Bitmap.createScaledBitmap(scannedImage,227,227,true);

        try {
            AayuAlexnet model = AayuAlexnet.newInstance(getApplicationContext());

            TensorImage tensorImage = new TensorImage(DataType.FLOAT32);
            tensorImage.load(scannedImage);

            ByteBuffer byteBuffer = tensorImage.getBuffer();

            // Creates inputs for reference.
            TensorBuffer inputFeature0 = TensorBuffer.createFixedSize(new int[]{1, 227, 227, 3}, DataType.FLOAT32);
            inputFeature0.loadBuffer(byteBuffer);

            // Runs model inference and gets result.
            AayuAlexnet.Outputs outputs = model.process(inputFeature0);
            TensorBuffer outputFeature0 = outputs.getOutputFeature0AsTensorBuffer();

            // Releases model resources if no longer used.
            model.close();

            float max = outputFeature0.getFloatArray()[0];


            // get the highest index value --> predicted plant
            for (int i = 0; i < outputFeature0.getFloatArray().length; i++)
            {
                if (max < outputFeature0.getFloatArray()[i]) {
                    max = outputFeature0.getFloatArray()[i];
                    if (max >= 0.50){
                        index = i;
                    }else{
                        index = -1;
                    }

                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


        handlerExecution(index);
    }

    public void ResNet() {
        handlerExecution(3);

    }

    public void handlerExecution(int plantIdNo) {
        ScanResultHandler scanResultHandler = new ScanResultHandler();
        ScanResultHandler.plantId = plantIdNo;
        ScanResultHandler.handler_languageId = languageId;
        scanResultHandler.execute();

    }
}