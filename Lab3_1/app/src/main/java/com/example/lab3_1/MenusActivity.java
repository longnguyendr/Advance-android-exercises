package com.example.lab3_1;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MenusActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menus);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.bgcolor, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.Blue:
                Toast.makeText(this, "Blue", Toast.LENGTH_SHORT).show();
                setBackgroundColor(Color.BLUE);
                return true;
            case R.id.Green:
                Toast.makeText(this, "Green", Toast.LENGTH_SHORT).show();
                setBackgroundColor(Color.GREEN);
                return true;
            case R.id.Red:
                Toast.makeText(this, "Red", Toast.LENGTH_SHORT).show();
                setBackgroundColor(Color.RED);
                return true;
            case R.id.Yellow:
                Toast.makeText(this, "Yellow", Toast.LENGTH_SHORT).show();
                setBackgroundColor(Color.YELLOW);
                return true;
            default:
                return false;
        }

    }
    public void setBackgroundColor (int color) {
        View view = this.getWindow().getDecorView();
        view.setBackgroundColor(color);
    }

}
