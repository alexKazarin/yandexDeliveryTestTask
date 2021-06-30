package com.company;

public class IlligalLoadException extends Exception {
    public IlligalLoadException() {
        super("Received load is unknown");
    }
}
