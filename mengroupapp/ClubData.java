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
import android.webkit.WebView;
import android.widget.Toast;

public class ClubData extends AppCompatActivity {
    WebView ww;

    String[] URLS;

    String[] urls;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_club_data);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ww=findViewById(R.id.ww);
        ww.getSettings().setJavaScriptEnabled(true);
        ww.setWebViewClient(new myWebViewClient());
        URLS = getResources().getStringArray(R.array.URLS);
        urls = getResources().getStringArray(R.array.urls);

        Intent toDoIntent = getIntent();
        String task = toDoIntent.getStringExtra("todo");

        for (int i=0;i<URLS.length;i++){
            if (task.equals(urls[i]))
                ww.loadUrl(URLS[i]);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.club, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.back) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
