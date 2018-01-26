package com.example.dor.mengroupapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RadioButton;

public class Links extends AppCompatActivity {
    int[] rb={R.id.rb1, R.id.rb2, R.id.rb3, R.id.rb4, R.id.rb5, R.id.rb6};
    RadioButton[] radioButton;
    String[] URLs; // = {"Club", "Planner", "WindFinder", "Isramar", "CloudRadar", "AccuWeather"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_links);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        URLs = getResources().getStringArray(R.array.urls);
        radioButton = new RadioButton[rb.length];
        for (int i=0;i<rb.length;i++){
            radioButton[i] = findViewById(rb[i]);
        }

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.club, menu);
        //menu.add("Back");


        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        String title = item.getTitle().toString();

        //noinspection SimplifiableIfStatement
        if (id == R.id.back) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void goView(View view) {

        for (int i=0;i<rb.length;i++){
            if (radioButton[i].isChecked()){
                Intent URLIntent = new Intent(this, ClubData.class);
                URLIntent.putExtra("todo",URLs[i]);
                startActivity(URLIntent);

            }
        }

    }

    public void goBack(View view) {
        finish();
    }
}
