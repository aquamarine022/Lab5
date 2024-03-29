package me.masha.Exeptions;

import java.io.IOException;

/**
 * Signals that some data is not valid
 */
public class InvalidDataException extends Exception {

    public InvalidDataException(String message){
        super(message);
    }
}
