package com.hfad.anlgsportal;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddressResult extends AppCompatActivity {

    public RecyclerView recyclerView;
    private static final String INSTALLATION = "INSTALLATION";
    private static final String LOG_TAG = "MYINSTALLATIONS";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_address_result);

        Intent intent = getIntent();
        String address = intent.getStringExtra("ADDRESS");

        TextView addressResult = findViewById(R.id.addressResult);
        addressResult.setText(address);

        installationResults();

        SwipeRefreshLayout refreshLayout = findViewById(R.id.installationResultsSwipeRefresh);
        refreshLayout.setOnRefreshListener(() -> {
            installationResults();
            refreshLayout.setRefreshing(false);
        });
    }

    public void installationResults() {
        recyclerView = (RecyclerView) findViewById(R.id.installationsRecyclerView);
        InstallationService installationService = ApiUtils.getInstallationService();
        Call<List<Installation>> getAllInstallations = installationService.getAllInstallations();

        getAllInstallations.enqueue(new Callback<List<Installation>>() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onResponse(Call<List<Installation>> call, Response<List<Installation>> response) {
                if (response.isSuccessful()) {
                    List<Installation> allInstallations = response.body();
                    List<String> allInstallationInformation = new ArrayList<>();
                    allInstallations.forEach(installation ->{
                        String str = "";
                        str += "Product Type:\t\t" + installation.getProductType() + "\n" + "Responsible:\t\t\t" + installation.getResponsible() + "\n" + "Due date:\t\t\t\t\t\t" + installation.getWarrantyDate() + "\n";
                        allInstallationInformation.add(str);
                    });
                    populateRecyclerView(allInstallationInformation);

                } else {
                    String message = "Problem " + response.code() + " " + response.message();
                    Log.d(LOG_TAG, message);
                    Toast.makeText(getApplicationContext(), "Nope...", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<List<Installation>> call, Throwable t) {

            }
        });

    }

    public void backButtonPressed(View view) {
        Intent backIntent = new Intent(this, MainActivity.class);
        startActivity(backIntent);
    }

    public void buttonClicked(View view) {
        Intent backIntent = new Intent(this, General.class);
        startActivity(backIntent);
    }

    private void populateRecyclerView(List<String> allInstallations) {
        RecyclerView recyclerView = findViewById(R.id.installationsRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        RecyclerViewSimpleAdapter adapter = new RecyclerViewSimpleAdapter<>(allInstallations);
        recyclerView.setAdapter(adapter);
        adapter.setOnItemClickListener((view, position, item) -> {
            Installation installation = (Installation) item;
            Log.d(LOG_TAG, item.toString());
            Intent intent = new Intent(AddressResult.this, General.class);
            intent.putExtra(AddressResult.INSTALLATION, installation);
            Log.d(LOG_TAG, "putExtra " + installation.toString());
            startActivity(intent);
        });
    }
}