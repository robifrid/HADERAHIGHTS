package com.example.dor.mengroupapp;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Dor on 08/01/2018.
 */

public class CruiseObj {
    private Integer CRU_number;  // auto increment primary key
    private Integer CRU_reservation; // a number obtained from the CLUB reservation WEB site
    private Calendar CRU_date;
    private Calendar CRU_from_hour;
    private Calendar CRU_to_hour;
    private Integer CRU_round;  // number of round (increments after all members finished a round)
    private String CRU_ship;  // ship name, default value Toma
    private String CRU_took_place;  //
    private String CRU_user_code;  // responsible skipper
    private Integer CRU_new_number;  // CRU_number of postponed cruise
    private String CRU_comments;
    private String CRU_notes;
    private String CRU_weather;
    private Integer CRU_color;  // color to use for different cruise status
    private String CRU_media; // connected media
    private String CRU_menu; //connected menu
    private String CRU_guests; // connected guests


    public CruiseObj(Integer number, Integer reserv, Calendar date, Calendar from_hour, Calendar to_hour, Integer round, String user_code, Integer color){
        this.CRU_number = number;
        this.CRU_reservation = reserv;
        this.CRU_date = date;
        this.CRU_from_hour = from_hour;
        this.CRU_to_hour = to_hour;
        this.CRU_round = round;
        this.CRU_ship = "Toma";
        this.CRU_took_place = "P"; // planned cruise
        this.CRU_user_code = user_code;
        this.CRU_new_number = 0;
        this.CRU_notes = "";
        this.CRU_weather = "";
        this.CRU_comments = "";
        this.CRU_color = color; // planned cruise color
        this.CRU_media = "N";
        this.CRU_menu = "N";
        this.CRU_guests ="N";
    }

    public Integer getCRU_number() {
        return CRU_number;
    }

    public void setCRU_number(Integer number) {
        this.CRU_number = number;
    }

    public Integer getCRU_reservation() {
        return CRU_reservation;
    }

    public void setCRU_reservation(Integer reservation) {
        this.CRU_reservation = reservation;
    }

    public Calendar getCRU_date() {
        return CRU_date;
    }

    public void setCRU_date(Calendar date) {
        this.CRU_date = date;
    }

    public Calendar getCRU_from_hour() {
        return CRU_from_hour;
    }

    public void setCRU_from_hour(Calendar from_hour) {
        this.CRU_from_hour = from_hour;
    }

    public Calendar getCRU_to_hour() {
        return CRU_to_hour;
    }

    public void setCRU_to_hour(Calendar to_hour) {
        this.CRU_to_hour = to_hour;
    }

    public Integer getCRU_round() {
        return CRU_round;
    }

    public void setCRU_round(Integer round) {
        this.CRU_round = round;
    }

    public String getCRU_ship() {
        return CRU_ship;
    }

    public void setCRU_ship(String ship) {
        this.CRU_ship = ship;
    }

    public String getCRU_took_place() {
        return CRU_took_place;
    }

    public void setCRU_took_place(String took_place) {
        this.CRU_took_place = took_place;
    }

    public String getCRU_user_code() {
        return CRU_user_code;
    }

    public void setCRU_user_code(String user_code) {
        this.CRU_user_code = user_code;
    }

    public Integer getCRU_new_number() {
        return CRU_new_number;
    }

    public void setCRU_new_number(Integer new_number) {
        this.CRU_new_number = new_number;
    }

    public String getCRU_comments() {
        return CRU_comments;
    }

    public void setCRU_comments(String comments) {
        this.CRU_comments = comments;
    }

    public String getCRU_notes() {
        return CRU_notes;
    }

    public void setCRU_notes(String notes) {
        this.CRU_notes = notes;
    }

    public String getCRU_weather() {
        return CRU_weather;
    }

    public void setCRU_weather(String weather) {
        this.CRU_weather = weather;
    }

    public Integer getCRU_color() {
        return CRU_color;
    }

    public void setCRU_color(Integer color) {
        this.CRU_color = color;
    }

    public String getCRU_media() {
        return CRU_media;
    }

    public void setCRU_media(String CRU_media) {
        this.CRU_media = CRU_media;
    }

    public String getCRU_menu() {
        return CRU_menu;
    }

    public void setCRU_menu(String menu) {
        this.CRU_menu = menu;
    }

    public String getCRU_guests() {
        return CRU_guests;
    }

    public void setCRU_guests(String guests) {
        this.CRU_guests = guests;
    }

    @Override
    public String toString() {
        return ""+CRU_round+""+CRU_reservation+" "+CRU_date.toString()+" "+CRU_from_hour.toString()+"-"+CRU_to_hour.toString()+
                " skipper "+CRU_user_code;
    }
}
