package com.example.pavneet.techguru;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.ViewFlipper;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback{

    GoogleMap gmap;
    ViewPager viewPager;
    CustomSliderAdapter adapter;
    Thread thread;
    int val=0;
    ImageButton register;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);


        register= (ImageButton) findViewById(R.id.register);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,Registration.class);
                startActivity(intent);
            }
        });
       MapFragment mapFragment= (MapFragment) getFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        viewPager= (ViewPager) findViewById(R.id.slider);
        adapter=new CustomSliderAdapter(this);
        viewPager.setAdapter(adapter);
        Timer tm=new Timer();
        tm.schedule(new MyTimer(),1000,5000);

    }

    public class MyTimer extends TimerTask{

        @Override
        public void run() {

            MainActivity.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if(val==6)
                        val=0;
                    viewPager.setCurrentItem(val++);

                }
            });
        }
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        CameraPosition cm=new CameraPosition(new LatLng(30.356552,78.0825903),10,10,2);
        gmap=googleMap;
        gmap.addMarker(new MarkerOptions().position(new LatLng(30.356552,78.0825903)).title("Cynoteck Technologies,Dehradun")).showInfoWindow();
        gmap.animateCamera(CameraUpdateFactory.newCameraPosition(cm), 2000,null);
        gmap.addMarker(new MarkerOptions().position(new LatLng(30.336201,77.9586233)).title("HiTech Guru,PremNagar,Dehradun")).showInfoWindow();
    }


}
