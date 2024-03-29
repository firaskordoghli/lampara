package com.example.smartbuoy;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.smartbuoy.DATA.UserSessionManager;
import com.example.smartbuoy.UI.Menu.Event.EventsFragment;
import com.example.smartbuoy.UI.Menu.HomeFragment;
import com.example.smartbuoy.UI.Menu.NotificationFragment;
import com.example.smartbuoy.UI.Menu.Profile.ProfileFragment;
import com.example.smartbuoy.lib.FluidBottomNavigation;
import com.example.smartbuoy.lib.FluidBottomNavigationItem;
import com.example.smartbuoy.lib.listener.OnTabSelectedListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    // User Session Manager Class
    private UserSessionManager session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Session class instance
        session = new UserSessionManager(getApplicationContext());

        // Check user login (this is the important point)
        // If User is not logged in , This will redirect user to LoginActivity
        // and finish current activity from activity stack.
        if (session.checkLogin())
            finish();
/*
        Gson gson = new Gson();
        // get user data from session

        String json = session.getUserDetails();
        User user = gson.fromJson(json,User.class);
        System.out.println("$$$$$$$$$$$$$$$$$"+user.toString());
        */

        FluidBottomNavigation navigation = findViewById(R.id.bottomNavigationView);

        ArrayList<FluidBottomNavigationItem> array = new ArrayList<>();
        array.add(new FluidBottomNavigationItem("Home", getDrawable(R.drawable.ic_home_icon_blanc)));
        array.add(new FluidBottomNavigationItem("Events", getDrawable(R.drawable.ic_event_icon_blanc)));
        array.add(new FluidBottomNavigationItem("Notification", getDrawable(R.drawable.ic_notif_blanc)));
        array.add(new FluidBottomNavigationItem("Profile", getDrawable(R.drawable.ic_profile_blanc_1)));
        navigation.setItems(array);


        navigation.setOnTabSelectedListener(new OnTabSelectedListener() {
            @Override
            public void onTabSelected(int position) {
                Fragment selectedFragment = new HomeFragment();
                switch (position) {
                    case 0:
                        selectedFragment = new HomeFragment();
                        break;
                    case 1:
                        selectedFragment = new EventsFragment();
                        break;
                    case 2:
                        selectedFragment = new NotificationFragment();
                        break;
                    case 3:
                        selectedFragment = new ProfileFragment();

                        break;
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment).commit();
            }
        });
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new HomeFragment()).commit();
    }
}
