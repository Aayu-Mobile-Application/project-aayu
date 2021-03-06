package com.mindscape.aayu;

import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;

public class ScanResultHandler extends AsyncTask {
    String data = "";
    String scientificName;
    String jsonPlantId;
    String description;
    String treatments;
    String localName;
    String familyName;
    String plantStatus;
    String similarPlants;
    static int handler_languageId;
    static int plantId;

    @Override
    protected Object doInBackground(Object[] objects) {
        //getting scanned plant details from the API
        try {
            ScanResults.spinner.setVisibility(View.VISIBLE);
            URL url = new URL("http://ec2-3-19-27-17.us-east-2.compute.amazonaws.com:8090/plant/englishplant");
            if (Global.langId == 2) {
                //sinhala link
                url = new URL("http://ec2-3-19-27-17.us-east-2.compute.amazonaws.com:8090/plant/sinhalaplant");
                System.out.println("sinhala");
            } else if (Global.langId == 3) {
                //tamil link
                url = new URL("http://ec2-3-19-27-17.us-east-2.compute.amazonaws.com:8090/plant/tamilplant");
                System.out.println("tamil");
            }
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            InputStream inputStream = httpURLConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String line = "";
            while (line != null) {
                line = bufferedReader.readLine();
                data = data + line;

            }
            JSONArray jsonArray = new JSONArray(data);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = (JSONObject) jsonArray.get(i);
                jsonPlantId = jsonObject.get("idOfPlant").toString();
                if (plantId == Integer.parseInt(jsonPlantId)) {
                    scientificName = jsonObject.get("scientificName").toString();
                    description = jsonObject.get("description").toString();
                    treatments = jsonObject.get("treatments").toString();
                    localName = jsonObject.get("localName").toString();
                    familyName = jsonObject.get("familyName").toString();
                    plantStatus = jsonObject.get("statusOfPlant").toString();
                    similarPlants = jsonObject.get("similarPlants").toString();

                    break;
                }else {
                    scientificName="";
                }
            }

        } catch (JSONException | IOException e) {
            e.printStackTrace();
            //TODO-Alert
        }
        return null;
    }

    @Override
    protected void onPostExecute(Object o) {
        super.onPostExecute(o);
        ScanResults.spinner.setVisibility(View.GONE);
        ScanResults.scientificName.setText(scientificName);
        ScanResults.description.setText(description);
        ScanResults.treatments.setText(treatments);
        ScanResults.familyName.setText(familyName);
        ScanResults.localName.setText(localName);
        ScanResults.plantStatus.setText(plantStatus);
        ScanResults.similarPlants.setText(similarPlants);
    }

    static void sendData(double lat, double longt) {
        Random rand = new Random();
//adding location
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    URL url = new URL("http://ec2-3-19-27-17.us-east-2.compute.amazonaws.com:8090/location/location");
                    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                    conn.setRequestMethod("POST");
                    conn.setRequestProperty("Content-Type", "application/json;charset=UTF-8");
                    conn.setRequestProperty("Accept","application/json");
                    conn.setDoOutput(true);
                    conn.setDoInput(true);
//creating the JSON object
                    JSONObject jsonObject=new JSONObject();
                    jsonObject.put("locationId",rand.nextInt(10000));
                    jsonObject.put("plantName",getCommonName());
                    jsonObject.put("latitude",lat);
                    jsonObject.put("longitude",longt);
                    jsonObject.put("user",Global.loggedName);

                    Log.i("JSON", jsonObject.toString());
                    DataOutputStream dataOut = new DataOutputStream(conn.getOutputStream());
                    dataOut.writeBytes(jsonObject.toString());
//releasing resources
                    dataOut.flush();
                    dataOut.close();
                    Log.i("STATUS", String.valueOf(conn.getResponseCode()));
                    Log.i("MSG" , conn.getResponseMessage());
                    conn.disconnect();
                } catch (Exception e) {
                    e.printStackTrace();
                    //TODO error handling
                }
            }
        });

        thread.start();

    }

    static String getCommonName(){
        String data="";
        try {
            URL url = new URL("http://ec2-3-19-27-17.us-east-2.compute.amazonaws.com:8090/plant/englishplant");
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            InputStream inputStream = httpURLConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String line = "";
            while (line != null) {
                line = bufferedReader.readLine();
                data = data + line;

            }
            JSONArray jsonArray = new JSONArray(data);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = (JSONObject) jsonArray.get(i);
                String jsonPlantId = jsonObject.get("idOfPlant").toString();
                if (plantId == Integer.parseInt(jsonPlantId)) {
                    return jsonObject.get("localName").toString();
                }
            }

        } catch (JSONException | IOException e) {
            e.printStackTrace();
            //TODO-Alert
        }
        return  null;
    }
}
