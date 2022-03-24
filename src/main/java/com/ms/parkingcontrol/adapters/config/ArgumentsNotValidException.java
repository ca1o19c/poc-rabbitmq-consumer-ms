package com.ms.parkingcontrol.adapters.config;

import java.net.BindException;

public class ArgumentsNotValidException extends BindException {
    public ArgumentsNotValidException() {
    }

    public ArgumentsNotValidException(String msg) {
        super(msg);
    }
}
