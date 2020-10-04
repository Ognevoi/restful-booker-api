package com.restfulbooker.api.payload;

public class Booking {

    private String firstname, lastname, additionalneeds;
    private int totalprice;
    private boolean depositpaid;
    private BookingDates bookingdates;

    public Booking(String firstname, String lastname, int totalprice, boolean depositpaid, BookingDates bookingdates, String additionalneeds) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.totalprice = totalprice;
        this.depositpaid = depositpaid;
        this.bookingdates = bookingdates;
        this.additionalneeds = additionalneeds;
    }


    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
    public String getFirstname() {
        return this.firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    public String getLastname() {
        return this.lastname;
    }

    public void setTotalprice(int totalprice) {
        this.totalprice = totalprice;
    }
    public int getTotalprice() {
        return this.totalprice;
    }

    public void setDepositpaid(boolean depositpaid) {
        this.depositpaid = depositpaid;
    }
    public boolean getDepositpaid() {
        return this.depositpaid;
    }

    public void setBookingdates(BookingDates bookingdates) {
        this.bookingdates = bookingdates;
    }
    public BookingDates getBookingdates() {
        return this.bookingdates;
    }

    public void setAdditionalneeds(String additionalneeds) {
        this.additionalneeds = additionalneeds;
    }
    public String getAdditionalneeds() {
        return this.additionalneeds;
    }

}

