package com.mme.saif_win10.businessresearch;

import androidx.room.Room;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;

import com.google.android.gms.ads.MobileAds;
import com.google.android.material.navigation.NavigationView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.mme.saif_win10.businessresearch.mcqRoomDatabase.McqRecV;
import com.mme.saif_win10.businessresearch.mcqRoomDatabase.Mcq_Database;
import com.mme.saif_win10.businessresearch.memorizeRoomDatabase.MemorizeRecV;

/**
 * This is main method
 * @author Saiful Islam
 * @since 12 March 2020
 * @version 2.1
 */

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    public static Mcq_Database mcq_database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mcq_database = Room.databaseBuilder(getApplicationContext(), Mcq_Database.class, "McqDb").
                allowMainThreadQueries().build();


        isNetworkExist();

        //initializing ad - admob - need to be done only once
        MobileAds.initialize(this, initializationStatus -> {
        });

        DrawerLayout drawer = findViewById(R.id.drawer_layout);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment,
                    new OptionsMain()).commit();
        }
    }

    /**
     * calling {@link CheckingNetwork} and checking if network exist
     */
    private void isNetworkExist() {
        CheckingNetwork checkingNetwork = new CheckingNetwork(getApplicationContext());
        checkingNetwork.notifyUser(checkingNetwork.isNetworkAvailable());
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        }else
            super.onBackPressed();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.instruction) {
            //Option Main to instruction Fragment Transaction
            getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment,
                    new InstructionFragment()).addToBackStack("null").commit();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.home) {
            getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment,
                    new OptionsMain()).addToBackStack("null").commit();
        } else if (id == R.id.memorize) {
            getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment,
                    new MemorizeRecV()).addToBackStack("null").commit();
        } else if (id == R.id.mcq) {
            getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment,
                    new McqRecV()).addToBackStack("null").commit();
        } else if (id == R.id.privacy_policy) {
            getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment,
                    new Privacy_Policy()).addToBackStack("null").commit();
        } else if (id == R.id.nav_share) {

            String message = "Text I want to share.";
            Intent share = new Intent(Intent.ACTION_SEND);
            share.setType("text/plain");
            share.putExtra(Intent.EXTRA_TEXT, message);

            startActivity(Intent.createChooser(share, "Title of the dialog the system will open"));

        } else if (id == R.id.nav_send) {

            Intent i = new Intent(Intent.ACTION_SEND);
            i.setType("text/plain");
            i.putExtra(Intent.EXTRA_EMAIL  , new String[]{"eee.videotutorial@gmail.com"});
            i.putExtra(Intent.EXTRA_SUBJECT, "subject of email");
            i.putExtra(Intent.EXTRA_TEXT   , "body of email");
            try {
                startActivity(Intent.createChooser(i, "Send mail..."));
            } catch (android.content.ActivityNotFoundException ex) {
                Toast.makeText(this, "There are no email clients installed.", Toast.LENGTH_SHORT).show();
            }
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

}

