package com.restfulbooker.api;

import com.restfulbooker.api.payload.AuthApi;
import com.restfulbooker.api.api.Bookings;
import com.restfulbooker.api.api.NewBooking;
import com.restfulbooker.api.api.templates.*;

import io.restassured.RestAssured;
import io.restassured.config.RestAssuredConfig;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static com.restfulbooker.util.EndPoints.*;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.lessThan;

public class ApiTest {

    @Test
    public void restAssuredSettedUpTest() {
        assertThat(RestAssured.config(), instanceOf(RestAssuredConfig.class));
    }

    @Test
    public void serverResponse200() {
        Response response = GetApi.sendGet(BASE_ENDPOINT, 200);
        int statusCode = response.getStatusCode();
        assertThat(statusCode, is(200));
    }

    @Test
    public void tokenAvailabilityTestReturn200() {
        Response response = PostApi.sendPost(AuthApi.credentials(), AUTHORIZATION_ENDPOINT, 200);
        String authResponse = response.getBody().print();
        assertThat(authResponse, containsString("token"));
    }

    @Test
    public void getBookingReturns200() {
        Response response = GetApi.sendGet(BOOKING_ENDPOINT, Bookings.randomBookingId(), 200);
        String getUserFirstName = response.getBody().print();
        assertThat(getUserFirstName, containsString("firstname"));
    }

    @Test
    public void getAllBookingsReturn200() {
        Response response = GetApi.sendGet(BOOKING_ENDPOINT,200);
        String allBookings = response.getBody().print();
        assertThat(allBookings, containsString("bookingid"));
    }

    @Test
    public void postNewBookingReturn200() {
        int initialBookings = Bookings.totalNumberOfBookings();
        PostApi.sendPost(NewBooking.bookingBody(), BOOKING_ENDPOINT, 200);
        int currentBookings = Bookings.totalNumberOfBookings();
        assertThat(initialBookings, lessThan(currentBookings));
    }

    @Test
    public void deleteRandomBookingReturn201() {
        int initialBookings = Bookings.totalNumberOfBookings();
        DeleteApi.sendDelete(Bookings.randomBookingId(), 201);
        int currentBookings = Bookings.totalNumberOfBookings();
        assertThat(currentBookings, is(lessThan(initialBookings)));
    }

}
