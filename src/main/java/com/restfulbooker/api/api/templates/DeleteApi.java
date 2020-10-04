package com.restfulbooker.api.api.templates;

import com.restfulbooker.api.api.Auth;
import io.restassured.response.Response;


import static com.restfulbooker.util.EndPoints.BOOKING_ENDPOINT;
import static io.restassured.RestAssured.given;

public final class DeleteApi {

    public DeleteApi(int bookingId, int statusCode) {
    }


    public static Response sendDelete(int bookingId, int statusCode) {
        return given().
                    header("Cookie", "token=" + Auth.token).
                when().
                    delete(BOOKING_ENDPOINT + bookingId).
                then().
                    statusCode(statusCode).
                    extract().
                    response();
    }
}