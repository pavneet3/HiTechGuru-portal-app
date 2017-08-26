package com.example.pavneet.techguru;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Details extends AppCompatActivity {

    String title;
    TextView header;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        title=getIntent().getStringExtra("Course_name").toString();
        header= (TextView) findViewById(R.id.header);
        header.setText(title);
    }
}
