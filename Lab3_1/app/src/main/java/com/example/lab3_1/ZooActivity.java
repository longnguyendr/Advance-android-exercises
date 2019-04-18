package com.example.lab3_1;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

public class ZooActivity extends AppCompatActivity implements View.OnClickListener {
    ImageView imgWolf, imgBear, imgElephant, imgSheep;
    TextView txtSheep, txtWolf;
    Boolean Mamals = true;
    MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zoo);
        imgWolf = findViewById(R.id.img4);
        imgWolf.setOnClickListener(this);
        imgBear = findViewById(R.id.img2);
        imgBear.setOnClickListener(this);
        imgElephant = findViewById(R.id.img1);
        imgElephant.setOnClickListener(this);
        imgSheep = findViewById(R.id.img3);
        imgSheep.setOnClickListener(this);
        txtSheep = findViewById(R.id.textSheep);
        txtWolf = findViewById(R.id.textWolf);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.bgimg ,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        String Types;
        stopPlaying();
        switch (item.getItemId()) {
            case R.id.Bird:
                Types = "bird";
                createImg(Types);
                Mamals = false;
                return true;
            case R.id.Mamals:
                Types = "mamals";
                createImg(Types);
                Mamals = true;
                return true;
                default:
                    return false;
        }

    }

    protected void createImg (String Types) {
        if (Types.equals("bird")) {
            imgElephant.setImageResource(R.drawable.huuhkaja);
            imgBear.setImageResource(R.drawable.peippo);
            imgSheep.setImageResource(R.drawable.peukaloinen);
            imgWolf.setImageResource(R.drawable.punatulkku);
            txtSheep.setText("Peukaloinen");
            txtWolf.setText("Punatulkku");

        } else if (Types.equals("mamals")) {
            imgElephant.setImageResource(R.drawable.elephant);
            imgBear.setImageResource(R.drawable.bear);
            imgSheep.setImageResource(R.drawable.lamb);
            imgWolf.setImageResource(R.drawable.wolf);
            txtSheep.setText(R.string.Sheep);
            txtWolf.setText(R.string.Wolf);
        }
    }
    @Override
    public void onClick(View view) {
        stopPlaying();
        switch (view.getId()) {
            case R.id.img1:
                AnimalsImg1();
                break;
            case R.id.img2:
                AnimalsImg2();
                break;
            case R.id.img3:
                AnimalsImg3();
                break;
            case R.id.img4:
                AnimalsImg4();
                break;
                default: break;
        }
    }

    protected void AnimalsImg1 () {
        if (Mamals) {
            mediaPlayer = MediaPlayer.create(this, R.raw.elephant);
            mediaPlayer.start();
        } else {
            mediaPlayer = MediaPlayer.create(this, R.raw.huuhkaja_norther_eagle_owl);
            mediaPlayer.start();
        }
    }
    protected void AnimalsImg2 () {
        if (Mamals) {
            mediaPlayer = MediaPlayer.create(this, R.raw.bear);
            mediaPlayer.start();
        } else {
            mediaPlayer = MediaPlayer.create(this, R.raw.peippo_chaffinch);
            mediaPlayer.start();
        }
    }
    protected void AnimalsImg3 () {
        if (Mamals) {
            mediaPlayer = MediaPlayer.create(this, R.raw.lamb);
            mediaPlayer.start();
        } else {
            mediaPlayer = MediaPlayer.create(this, R.raw.peukaloinen_wren);
            mediaPlayer.start();
        }
    }
    protected void AnimalsImg4 () {
        if (Mamals) {
            mediaPlayer = MediaPlayer.create(this, R.raw.wolf);
            mediaPlayer.start();
        } else {
            mediaPlayer = MediaPlayer.create(this, R.raw.punatulkku_northern_bullfinch);
            mediaPlayer.start();
        }
    }

    private void stopPlaying() {
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }
}
