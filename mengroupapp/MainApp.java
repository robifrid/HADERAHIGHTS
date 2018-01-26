package com.example.dor.mengroupapp;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

public class MainApp extends AppCompatActivity implements AdapterView.OnItemClickListener{

    ListView lvCruises;
    ArrayList<CruiseObj> cruises = new ArrayList<CruiseObj>();

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_app);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        lvCruises = findViewById(R.id.lvCruises);

        Calendar localDate = Calendar.getInstance();
        Calendar localTime = Calendar.getInstance();

        populateList(cruises);
        CustomCruiseListAdapter adp = new CustomCruiseListAdapter(this, cruises);



        lvCruises.setAdapter(adp);
        lvCruises.setOnItemClickListener(this);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent newCruise = new Intent(MainApp.this, AddCruise.class);
                startActivity(newCruise);

            }
        });
    }

    // LocalTime from_hour, LocalTime to_hour, Integer round, Integer user_code)


    @RequiresApi(api = Build.VERSION_CODES.O)
    private void populateList(List<CruiseObj> cruises) {
        // init DUMMY parameters
        String[] Skippers = {"Menahem", "Robi", "David", "Diego", "Uri", "Eitan"};
        int[] mColors = {Color.CYAN, Color.MAGENTA, Color.GRAY, Color.YELLOW};
        Random rnd = new Random();
        int round = 127, members = 6, count = 1, color , reserv = 65;
        color=rnd.nextInt(4);

        // read all data from database and populate the list
        for (int i=1;i<20;i++){
            if (i%members == 0){
                count=0;
                round+=1;
                color = (color + 1) % 4;
            }
            count++;
            CruiseObj demoCruise = new CruiseObj(12, reserv, Calendar.getInstance(), Calendar.getInstance(),Calendar.getInstance(),round,Skippers[count-1], mColors[color]);
            cruises.add(demoCruise);
            reserv+=rnd.nextInt(3);
        }
        //CruiseObj demoCruise1 = new CruiseObj(12, Calendar.getInstance(), Calendar.getInstance(),Calendar.getInstance(),3,1, Color.GREEN);
        //cruises.add(demoCruise1);
        //CruiseObj demoCruise2 = new CruiseObj(12, Calendar.getInstance(), Calendar.getInstance(),Calendar.getInstance(),3,3, Color.BLUE);
        //if (cruises.add(demoCruise2)){
        //    Toast.makeText(MainApp.this,"success",Toast.LENGTH_SHORT).show();
        //};
        // return cruises;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        //menu.add(getResources().getString(R.string.str_menu_about));
        //menu.add(getResources().getString(R.string.str_menu_links));
        // menu.add("Planner");

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
        if (id == R.id.action_settings) {
            return true;
        }

        if (title == getResources().getString(R.string.str_menu_about)) {
            //aboutAuthor();
            return true;
        }
        if (title == getResources().getString(R.string.str_menu_links)) {
            //surfNet();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent goShowCruise = new Intent(this, ShowCruise.class);
        goShowCruise.putExtra("pos",position);
        startActivity(goShowCruise);


    }
}
