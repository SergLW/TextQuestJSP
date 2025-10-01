package com.textQuest.exceptions;

public class InvalidTokenException extends GameException {
    public InvalidTokenException(String expectedToken, String providedToken) {
        super("Invalid Step Token (expected=" + expectedToken + " provided=" + providedToken + ")");
    }
}
