package com.diogomendes.sqldatabase1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.net.URL;

public class ProfileActivity extends AppCompatActivity {

    TextView txtViewName, txtViewEmail, txtViewPhone, txtViewJob, txtViewDegree;
    ImageView imgViewProfile, linkedinIcon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_view);

        setSupportActionBar(findViewById(R.id.toolbar));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        txtViewName = findViewById(R.id.txtProfileName);
        txtViewEmail = findViewById(R.id.txtProfileEmail);
        txtViewPhone = findViewById(R.id.txtProfilePhone);
        txtViewJob = findViewById(R.id.txtProfileJob);
        txtViewDegree = findViewById(R.id.txtProfileDegree);
        imgViewProfile = findViewById(R.id.imgViewProfile);
        linkedinIcon = findViewById(R.id.linkedin_icon);

        String name = getIntent().getStringExtra("NAME");
        String email = getIntent().getStringExtra("EMAIL");
        String phoneNumber = getIntent().getStringExtra("PHONE");
        String job = getIntent().getStringExtra("JOB");
        String degree = getIntent().getStringExtra("DEGREE");
        String linkedin = getIntent().getStringExtra("LINKEDIN");
        int img = getIntent().getIntExtra("IMAGE", 0);

        txtViewName.setText(name);
        txtViewEmail.setText(email);
        txtViewPhone.setText(phoneNumber);
        txtViewJob.setText(job);
        txtViewDegree.setText(degree);
        imgViewProfile.setImageResource(img);

        linkedinIcon.setOnClickListener(new View.OnClickListener() {
            public void onClick(View icon) {
                gotoURL(linkedin);
            }
        });

        // Add this method to your class



        /*
        linkedinIcon.setOnClickListener(new View.OnClickListener(){
            public void onClick(View icon){
                gotoURL(linkedin);
            }
        });

         */



    }

    private void openUrl(String url) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(url));

        PackageManager packageManager = getPackageManager();

        // Check if there's an app to handle this intent
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent);
        } else {
            // If no app is available, open the URL in a web browser
            Intent webIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
            if (webIntent.resolveActivity(packageManager) != null) {
                startActivity(webIntent);
            } else {
                Toast.makeText(this, "No app or browser to handle the URL", Toast.LENGTH_SHORT).show();
            }
        }
    }
    public void gotoURL(String url){
        Uri uri = Uri.parse(url);
        startActivity(new Intent(Intent.ACTION_VIEW,uri));
    }

}