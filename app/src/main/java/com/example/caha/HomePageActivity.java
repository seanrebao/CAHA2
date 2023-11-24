package com.example.caha;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.WindowManager;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomePageActivity extends AppCompatActivity {


    BottomNavigationView bottomNavigationView;
    HomeFragment homeFragment = new HomeFragment();
    RemoteFragment remoteFragment = new RemoteFragment();
    EnergyFragment energyFragment = new EnergyFragment();
    CalendarFragment calendarFragment = new CalendarFragment();
    SettingsFragment settingsFragment = new SettingsFragment();

    @Override
    public void onBackPressed() {
        moveTaskToBack(true);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        bottomNavigationView = findViewById(R.id.bottom_navigation);
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, homeFragment).commit();
        bottomNavigationView.setOnItemSelectedListener(new BottomNavigationView.OnItemSelectedListener(){

            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                if (item.getItemId()== R.id.home){
                    getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, homeFragment).commit();
                    return true;
                }
                if (item.getItemId()== R.id.remote) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, remoteFragment).commit();
                    return true;
                }
                if (item.getItemId()== R.id.energy) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, energyFragment).commit();
                    return true;
                }
                if (item.getItemId()== R.id.calendar) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, calendarFragment).commit();
                    return true;
                }
                if (item.getItemId()== R.id.settings) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, settingsFragment).commit();
                    return true;
                }
                return false;
            }
        });
    }
}