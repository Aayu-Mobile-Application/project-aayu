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
            if (handler_languageId == 2) {
                //sinhala link
                url = new URL("https://raw.githubusercontent.com/ArunaRandika/demo/master/db.json");
            } else if (handler_languageId == 3) {
                //tamil link
                url = new URL("https://raw.githubusercontent.com/ArunaRandika/demo/master/db.json");
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
            JSONArray JA = new JSONArray(data);
            for (int i = 0; i < JA.length(); i++) {
                JSONObject JO = (JSONObject) JA.get(i);
                jsonPlantId = JO.get("idOfPlant").toString();
                if (plantId == Integer.parseInt(jsonPlantId)) {
                    scientificName = JO.get("scientificName").toString();
                    description = JO.get("description").toString();
                    treatments = JO.get("treatments").toString();
                    localName = JO.get("localName").toString();
                    familyName = JO.get("familyName").toString();
                    plantStatus = JO.get("statusOfPlant").toString();
                    similarPlants = JO.get("similarPlants").toString();

                    break;
                }
            }

        } catch (JSONException | IOException e) {
            e.printStackTrace();
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
