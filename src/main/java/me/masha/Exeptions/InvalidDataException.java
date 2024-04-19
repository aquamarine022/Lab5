package me.masha.Exeptions;

/**
 * Signals that some data is not valid
 */
public class InvalidDataException extends Exception {

    public InvalidDataException(String message){
        super(message);
    }
}
