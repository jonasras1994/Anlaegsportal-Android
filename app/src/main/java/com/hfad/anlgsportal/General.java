package com.hfad.anlgsportal;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class General extends AppCompatActivity {

    private static final int CAMERA_REQUEST = 1888;
    private static ImageView imageView;
    private static final int MY_CAMERA_PERMISSION_CODE = 100;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_general);

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

    public void backButtonPressed (View view) {
        Intent backIntent = new Intent(this, AddressResult.class);
        startActivity(backIntent);
    }
}
