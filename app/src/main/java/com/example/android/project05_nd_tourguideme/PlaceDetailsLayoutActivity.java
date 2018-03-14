package com.example.android.project05_nd_tourguideme;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class PlaceDetailsLayoutActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.place_details_layout);

        //Get proper information of the place from intent
        // name, address, info, phone, web, email, quote, image
        Bundle bundle = getIntent().getExtras();
        assert bundle != null;

        String placeName = bundle.getString(getString(R.string.place));
        final String placeCategory = bundle.getString(getString(R.string.category));
        final String placeAddress = bundle.getString(getString(R.string.address));
        final String placeInfo = bundle.getString(getString(R.string.info));
        final String placePhone = bundle.getString(getString(R.string.phone));
        final String placeWeb = bundle.getString(getString(R.string.web));
        final String placeEmail = bundle.getString(getString(R.string.email));
        final int placeImage = bundle.getInt(getString(R.string.picture));


        //Set the name of the category as the screen title
        this.setTitle(placeCategory);

        //Set the place name to the TextView
        TextView namePlaceView = findViewById(R.id.namePlaceDetail);
        namePlaceView.setText(placeName);

        //Set the place address to the TextView
        TextView addressPlaceView = findViewById(R.id.addressPlaceDetail);
        addressPlaceView.setText(placeAddress);


        //Set the place info to the TextView
        TextView infoPlaceView = findViewById(R.id.infoPlaceDetail);
        infoPlaceView.setText(placeInfo);

        //Set proper image
        ImageView imagePlaceView = findViewById(R.id.imagePlaceDetail);
        imagePlaceView.setImageResource(placeImage);

        //make a call with onClickListener
        ImageButton phonePlaceView = findViewById(R.id.phonePlaceDetail);

        phonePlaceView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final int REQUEST_PHONE_CALL = 1;

                String callNumber = getString(R.string.tel) + placePhone;

                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse(callNumber));

                // check for permission
                if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    if (ContextCompat.checkSelfPermission(PlaceDetailsLayoutActivity.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                        ActivityCompat.requestPermissions(PlaceDetailsLayoutActivity.this, new String[]{Manifest.permission.CALL_PHONE}, REQUEST_PHONE_CALL);
                    } else {
                        startActivity(callIntent);
                    }
                }
            }
        });

        //open web page with onClickListener
        ImageButton webPlaceView = findViewById(R.id.webPlaceDetail);

        webPlaceView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent web = new Intent(Intent.ACTION_VIEW);
                web.setData(Uri.parse(placeWeb));
                if (web.resolveActivity(getPackageManager()) != null) {
                    startActivity(web);
                }
            }
        });

        //create email with onClickListener
        ImageButton emailPlaceView = findViewById(R.id.emailPlaceDetail);

        emailPlaceView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent email = new Intent(Intent.ACTION_SEND);
                email.setData(Uri.parse("mailto:"));
                email.setType("text/plain");
                email.putExtra(Intent.EXTRA_EMAIL, placeEmail);
                email.putExtra(Intent.EXTRA_SUBJECT, getString(R.string.subject));

                if (email.resolveActivity(getPackageManager()) != null) {
                    startActivity(Intent.createChooser(email, "Send Email"));
                }
            }
        });

        //open maps  with onClickListener
        ImageButton gpsPlaceView = findViewById(R.id.gpsPlaceDetail);
        final String goToAddress = getString(R.string.goTo) + placeAddress;

        gpsPlaceView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gps = new Intent(Intent.ACTION_VIEW);
                gps.setData(Uri.parse(goToAddress));
                if (gps.resolveActivity(getPackageManager()) != null) {
                    startActivity(gps);
                }
            }
        });

    }
}
