package me.masha.Commands;

public interface Command {
    String getName();
    void execute() throws Exception;
}
