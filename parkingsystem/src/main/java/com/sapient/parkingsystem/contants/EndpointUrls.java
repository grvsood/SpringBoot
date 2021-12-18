package com.sapient.parkingsystem.contants;

public final class EndpointUrls {

    public static final String ADMIN = "/admin";
    public static final String USER = "/user";
    public static final String PARKING_SPOT = "/parkingspot";
    public static final String ADD_PARKING_SPOT = "/add" + PARKING_SPOT;
    public static final String VIEW_PARKING_SPOT = "/view" + PARKING_SPOT;
    public static final String REMOVE_PARKING_SPOT = "/remove" + PARKING_SPOT;
    public static final String UPDATE_PARKING_SPOT = "/update" + PARKING_SPOT;
    public static final String BOOK_PARKING_SPOT = "/booking" + PARKING_SPOT;
    public static final String SEARHC_PARKING_SPOT = "/search" + PARKING_SPOT;
    public static final String BULKBOOK_PARKING_SPOT = "/bookings" + PARKING_SPOT;
    public static final String PING = "/ping";
    public static final String VIEW_BOOKINGS = "/view/booking";

    private EndpointUrls() {

    }
}
