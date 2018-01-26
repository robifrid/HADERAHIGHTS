package com.example.dor.mengroupapp;

/**
 * Created by Dor on 09/01/2018.
 */

public class UserPass {
    private String name; //connected menu
    private String password; // connected guests
    private String role; // Admin, Delegate, Guest

    public UserPass(){
        name = "kuku";
        password = "kuku123";
        role = "G";
    }

    public UserPass(String username, String password, String role) {
            this.name = username;
            this.password = password;
            this.role = role;
        }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }


}
