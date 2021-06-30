package com.company;

public class FragileException extends Exception {
    public FragileException() {
        super("Fragile parcel could not be sent more than 30km");
    }
}
