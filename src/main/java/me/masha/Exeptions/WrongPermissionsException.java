package me.masha.Exeptions;

import java.io.FileNotFoundException;

public class WrongPermissionsException extends FileNotFoundException {

    public WrongPermissionsException(String message){
        super(message);
    }
}
