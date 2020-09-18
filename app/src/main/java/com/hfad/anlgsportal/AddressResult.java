package com.hfad.anlgsportal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class AddressResult extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_address_result);
    }

    public void searchButtonClicked (View view) {
        Intent generalIntent = new Intent(this, MainActivity.class);
        startActivity(generalIntent);
    }

    public void buttonClicked(View view) {
        Intent listIntent = new Intent(this, General.class);
        startActivity(listIntent);
    }
}