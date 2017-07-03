package com.melayer.jsonparsing;

import android.content.res.AssetManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        parseItGson();
    }

    private void parseIt() throws JSONException {

        JSONObject rtOb = new JSONObject(readJson());
        l("Name - " + rtOb.getString("name"));
        l("Devices - " + rtOb.getInt("devices"));

        JSONArray arr = rtOb.getJSONArray("types");
        for (int i = 0; i < arr.length(); i++) {
            l("Arr - " + arr.getString(i));
        }

        JSONObject inrOb = rtOb.getJSONObject("details");
        JSONArray inrArr = inrOb.getJSONArray("techs");
        for (int i = 0; i < inrArr.length(); i++) {
            l("Inr Arr -" + inrArr.getString(i));
        }
    }

    private void parseItGson() {
        Gson gson = new Gson();
        Res res = gson.fromJson(readJson(), Res.class);
        l("Name - "+res.getName());
        l("Devices - "+res.getDevices());
        l("Details Company "+res.getDetails().getCompany());
    }

    private void l(String msg) {
        Log.i("@codekul", msg);
    }

    private String readJson() {

        StringBuilder builder = new StringBuilder();
        AssetManager manager = getAssets();
        try {
            InputStream is = manager.open("my.json");
            while (true) {
                int ch = is.read();
                if (ch == -1) break;
                else builder.append((char) ch);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return builder.toString();
    }
}
