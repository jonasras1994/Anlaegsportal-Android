package com.hfad.anlgsportal;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Button button;
    ImageView imageView;

    private static final String LOG_TAG = "MINE";
    private static final String ADDRESS = "ADDRESS";
    private Spinner spinner;
    EditText editText;
    private boolean isSpinnerTouched = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.lokationButton);
        button.setOnClickListener(buttonHandler);
        imageView = (ImageView) findViewById(R.id.mapImageView);
        editText = findViewById(R.id.edittext);

        spinner = findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(this);


        spinner.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                isSpinnerTouched = true;
                return false;
            }
        });

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
    public void qrButtonPressed(View view){
        Intent qrIntent = new Intent(this, QRActivity.class);
        startActivity(qrIntent);
    }

    public void onPause(){
        super.onPause();
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        if (!isSpinnerTouched) return;
        String text = parent.getItemAtPosition(position).toString();
        editText.setText(text);
        isSpinnerTouched = false;
    }

    View.OnClickListener buttonHandler = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            imageView.setImageResource(R.drawable.maps);
        }
    };

    public void searchButtonPressed(View view) {

        Intent intent = new Intent(this, AddressResult.class);
        String address = editText.getText().toString();
        intent.putExtra("ADDRESS", address);
        startActivity(intent);
    }

    public void inputAddress(String input) {

        spinner = (Spinner) findViewById(R.id.spinner);

        AddressService addressService = ApiUtils.getAddressService();
        Call<List<Address>> getAllAddresses = addressService.getAllAddresses(input);

        getAllAddresses.enqueue(new Callback<List<Address>>() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onResponse(Call<List<Address>> call, Response<List<Address>> response) {
                if (response.isSuccessful()) {
                    List<Address> allAddresses = response.body();
                    List<String> allAddressLines = new ArrayList<String>();
                    allAddresses.forEach(address -> {
                        allAddressLines.add(address.getTekst());
                    });

                    ArrayAdapter<String> adapter0 = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_spinner_item, allAddressLines);
                    adapter0.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
                    spinner.setAdapter(adapter0);
                    Log.i("AAA", "spinner0");
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



        private void populateRecyclerView (List <Address> allAddresses) {
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


    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}