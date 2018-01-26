package com.example.dor.mengroupapp;

import java.util.Calendar;

/**
 * Created by Dor on 20/01/2018.
 */

public class UserOBJ {
    private Integer USR_code;  // auto increment primary key
    private Integer USR_group_number; // FFU currently value 1
    private String USR_firstName;  // user's first name
    private String USR_lastName;  // user's last name
    private Calendar USR_birthDate;  // user's birth date
    private String USR_username; // application Username
    private String USR_password; // application Password Encrypted ?
    private String USR_role; // "A" - admin, "D" - delegate, "M" - member, "G" - guest
    private Integer USR_phone; // user's mobile phone
    private String USR_skipper_license; // user's skipper license, 0 if none
    private String USR_skipper_license_photo;
    private String USR_international_license; // user's international license, 0 if none
    private String USR_international_license_photo;
    private String USR_club; // FFU user's Club, current value "Lee-Yam"
    private Integer USR_membership; // FFU Club membership number = USR_code
    private String USR_preferences; // user preferences and comments
    private String USR_description; // FFU

    public UserOBJ(Integer USR_code, String USR_firstName, String USR_lastName,
                   Calendar USR_birthDate, String USR_username, String USR_password,
                   String USR_role, Integer USR_phone, String USR_skipper_license,
                   String USR_international_license) {

        this.USR_code = USR_code;
        this.USR_group_number = 1;
        this.USR_firstName = USR_firstName;
        this.USR_lastName = USR_lastName;
        this.USR_birthDate = USR_birthDate;
        this.USR_username = USR_username;
        this.USR_password = USR_password;
        this.USR_role = USR_role;
        this.USR_phone = USR_phone;
        this.USR_skipper_license = USR_skipper_license;
        this.USR_international_license = USR_international_license;
        this.USR_club = "Lee-Yam";
        this.USR_membership = USR_code;

    }

    public Integer getUSR_code() {
        return USR_code;
    }

    public void setUSR_code(Integer USR_code) {
        this.USR_code = USR_code;
    }

    public Integer getUSR_group_number() {
        return USR_group_number;
    }

    public void setUSR_group_number(Integer USR_group_number) {
        this.USR_group_number = USR_group_number;
    }

    public String getUSR_firstName() {
        return USR_firstName;
    }

    public void setUSR_firstName(String USR_firstName) {
        this.USR_firstName = USR_firstName;
    }

    public String getUSR_lastName() {
        return USR_lastName;
    }

    public void setUSR_lastName(String USR_lastName) {
        this.USR_lastName = USR_lastName;
    }

    public Calendar getUSR_birthDate() {
        return USR_birthDate;
    }

    public void setUSR_birthDate(Calendar USR_birthDate) {
        this.USR_birthDate = USR_birthDate;
    }

    public String getUSR_username() {
        return USR_username;
    }

    public void setUSR_username(String USR_username) {
        this.USR_username = USR_username;
    }

    public String getUSR_password() {
        return USR_password;
    }

    public void setUSR_password(String USR_password) {
        this.USR_password = USR_password;
    }

    public String getUSR_role() {
        return USR_role;
    }

    public void setUSR_role(String USR_role) {
        this.USR_role = USR_role;
    }

    public Integer getUSR_phone() {
        return USR_phone;
    }

    public void setUSR_phone(Integer USR_phone) {
        this.USR_phone = USR_phone;
    }

    public String getUSR_skipper_license() {
        return USR_skipper_license;
    }

    public void setUSR_skipper_license(String USR_skipper_license) {
        this.USR_skipper_license = USR_skipper_license;
    }

    public String getUSR_skipper_license_photo() {
        return USR_skipper_license_photo;
    }

    public void setUSR_skipper_license_photo(String USR_skipper_license_photo) {
        this.USR_skipper_license_photo = USR_skipper_license_photo;
    }

    public String getUSR_international_license() {
        return USR_international_license;
    }

    public void setUSR_international_license(String USR_international_license) {
        this.USR_international_license = USR_international_license;
    }

    public String getUSR_international_license_photo() {
        return USR_international_license_photo;
    }

    public void setUSR_international_license_photo(String USR_international_license_photo) {
        this.USR_international_license_photo = USR_international_license_photo;
    }

    public String getUSR_club() {
        return USR_club;
    }

    public void setUSR_club(String USR_club) {
        this.USR_club = USR_club;
    }

    public Integer getUSR_membership() {
        return USR_membership;
    }

    public void setUSR_membership(Integer USR_membership) {
        this.USR_membership = USR_membership;
    }

    public String getUSR_preferences() {
        return USR_preferences;
    }

    public void setUSR_preferences(String USR_preferences) {
        this.USR_preferences = USR_preferences;
    }

    public String getUSR_description() {
        return USR_description;
    }

    public void setUSR_description(String USR_description) {
        this.USR_description = USR_description;
    }
}
