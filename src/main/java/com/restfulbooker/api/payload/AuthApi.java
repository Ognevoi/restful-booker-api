package com.restfulbooker.api.payload;

import com.google.gson.Gson;


import static com.restfulbooker.util.Credentials.*;

public class AuthApi {

    String username;
    String password;

    public AuthApi(String username, String password) {
        this.username = username;
        this.password = password;
    }


    public static String credentials() {
        AuthApi authCredentials = new AuthApi(DEFAULT_USER_NAME, DEFAULT_PASSWORD);
        return new Gson().toJson(authCredentials);
    }


}
