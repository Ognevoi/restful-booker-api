package com.restfulbooker.api.payload;


public class BookingDates {

    private String checkin, checkout;

    public BookingDates(String checkin, String checkout) {
        this.checkin = checkin;
        this.checkout = checkout;
    }

    public void setCheckin(String checkin) {
        this.checkin = checkin;
    }
    public String getCheckin() {
        return this.checkin;
    }

    public void setCheckout(String checkout) {
        this.checkout = checkout;
    }
    public String getCheckout() {
        return this.checkout;
    }


}