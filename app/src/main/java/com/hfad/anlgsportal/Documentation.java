package com.hfad.anlgsportal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Documentation extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_documentation);
    }
    public void generalButtonPressed (View view) {
        Intent generalIntent = new Intent(this, General.class);
        startActivity(generalIntent);
    }
    public void reviewButtonPressed (View view) {
        Intent reviewIntent = new Intent(this, Review.class);
        startActivity(reviewIntent);
    }

    public void documentationButtonPressed (View view) {
        Intent documentationIntent = new Intent(this, Documentation.class);
        startActivity(documentationIntent);
    }
}
