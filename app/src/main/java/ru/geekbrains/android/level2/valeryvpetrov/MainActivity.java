package ru.geekbrains.android.level2.valeryvpetrov;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
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
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nav_home:
            case R.id.nav_gallery:
            case R.id.nav_slideshow:
            case R.id.nav_tools:
            case R.id.nav_help:
            case R.id.nav_feedback:
            case R.id.nav_about_app:
            case R.id.nav_about_developer:
                uncheckPrevItem();
                checkCurrentItem(item);
                break;
            case R.id.nav_share:
            case R.id.nav_send:
                uncheckPrevItem();
                break;
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void uncheckPrevItem() {
        NavigationView navigationView = findViewById(R.id.nav_view);
        MenuItem checkedItem = navigationView.getCheckedItem();

        if (checkedItem != null) {
            checkedItem.setChecked(false);
            colorNavDrawerMenuItem(checkedItem,
                    R.color.colorTextUnhighlight,
                    R.color.colorIconUnhighlight);
        }
    }

    private void checkCurrentItem(@NonNull MenuItem item) {
        item.setChecked(true);
        colorNavDrawerMenuItem(item,
                R.color.colorTextHighlight,
                R.color.colorIconHighlight);
    }

    private void colorNavDrawerMenuItem(@NonNull MenuItem item, int textColorId, int iconColorId) {
        // change text color
        SpannableString spannableString = new SpannableString(item.getTitle().toString());
        spannableString.setSpan(
                new ForegroundColorSpan(getResources().getColor(textColorId)),
                0, spannableString.length(), 0);
        item.setTitle(spannableString);
        // change icon color
        item.getIcon().setColorFilter(getResources().getColor(iconColorId),
                PorterDuff.Mode.SRC_ATOP);
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
