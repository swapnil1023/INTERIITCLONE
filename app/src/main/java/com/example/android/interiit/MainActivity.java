package com.example.android.interiit;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.app.DownloadManager;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener  {


    private AppBarConfiguration mAppBarConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //setSupportActionBar(toolbar);





        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        //drawer.bringToFront();
        //drawer.requestLayout();
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        //navigationView.set
       navigationView.bringToFront();
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_score, R.id.nav_schedule,
                R.id.nav_bus, R.id.nav_help)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
       // displaySelectedScreen(R.id.nav_home);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {


        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
   // @SuppressWarnings("StatementWithEmptyBody")

   @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

       int id = item.getItemId();

       //noinspection SimplifiableIfStatement
       if (id == R.id.action_settings) {
           return true;
       }
        return super.onOptionsItemSelected(item);
    }
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
    @SuppressWarnings("StatementWithEmptyBody")
     @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        int id=menuItem.getItemId();
        FragmentManager fm=getSupportFragmentManager();
        fm.popBackStack();
        switch (id) {
           case R.id.nav_home:
               setTitle("Home");

               androidx.fragment.app.FragmentTransaction ft1 = (androidx.fragment.app.FragmentTransaction)getSupportFragmentManager().beginTransaction();
               FrameLayout fl1=findViewById(R.id.nav_host_fragment);
               fl1.removeAllViews();
               ft1.replace(R.id.nav_host_fragment, new HomeFragment());
               ft1.commit();
               break;
           case R.id.nav_score:
               setTitle("Scores");
               androidx.fragment.app.FragmentTransaction ft2 = (androidx.fragment.app.FragmentTransaction)getSupportFragmentManager().beginTransaction();
               FrameLayout fl2=findViewById(R.id.nav_host_fragment);
               fl2.removeAllViews();
               ft2.replace(R.id.nav_host_fragment, new ScoreFragment());
               ft2.commit();
               break;
           case R.id.nav_schedule:
               setTitle("Schedule");
               androidx.fragment.app.FragmentTransaction ft3 = (androidx.fragment.app.FragmentTransaction)getSupportFragmentManager().beginTransaction();
               FrameLayout fl3=findViewById(R.id.nav_host_fragment);
               fl3.removeAllViews();
               ft3.replace(R.id.nav_host_fragment, new ScoreFragment());
               ft3.commit();
               break;

           case R.id.nav_map:
               setTitle("Campus Map");
               androidx.fragment.app.FragmentTransaction ft4 = (androidx.fragment.app.FragmentTransaction)getSupportFragmentManager().beginTransaction();
               FrameLayout fl4=findViewById(R.id.nav_host_fragment);
               fl4.removeAllViews();
               ft4.replace(R.id.nav_host_fragment, new MapFragment());
               ft4.commit();
               break;


           case R.id.nav_bus:
               setTitle("Bus");
               androidx.fragment.app.FragmentTransaction ft5 = (androidx.fragment.app.FragmentTransaction)getSupportFragmentManager().beginTransaction();
               FrameLayout fl5=findViewById(R.id.nav_host_fragment);
               DownloadManager downloadmanager = (DownloadManager) getSystemService(Context.DOWNLOAD_SERVICE);
               Uri uri = Uri.parse("https://www.iitbbs.ac.in/transportation-fle/transport_1572912511.pdf");

               DownloadManager.Request request = new DownloadManager.Request(uri);
               request.setTitle("My File");
               request.setDescription("Downloading");
               request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
               request.setVisibleInDownloadsUi(false);
               request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, "Transportation.pdf");

               downloadmanager.enqueue(request);

               fl5.removeAllViews();
               ft5.replace(R.id.nav_host_fragment, new ScoreFragment());
               ft5.commit();
               break;

           case R.id.nav_help:
               setTitle("Help");
               androidx.fragment.app.FragmentTransaction ft6= (androidx.fragment.app.FragmentTransaction)getSupportFragmentManager().beginTransaction();
               FrameLayout fl6=findViewById(R.id.nav_host_fragment);
               fl6.removeAllViews();
               ft6.replace(R.id.nav_host_fragment, new ScoreFragment());
               ft6.commit();
               break;

       }

       DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
       drawer.closeDrawer(GravityCompat.START);
        return true;

    }


}