package me.masha.Managers;

import me.masha.Commands.*;
import me.masha.Exeptions.InvalidDataException;
import me.masha.Exeptions.WrongArgsException;
import me.masha.Models.VehicleReader;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.NoSuchElementException;

public class CommandsManager {
    private final ArrayList<Command> commandsList;

    public CommandsManager(CollectionManager collectionManager, VehicleReader vehicleReader, FileDataManager fileDataManager){
        this.commandsList = new ArrayList<>(Arrays.asList(
                new HelpCommand(this),
                new InfoCommand(collectionManager),
                new ShowCommand(collectionManager),
                new AddCommand(vehicleReader, collectionManager),
                new UpdateByIdCommand(vehicleReader, collectionManager),
                new RemoveByIdCommand(collectionManager),
                new ClearCommand(collectionManager),
                new SaveCommand(collectionManager, fileDataManager),
                new ExecuteScriptCommand(),
                new ExitCommand(collectionManager),
                new RemoveHeadCommand(collectionManager),
                new AddIfMaxCommand(vehicleReader,collectionManager),
                new AddIfMinCommand(vehicleReader,collectionManager),
                new RemoveAnyByEnginePowerCommand(collectionManager),
                new MinByNameCommand(collectionManager),
                new FilterStartsWithNameCommand(vehicleReader,collectionManager)

        ));
    }
    public ArrayList<Command> getCommandsList() {
        return commandsList;
    }
    public Commands launchCommand(String commandName, String[] commandArgs) throws InvalidDataException, WrongArgsException, NoSuchElementException {
        if(this.commandsList.stream().noneMatch(userCommand -> userCommand.getName().equals(commandName))){
            throw new NoSuchElementException("Command '" + commandName + "' not found!");
        }

        Commands commands;

        commands = (Commands) this.commandsList
                .stream()
                .filter(userCommand -> userCommand.getName().equals(commandName))
                .findFirst().get();
        commands.initCommandArgs(commandArgs);

        return commands;
    }

}
