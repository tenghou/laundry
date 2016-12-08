package sg.edu.nus.laundry;

/**
 * Created by hugh on 2015-07-23.
 */

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class CartActivity extends FragmentActivity implements OnMapReadyCallback {

    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);


        TextView close = (TextView)findViewById(R.id.close);
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*intent = new Intent(CartActivity.this, MainActivity.class);
                startActivity(intent);*/
                onBackPressed();
            }
        });

    }

    @Override
    public void onMapReady(GoogleMap map) {
        // Add a marker in NUS soc 1.2950238483,103.7738916278
        LatLng nus = new LatLng(1.2950, 103.7738);
        map.addMarker(new MarkerOptions().position(nus).title("You are here"));
        map.setMyLocationEnabled(true);
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(nus, 20));
        map.animateCamera(CameraUpdateFactory.zoomTo(16), 2000, null);

        map.setOnMyLocationButtonClickListener(new GoogleMap.OnMyLocationButtonClickListener() {
            @Override
            public boolean onMyLocationButtonClick() {
                /**
                 * Click this button
                 * the address info will be auto filled with current address info
                 */

                EditText addressline1 = (EditText)findViewById(R.id.addressLine1);
                EditText addressline2 = (EditText)findViewById(R.id.addressLine2);
                EditText postcode = (EditText)findViewById(R.id.postcode);

                addressline1.setText("13 Computing Drive, Building COM1");
                addressline2.setText("#03-68");
                postcode.setText("117417");

                /**
                 * after these necessary info been filled
                 * change the color of the place order button to show that it can be pressed
                 */
                Button placeButton = (Button)findViewById(R.id.placeOrder);
                placeButton.setBackgroundColor(Color.parseColor("#0087de"));

                return false;
            }
        });

        UiSettings us = map.getUiSettings();
        us.setZoomControlsEnabled(true);

    }






}

