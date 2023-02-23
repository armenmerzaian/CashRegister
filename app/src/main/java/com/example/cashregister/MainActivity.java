package com.example.cashregister;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;

    SearchFragment searchFragment = new SearchFragment();
    ScanFragment scanFragment = new ScanFragment();
    CartFragment cartFragment = new CartFragment();
    AdminFragment adminFragment = new AdminFragment();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Objects.requireNonNull(getSupportActionBar()).setTitle("Armen's Cash Store");

        ShoppingCart shoppingCart = ShoppingCart.getInstance();
        bottomNavigationView = findViewById(R.id.bottom_navigation);

        //TODO: refactor this using the strategy pattern
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, searchFragment).commit();
        BadgeDrawable badge = bottomNavigationView.getOrCreateBadge(R.id.navigation_cart);
        badge.setVisible(true);
        badge.setNumber(shoppingCart.getNumProducts());

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @SuppressLint("NonConstantResourceId")
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.navigation_search:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, searchFragment).commit();
                        return true;
                    case R.id.navigation_scan:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, scanFragment).commit();
                        return true;
                    case R.id.navigation_cart:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, cartFragment).commit();
                        return true;
                }
                return false;
            }
        });
    }
}