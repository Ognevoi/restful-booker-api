package com.restfulbooker.api.api;

import com.google.gson.Gson;
import com.restfulbooker.api.payload.Booking;
import com.restfulbooker.api.payload.BookingDates;


public class NewBooking {


    public static String bookingBody() {
        Booking booking = new Booking(
                "Oleg",
                "Ognevoi",
                150,
                true,
                new BookingDates("2019-08-10", "2019-08-120"),
                "Xbox");

        String bookingData = new Gson().toJson(booking);
        return bookingData;
    }



}
