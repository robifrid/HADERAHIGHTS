package com.example.dor.mengroupapp;

import android.Manifest;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Start extends AppCompatActivity {
    LinearLayout lLayout;

    TextView tvConnected;
    EditText etMessage;
    private static final int  MY_PERMISSION_REQUEST_INTERNET = 1; // Internet access

    FirebaseDatabase myFireDatabase = FirebaseDatabase.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        etMessage = findViewById(R.id.etMessage);
        lLayout = findViewById(R.id.lLayout);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setIcon(R.mipmap.ic_launcher_round);






        int permissionCheck = ContextCompat.checkSelfPermission(this, Manifest.permission.INTERNET);
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.INTERNET) != PackageManager.PERMISSION_GRANTED){
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,Manifest.permission.INTERNET)){
                //Show an explanation to user *assync*
            }
            else{
                ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.INTERNET},MY_PERMISSION_REQUEST_INTERNET);
            }
        }
        ;

        tvConnected = findViewById(R.id.tvConnected);


        DatabaseReference messageRef = myFireDatabase.getReference("message");

        messageRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String message = dataSnapshot.getValue().toString();

                //etMessage.setText(message);

                Snackbar.make(lLayout, message, Snackbar.LENGTH_LONG)
                                        .setAction("Action", new View.OnClickListener() {
                                            @Override
                                            public void onClick(View v) {

                                            }
                                        }).show();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Toast.makeText(Start.this, "Cancelled", Toast.LENGTH_SHORT).show();

            }
        });
    }

    public void onRequestPermissionsResult (int requestCode,
                                            String[] permissions, int[] grantResults){
        switch (requestCode){
            case MY_PERMISSION_REQUEST_INTERNET:{
                if (grantResults.length>0
                    && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    // permission granted
                }
                else{
                    //permission denied! Disable functionality
                }
                return;
            }
            //other 'case' lines to check for more permissions
        }

    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        menu.add(getResources().getString(R.string.str_menu_about));
        menu.add(getResources().getString(R.string.str_menu_links));
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
            aboutAuthor();
            return true;
        }
        if (title == getResources().getString(R.string.str_menu_links)) {
            surfNet();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void aboutAuthor(){
        Intent goIntent = new Intent(this, About.class);
        startActivity(goIntent);
    }

    public void surfNet(){
        Intent goIntent = new Intent(this, Links.class);
        startActivity(goIntent);
    }

    public void goCheck(View view) {
       /* AlertDialog.Builder adb = new AlertDialog.Builder(this);
        final EditText et = new EditText(this);
        //final TextView item = new TextView(this);
        adb.setView(et);
        //adb.setView(item);
        adb.setTitle("Exit");
        adb.setMessage("Do you really want to quit ? ");
        adb.setPositiveButton("get ans", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String tmp = et.getText().toString();
                Toast.makeText(Start.this, tmp, Toast.LENGTH_SHORT).show();
            }
        });
        adb.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        AlertDialog ad = adb.create();
        ad.show();*/

        if (is_connected_found()){
            Toast.makeText(this,getResources().getString(R.string.str_toast_ok),Toast.LENGTH_SHORT).show();

            // Write a message to the database
            //FirebaseDatabase database = FirebaseDatabase.getInstance();
            DatabaseReference myRef = myFireDatabase.getReference("message");


            myRef.setValue(etMessage.getText().toString());
        }
    }

    private boolean is_connected_found()
    {
        ConnectivityManager myConnMgr = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = myConnMgr.getActiveNetworkInfo();

        boolean isConnected = false;
        if (networkInfo != null && (isConnected = networkInfo.isConnected())) {
            // show "Connected" & type of network "WIFI or MOBILE"
            tvConnected.setText(getResources().getString(R.string.str_conn)+networkInfo.getTypeName());
            // change background color to red
            tvConnected.setBackgroundColor(0xFF7CCC26);


        } else {
            // show "Not Connected"
            tvConnected.setText(getResources().getString(R.string.str_noconn));
            // change background color to green
            tvConnected.setBackgroundColor(0xFFFF0000);
        }

        return isConnected;

        /*if (networkinfo != null && networkinfo.isConnected()) {
            Toast.makeText(this, "OK", Toast.LENGTH_SHORT).show();
            return true;
        }
        else
            return false;*/
    }

    public void goQuit(View view) {




        finish();
    }

    public void goLinks(View view) {
        surfNet();

    }

    public void goLogin(View view) {
        Intent loginIntent = new Intent(this, Login.class);
        startActivity(loginIntent);
    }
}
