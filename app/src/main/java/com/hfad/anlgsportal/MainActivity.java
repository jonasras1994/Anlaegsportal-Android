package com.hfad.anlgsportal;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Application;
import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button button;
    ImageView imageView;

    private static final String LOG_TAG = "MINE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.lokationButton);
        button.setOnClickListener(buttonHandler);
        imageView = (ImageView) findViewById(R.id.mapImageView);


        /*Application application = getApplication();
        Geocoder geocoder = new Geocoder(application);
        int maxResults = 4;

        // Geocoding: location name -> (latitude, longitude)
        String locationName = "Penselstrøget 30, 4000 Roskilde, Denmark";
        TextView viewResult = findViewById(R.id.main_addresses_textview);
        viewResult.setText(locationName + "\n");
        try {
            List<Address> addressList = geocoder.getFromLocationName(locationName, maxResults);
            for (Address addr : addressList) {
                viewResult.append("Lat: " + addr.getLatitude() + " Long: " + addr.getLongitude());
            }
        } catch (IOException e) {
            viewResult.setText(e.getMessage());
        }
        // Reverse geocoding: (latitude, longitude) -> address(es)
        double latitude = 55.6277273;
        double longtitude = 12.0805262;
        TextView viewReverseResult = findViewById(R.id.main_addresses_textview);
        viewReverseResult.setText("Lat: " + latitude + " Long " + longtitude + "\n");
        try {
            List<Address> addressList = geocoder.getFromLocation(latitude, longtitude, maxResults);
            Log.d(LOG_TAG, addressList.toString());
            // Log.d(LOG_TAG, addr.toString());
            for (Address addr : addressList) {
                String addressLine = addr.getAddressLine(0);
                Log.d(LOG_TAG, addressLine);
                viewReverseResult.append(addressLine + "\n");
                //viewReverseResult.setText(addr.getPremises() + " " + addr.getFeatureName() + " " + addr.getLocality() + ", " + addr.getCountryName());
            }
        } catch (IOException e) {
            viewReverseResult.setText(e.getMessage());
        }*/
    }



    View.OnClickListener buttonHandler = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            imageView.setImageResource(R.drawable.maps);
        }
    };

public void buttonPressed (View view){
        Intent intent = new Intent (this, General.class);
        startActivity(intent);
}

private void populateRecyclerView (List<Adress>)
}