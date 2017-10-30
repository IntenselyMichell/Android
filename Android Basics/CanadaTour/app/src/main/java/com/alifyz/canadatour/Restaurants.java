package com.alifyz.canadatour;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Restaurants extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_container);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.viewpager_root, new RestaurantsFragment())
                .commit();
    }
}