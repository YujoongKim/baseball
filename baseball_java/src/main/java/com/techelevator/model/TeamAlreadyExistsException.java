package com.techelevator.model;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus( value = HttpStatus.BAD_REQUEST, reason = "Team Already Exists.")
public class TeamAlreadyExistsException extends RuntimeException{
    public TeamAlreadyExistsException(String s) {
    }
}
