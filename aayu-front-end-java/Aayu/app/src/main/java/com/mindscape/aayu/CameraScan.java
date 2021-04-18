package com.mindscape.aayu;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.InputStream;

public class CameraScan extends AppCompatActivity {
    private Button openCameraButton, importImage, confirmImage;
    private ImageView imageView;
    private Bitmap imageBitmap;
    private static final int imageCaptureCode = 101;
    private static final int imageLoadingCode = 100;
    private int leafType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera_scan);
        imageView = (ImageView) findViewById(R.id.imageView2);
        openCameraButton = (Button) findViewById(R.id.button2);
        importImage = (Button) findViewById(R.id.button3);
        confirmImage = (Button) findViewById(R.id.confirm);
        leafType=getIntent().getIntExtra("leafType",0);
        openCameraButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                takePicture();
            }
        });

        importImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                importImage();
            }
        });
        confirmImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openScanResultScreen();
            }
        });



    }
//taking permission to use the system camera
    private void takePicture() {
        Intent imageTakeIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        //*****important-make getPackageManager()) == null (convert != to ==) if you run this on a real device
        if (imageTakeIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(imageTakeIntent, imageCaptureCode);
        }
    }

    private void importImage() {
        Intent photoPickerIntent = new Intent(Intent.ACTION_GET_CONTENT);
        photoPickerIntent.setType("image/*");
        startActivityForResult(photoPickerIntent, 100);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        super.onActivityResult(requestCode, resultCode, data);
//loading the image to a Bitmap
        if(requestCode==101){
            if (requestCode == imageCaptureCode && resultCode==RESULT_OK) {
                Bundle extras = data.getExtras();
                imageBitmap = (Bitmap) extras.get("data");
                imageView.setImageBitmap(imageBitmap);
            }
        }else{
            if (resultCode == RESULT_OK) {
                try {
                    final Uri imageUri = data.getData();
                    final InputStream imageStream = getContentResolver().openInputStream(imageUri);
                    imageBitmap = BitmapFactory.decodeStream(imageStream);
                    imageView.setImageBitmap(imageBitmap);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();

                }

            }else {
                Toast.makeText(this,"No Image selected",Toast.LENGTH_SHORT).show();
            }

        }



    }
    public void openScanResultScreen(){
        if(imageBitmap!=null){
            Intent intent = new Intent(this,LanguageSelector.class);
            Global.img=imageBitmap;
            intent.putExtra("leafType", leafType);
                startActivity(intent);


        }else{
            Toast.makeText(this,"Please select a Image",Toast.LENGTH_SHORT).show();
        }

    }




    }