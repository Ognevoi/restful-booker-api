package com.restfulbooker.api.api;


import com.restfulbooker.api.payload.AuthApi;
import io.restassured.http.ContentType;

import static com.restfulbooker.util.EndPoints.AUTHORIZATION_ENDPOINT;
import static io.restassured.RestAssured.given;

public class Auth {


    public static String token =
            given().
                    contentType(ContentType.JSON).
                    body(AuthApi.credentials()).
                    when().
                    post(AUTHORIZATION_ENDPOINT).
                    then().
                    extract().path("token").toString();
}