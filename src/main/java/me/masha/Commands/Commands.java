package me.masha.Commands;

import me.masha.Exeptions.InvalidDataException;
import me.masha.Exeptions.WrongArgsException;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if (!(o instanceof Commands command)) return false;
        return Objects.equals(name, command.name) && Objects.equals(args, command.args) && Objects.equals(description, command.description);
    }

    @Override
    public String toString(){
        String res = this.name;
        if(!this.args.isEmpty()) res += " " + this.args;
        res += ": " + this.description;
        return res;
    }

    @Override
    public int hashCode(){
        return Objects.hash(name, args, description);
    }
}
