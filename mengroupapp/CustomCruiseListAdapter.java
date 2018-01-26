package com.example.dor.mengroupapp;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.dor.mengroupapp.CruiseObj;
import com.example.dor.mengroupapp.R;

import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.List;

/**
 * Created by Dor on 08/01/2018.
 */

public class CustomCruiseListAdapter extends ArrayAdapter<CruiseObj> {
    Activity context;
    List<CruiseObj> cruises;
    public CustomCruiseListAdapter(@NonNull Activity context, @NonNull List<CruiseObj> objects) {
        super(context, R.layout.cruise_row, objects);
        this.context = context;
        this.cruises = objects;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflate = context.getLayoutInflater();
        View rowView = inflate.inflate(R.layout.cruise_row, null, true);
        CruiseObj cruise = cruises.get(position);

        //populate one row of the cruise row XML

        TextView tvRound = rowView.findViewById(R.id.tvRound);
        tvRound.setText(cruise.getCRU_round().toString());
        tvRound.setBackgroundColor(cruise.getCRU_color());

        TextView tvReserv = rowView.findViewById(R.id.tvReservation);
        tvReserv.setText(cruise.getCRU_reservation().toString());

        TextView tvSkipper = rowView.findViewById(R.id.tvSkipper);
        tvSkipper.setText(cruise.getCRU_user_code().toString()); // later to translate
        // code to skipper name

        TextView tvDate = rowView.findViewById(R.id.tvDate);

        // DD/MM/YYYY/HH:MM
        StringBuilder s = new StringBuilder();
        int day = cruise.getCRU_date().get(Calendar.DAY_OF_MONTH);
        if (day < 10)
            s.append(0);
        s.append(day).append('/');
        int month = cruise.getCRU_date().get(Calendar.MONTH) + 1;
        if (month < 10)
            s.append(0);
        s.append(month).append('/');
        int year = cruise.getCRU_date().get(Calendar.YEAR);
        s.append(year).append('/');
        /*int hour = cruise.getCRU_date().get(Calendar.HOUR_OF_DAY);
        if (hour < 10)
            s.append(0);
        s.append(hour).append(':');
        int minute = cruise.getCRU_date().get(Calendar.MINUTE);
        if (minute < 10)
            s.append(0);
        s.append(minute);*/

        tvDate.setText(s.toString());
        return rowView;
    }
}
