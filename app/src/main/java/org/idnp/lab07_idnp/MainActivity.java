package org.idnp.lab07_idnp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;

import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import org.idnp.lab07_idnp.R;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;

    FragmentHome fragmentHome = new FragmentHome();
    FragmentNotifications fragmentNotifications = new FragmentNotifications();
    FragmentStatistics fragmentStatistics = new FragmentStatistics();
    FragmentPlastics fragmentPlastics = new FragmentPlastics();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottom_navigation);
        getSupportFragmentManager().beginTransaction().replace(R.id.container,fragmentHome).commit();



        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.home:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, fragmentHome).commit();
                        return true;
                    case R.id.notification:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, fragmentNotifications).commit();
                        return true;
                    case R.id.statistics:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, fragmentStatistics).commit();
                        return true;
                    case R.id.plastic:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, fragmentPlastics).commit();
                        return true;
                }
                return false;
            }
        });
    }
}