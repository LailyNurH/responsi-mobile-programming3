package com.laily.responsimp3.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.util.Log;
import android.view.WindowManager;

import com.ismaeldivita.chipnavigation.ChipNavigationBar;
import com.laily.responsimp3.Fragment.HistoryFragment;
import com.laily.responsimp3.Fragment.HomeFragment;
import com.laily.responsimp3.Fragment.PaymentFragment;
import com.laily.responsimp3.Fragment.SettingFragment;
import com.laily.responsimp3.R;

import static android.content.ContentValues.TAG;

public class HomeActivity extends AppCompatActivity {
    ChipNavigationBar BottomNav;
    private long backPressedTime;
    private Fragment fragment = null;
    FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);


        BottomNav = findViewById(R.id.bottomBar);
        if (savedInstanceState == null) {
            BottomNav.setItemSelected(R.id.home, true);
            fragmentManager = getSupportFragmentManager();
            HomeFragment homeFragment = new HomeFragment();
            fragmentManager.beginTransaction()
                    .replace(R.id.container, homeFragment)
                    .commit();
        }
        BottomNav.setOnItemSelectedListener(new ChipNavigationBar.OnItemSelectedListener() {
            @Override
            public void onItemSelected(int i) {
                Fragment fragment = null;

                switch (i) {
                    case R.id.item1:
                        fragment = new HomeFragment();
                        break;

                    case R.id.item2:
                        fragment = new PaymentFragment();
                        break;

                    case R.id.item3:
                        fragment = new HistoryFragment();
                        break;
                    case R.id.item4:
                        fragment = new SettingFragment();
                        break;

                }
                if (fragment != null) {
                    fragmentManager = getSupportFragmentManager();
                    fragmentManager.beginTransaction()
                            .replace(R.id.container, fragment)
                            .commit();

                } else {
                    Log.e(TAG, "Error in creating fragment");
                }

            }
        });
    }


    @Override
    public void onBackPressed() {
        finish();
        super.onBackPressed();


    }
}