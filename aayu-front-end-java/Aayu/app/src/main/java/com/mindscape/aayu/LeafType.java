package com.mindscape.aayu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LeafType extends AppCompatActivity {
  private Button healthy,deceased;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leaf_type);
        healthy=(Button) findViewById(R.id.healthy);
        deceased=(Button) findViewById(R.id.deceased);

        healthy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int leafType=1;
                openImageSelector(leafType);
            }
        });
        deceased.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int leafType=2;
                openImageSelector(leafType);
            }
        });


    }
    public void openImageSelector(int leafType){
        Intent intent = new Intent(this, CameraScan .class);
        Global.leafType=leafType;
        startActivity(intent);

    }

}