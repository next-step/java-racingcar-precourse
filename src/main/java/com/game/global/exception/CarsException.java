package com.game.global.exception;

import com.game.global.code.CarsExceptionType;

public class CarsException extends RuntimeException {

    private CarsExceptionType carsExceptionType;

    public CarsException(CarsExceptionType carsExceptionType, String message) {
        super(message);
        this.carsExceptionType = carsExceptionType;
    }

    public CarsExceptionType getCarsExceptionType() {
        return carsExceptionType;
    }

}
