package com.example.webdemo.interfaces;


import com.baoyz.treasure.Preferences;

@Preferences
public interface TokenPreferenceInterface {

    String getToken();

    void setToken(String token);
}
