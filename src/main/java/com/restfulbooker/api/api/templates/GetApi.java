package com.restfulbooker.api.api.templates;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;


public final class GetApi {

    public GetApi(String endpoint, int statusCode, String bookingId, Integer bookingIdNumber) {
    }


    public static Response sendGet(String endpoint, Integer bookingId, int statusCode) {
        return given().
                   get(endpoint + Integer.toString(bookingId)).
                then().
                   statusCode(statusCode).
                   extract().
                   response();
    }

    public static Response sendGet(String endpoint, int statusCode) {
        return given().
                   get(endpoint).
               then().
                   statusCode(statusCode).
                   extract().
                   response();
    }

}

