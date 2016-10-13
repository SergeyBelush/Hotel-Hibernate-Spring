package by.htp3.hotel.service;


public class UserException extends Exception {

    public UserException(String message, Exception parent) {
        super(message, parent);
    }
}
