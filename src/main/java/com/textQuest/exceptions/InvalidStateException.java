package com.textQuest.exceptions;

public class InvalidStateException extends GameException {
    public InvalidStateException(String stateId) {
        super("Invalid or unexpected state: " + stateId);
    }
}
