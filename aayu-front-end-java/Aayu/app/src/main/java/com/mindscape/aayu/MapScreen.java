package com.mindscape.aayu;

import androidx.fragment.app.FragmentActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MapScreen extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private Button searchButton;
    private EditText searchInput;
    private ProgressBar spinner;
    private static final String LOG_TAG = "ExampleApp";
    private String SERVICE_URL = "https://mocki.io/v1/6b0cd774-42d4-49c8-897b-28c32112ebb4";
    private String plantName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_map_view);
        searchButton = (Button) findViewById(R.id.mapview_searchbutton);
        searchInput = (EditText) findViewById(R.id.mapview_searchInput);
        spinner = (ProgressBar) findViewById(R.id.progressBar2);
        spinner.setVisibility(View.GONE);
//rendering map
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                plantName = searchInput.getText().toString();
                if (!plantName.equals("")) {
                    setUpMap(plantName);
                }else{
                    //TODO
                }


            }
        });

    }

    @Override
    protected void onResume() {

        super.onResume();

    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    //zooming intoo Sri Lanka
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        LatLng SriLanka = new LatLng(7.8731, 80.7718);
        mMap.moveCamera(CameraUpdateFactory.newLatLng(SriLanka));
        mMap.animateCamera(CameraUpdateFactory.zoomTo(7.5f));
    }


    private void setUpMap(String plantName) {
        //retrieving data from a  new thread
        new Thread(new Runnable() {

            public void run() {
                try {
                    retrieveAndAddCities(plantName);
                } catch (IOException e) {
                    Log.e(LOG_TAG, "Cannot retrieve plants", e);
                    return;
                }
            }
        }).start();
    }

    protected void retrieveAndAddCities(String plantName) throws IOException {
       SERVICE_URL="http://3.19.27.17:8090/location/"+plantName;

        HttpURLConnection conn = null;
        final StringBuilder json = new StringBuilder();
        try {
            // web service connection
            spinnerSetup(true);
            URL url = new URL(SERVICE_URL);
            conn = (HttpURLConnection) url.openConnection();
            InputStreamReader in = new InputStreamReader(conn.getInputStream());

            // reading JSON data to the string builder
            int read;
            char[] buff = new char[1024];
            while ((read = in.read(buff)) != -1) {
                json.append(buff, 0, read);
            }
        } catch (IOException e) {
            throw new IOException("Error connecting to service", e);
        } finally {
            if (conn != null) {
                conn.disconnect();
            }
        }
        runOnUiThread(new Runnable() {
            public void run() {
                try {
                    createMarkersFromJson(json.toString());
                } catch (JSONException e) {
                    Log.e(LOG_TAG, "Error processing JSON", e);
                }
            }
        });
    }

    void createMarkersFromJson(String json) throws JSONException {
        // De-serialize the JSON string into an array of plant objects
        JSONArray jsonArray = new JSONArray(json);
        for (int i = 0; i < jsonArray.length(); i++) {
            // creating markers
            JSONObject jsonObj = jsonArray.getJSONObject(i);

            mMap.addMarker(new MarkerOptions()
                    .title(jsonObj.getString("user"))
                    .position(new LatLng(
                            jsonObj.getDouble("latitude"), jsonObj.getDouble("longitude")

                    ))
            );

        }
        spinnerSetup(false);
    }

    //configuring activity indicator in the Main Thread
    public void spinnerSetup(boolean isSpinner) {
        runOnUiThread(new Runnable() {

            @Override
            public void run() {

                if (isSpinner) {
                    spinner.setVisibility(View.VISIBLE);
                } else {
                    spinner.setVisibility(View.GONE);
                }

            }
        });


    }
}