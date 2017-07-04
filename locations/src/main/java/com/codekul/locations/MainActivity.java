package com.codekul.locations;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.location.LocationProvider;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity implements LocationListener {

    private LocationManager manager;
    private RequestQueue q;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        manager = (LocationManager) getSystemService(LOCATION_SERVICE);

        q = Volley.newRequestQueue(this);

        String provider = manager.getBestProvider(criteria(), true);
        Log.i("@codekul", "Provider is " + provider);

        LocationProvider providerAgain = manager.getProvider(LocationManager.PASSIVE_PROVIDER);

        if (ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED &&
                ActivityCompat.checkSelfPermission(
                        this,
                        Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

        } else manager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 100, 0.1f, this);
    }

    private Criteria criteria() {
        Criteria criteria = new Criteria();
        criteria.setAccuracy(Criteria.ACCURACY_FINE);
        criteria.setAltitudeRequired(true);
        criteria.setBearingAccuracy(Criteria.ACCURACY_FINE);
        criteria.setCostAllowed(true);

        return criteria;
    }

    @Override
    public void onLocationChanged(Location location) {
        ((TextView) findViewById(R.id.txtInfo)).setText("Lat - " + location.getLatitude() + " Lng - " + location.getLongitude());

        JSONObject obj = new JSONObject();
        try {
            obj.put("lat", location.getLatitude());
            obj.put("lng", location.getLongitude());
        } catch (JSONException e) {
            e.printStackTrace();
        }

        q.add(new JsonObjectRequest(
                " https://digital-shelter-153912.firebaseio.com/myLoc.json",
                obj,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Log.i("@codekul", "Success -" + response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.i("@codekul", "Error -" + error);
                    }
                }
        ));
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }
}
