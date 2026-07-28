package com.dairyflow.common.exception;

public class DuplicateMilkEntryException extends RuntimeException {

    public DuplicateMilkEntryException(String message) {
        super(message);
    }
}