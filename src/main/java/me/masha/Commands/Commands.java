package me.masha.Commands;

import me.masha.Exeptions.InvalidDataException;
import me.masha.Exeptions.WrongArgsException;

public abstract class Commands implements Command {
    private final String name;

    private final String args;

    private final String description;

    public Commands(String name, String description){
        this.name = name;
        this.args = "";
        this.description = description;
    }

    public Commands(String name, String args, String description){
        this.name = name;
        this.args = args;
        this.description = description;
    }

    public String getName(){
        return name;
    }

    public abstract void initCommandArgs(String[] commandArgs) throws InvalidDataException, WrongArgsException;


}
