package ru.geekbrains.android.level2.valeryvpetrov;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
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
}
