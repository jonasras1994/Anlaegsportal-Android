package com.hfad.anlgsportal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.location.Geocoder;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity {

    Button button;
    ImageView imageView;

    private static final String LOG_TAG = "MINE";
    private static final String ADDRESS = "ADDRESS";
    private Spinner spinner0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.lokationButton);
        button.setOnClickListener(buttonHandler);
        imageView = (ImageView) findViewById(R.id.mapImageView);
        EditText editText = findViewById(R.id.edittext);

        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
//                String input = editText.getText().toString();
                inputAddress(editable.toString());

            }
        });


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

public void inputAddress (String input){

    spinner0 = (Spinner) findViewById(R.id.spinner);

    AddressService addressService = ApiUtils.getAddressService();
    Call<List<Address>> getAllAddresses = addressService.getAllAddresses(input);

    getAllAddresses.enqueue(new Callback<List<Address>>() {
        @Override
        public void onResponse(Call<List<Address>> call, Response<List<Address>> response) {
            if (response.isSuccessful()) {
                List<Address> allAddresses = response.body();
//                populateRecyclerView(allAddresses);
                ArrayAdapter<Address> adapter0 = new ArrayAdapter<Address>(MainActivity.this, android.R.layout.simple_spinner_item, allAddresses);
                adapter0.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
                spinner0.setAdapter(adapter0);
                Log.i("AAA","spinner0");
            } else {
                String message = "Problem " + response.code() + " " + response.message();
                Log.d(LOG_TAG, message);
                Toast.makeText(getApplicationContext(), "Nope...", Toast.LENGTH_LONG).show();
            }
        }

        @Override
        public void onFailure(Call<List<Address>> call, Throwable t) {

        }
    });
}


    private void populateRecyclerView (List<Address> allAddresses) {
        RecyclerView recyclerView = findViewById(R.id.edittext);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        RecyclerViewSimpleAdapter adapter = new RecyclerViewSimpleAdapter<>(allAddresses);
        recyclerView.setAdapter(adapter);
        adapter.setOnItemClickListener(new RecyclerViewSimpleAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position, Object item) {
                Address address = (Address) item;
                Log.d(LOG_TAG, item.toString());
                Intent intent = new Intent(MainActivity.this, selectedAddress.class);
                intent.putExtra(MainActivity.ADDRESS, address);
                Log.d(LOG_TAG, "putExtra " + address.toString());
                MainActivity.this.startActivity(intent);
            }
        });

    }
/*    public void etHeltAlmindeligtNavn (Address item) {
        Address address = (Address) item;
        Log.d(LOG_TAG, item.toString());
        Intent intent = new Intent(MainActivity.this, selectedAddress.class);
        intent.putExtra(MainActivity.ADDRESS, address);
        Log.d(LOG_TAG, "putExtra " + address.toString());
        startActivity(intent);
    }*/
}