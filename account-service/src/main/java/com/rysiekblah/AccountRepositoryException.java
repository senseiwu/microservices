package com.rysiekblah;

/**
 * Created by Tomasz_Kozlowski on 11/26/2016.
 */
public class AccountRepositoryException extends Exception {

    public AccountRepositoryException(String message) {
        super(message);
    }

    public AccountRepositoryException(String message, Throwable cause) {
        super(message, cause);
    }
}
