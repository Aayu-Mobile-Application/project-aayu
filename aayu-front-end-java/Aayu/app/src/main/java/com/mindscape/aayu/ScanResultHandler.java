package com.mindscape.aayu;

import android.os.AsyncTask;
import android.view.View;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

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
        try {
            ScanResults.spinner.setVisibility(View.VISIBLE);
            ArrayList<String> stringArray = new ArrayList<String>();
            URL url = new URL("https://raw.githubusercontent.com/ArunaRandika/demo/master/db.json");
            if (Global.langId == 2) {
                //sinhala link
                url = new URL("https://raw.githubusercontent.com/ArunaRandika/demo/master/db.json");
                System.out.println("sinhala");
            } else if (Global.langId == 3) {
                //tamil link
                url = new URL("https://raw.githubusercontent.com/ArunaRandika/demo/master/db.json");
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
            stringArray.add(data);
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
}
