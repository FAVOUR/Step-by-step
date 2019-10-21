package com.example.step_by_step;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.collection.ArraySet;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.NavHost;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

import java.util.LinkedHashSet;
import java.util.Set;

public class MainActivity extends AppCompatActivity {


    AppBarConfiguration appBarConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


//        Toolbar toolbar = findViewById(R.id.toolbar);
//                setSupportActionBar(toolbar);


        NavHostFragment navHost =(NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment);

        NavController navController =navHost.getNavController();

        setButtomNav(navController);

        setNavView(navController);

        setupAppBarConfig();

        setUpNav(navController);

        setUpActionBar(appBarConfiguration,navController);




    }

    private void setUpActionBar(AppBarConfiguration appBarConfiguration, NavController navController) {
         if(appBarConfiguration !=null && navController != null)
       NavigationUI.setupActionBarWithNavController(this,navController,appBarConfiguration);
    }

    private void setUpNav(NavController navController) {

        NavigationView navigationView = findViewById(R.id.nav_view);

        if(navigationView !=null){
            NavigationUI.setupWithNavController(navigationView,navController);
        }
    }

    public void setupAppBarConfig() {
        DrawerLayout drawerLayout = findViewById(R.id.drawable_Layout);
        Set<Integer>integers =new ArraySet<>();

        if(drawerLayout !=null) {
            integers.add(R.id.homeFragment);
            integers.add(R.id.nextPage);
            appBarConfiguration = new AppBarConfiguration.Builder(integers)
                    .setDrawerLayout(drawerLayout)
                    .setFallbackOnNavigateUpListener(new AppBarConfiguration.OnNavigateUpListener() {
                        @Override
                        public boolean onNavigateUp() {
                            return false;
                        }
                    })
                    .build();

        }

    }

    private void setNavView(NavController navController) {

        NavigationView navigationView = findViewById(R.id.nav_view);


        if(navigationView != null)
        NavigationUI.setupWithNavController(navigationView,navController);
    }



    public void setButtomNav(NavController navController){
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_nav);
        if(bottomNavigationView != null)
        NavigationUI.setupWithNavController(bottomNavigationView,navController);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

//        menu.add(R.menu.bottom_nav_elemet)
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        return super.onOptionsItemSelected(item);
    }
}
