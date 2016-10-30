package com.rysiekblah;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by tomek on 10/30/16.
 */
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class EventAccessPermissionDenied extends RuntimeException {
    public EventAccessPermissionDenied(String message) {
        super(message);
    }
}
