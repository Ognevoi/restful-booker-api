package com.restfulbooker.api.api;


import io.restassured.response.Response;

import java.util.Collections;
import java.util.List;
import java.util.Random;

import static com.restfulbooker.util.EndPoints.BOOKING_ENDPOINT;
import static io.restassured.RestAssured.given;

public class Bookings {


    public static int totalNumberOfBookings() {
        Response response = given()
                               .get(BOOKING_ENDPOINT);

        List<String> allBookingIds = response.path("bookingid");
        return allBookingIds.size();
    }


    public static Integer smallestBookingId() {
        List<Integer> response = given().
                                      get(BOOKING_ENDPOINT).
                                  then().
                                       extract().
                                       body().
                                       jsonPath().
                                       getList("bookingid");

        Collections.sort(response);
        return response.get(0);
    }

    public static Integer biggestBookingId() {
        List<Integer> response = given().
                get(BOOKING_ENDPOINT).
                then().
                extract().
                body().
                jsonPath().
                getList("bookingid");

        Collections.sort(response);
        return response.get(totalNumberOfBookings() - 1);
    }


    public static Integer randomBookingId() {
        List<Integer> response = given().
                                      get(BOOKING_ENDPOINT).
                                 then().
                                    extract().
                                    body().
                                    jsonPath().
                                    getList("bookingid");

        return response.get(new Random().nextInt(response.size()));
    }


    public static List<String> listOfAllBookingId() {
        Response response = given().
                                get(BOOKING_ENDPOINT);

        List<String> allBookingIds = response.path("bookingid");
        return allBookingIds;
    }


}