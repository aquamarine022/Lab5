package me.masha.Commands;

import me.masha.Exeptions.InvalidDataException;
import me.masha.Exeptions.WrongArgsException;
import me.masha.Managers.CommandsManager;
import me.masha.Utility.Console;

public class HelpCommand extends Commands {
    /**
     * Controller of command which is used to get list of all commands
     */
    private CommandsManager commandsManager;

    public HelpCommand(CommandsManager commandsManager) {
        super("help", "print description of available commands");
        this.commandsManager = commandsManager;
    }

    @Override
    public void execute() {
        this.commandsManager.getCommandsList()
                .forEach(command -> Console.getInstance().printLn(command));
    }

    @Override
    public void initCommandArgs(String[] commandArgs) throws WrongArgsException {
        if(commandArgs.length != 0) throw new WrongArgsException("Wrong amount of arguments!", 0, commandArgs.length);
    }
}
