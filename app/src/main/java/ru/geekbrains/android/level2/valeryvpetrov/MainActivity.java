package ru.geekbrains.android.level2.valeryvpetrov;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater()
                .inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_add:
                actionAdd();
                return true;
            case R.id.action_edit:
                actionEdit();
                return true;
            case R.id.action_delete:
                actionDelete();
                return true;
            case R.id.action_settings:
                actionSettings();
                return true;
            case R.id.action_about:
                actionAbout();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void actionAdd() {
        Toast.makeText(this,
                getResources().getString(R.string.action_add),
                Toast.LENGTH_SHORT)
                .show();
    }

    private void actionEdit() {
        Toast.makeText(this,
                getResources().getString(R.string.action_edit),
                Toast.LENGTH_SHORT)
                .show();
    }

    private void actionDelete() {
        Toast.makeText(this,
                getResources().getString(R.string.action_delete),
                Toast.LENGTH_SHORT)
                .show();
    }

    private void actionSettings() {
        Toast.makeText(this,
                getResources().getString(R.string.action_settings),
                Toast.LENGTH_SHORT)
                .show();
    }

    private void actionAbout() {
        Toast.makeText(this,
                getResources().getString(R.string.action_about),
                Toast.LENGTH_SHORT)
                .show();
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_tools) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
}
