package me.masha.Commands;

import me.masha.Exeptions.InvalidDataException;
import me.masha.Exeptions.WrongArgsException;
import me.masha.Managers.CollectionManager;
import me.masha.Parsers.Parsers;
import me.masha.Utility.Console;
import me.masha.Utility.Validators;

import java.util.NoSuchElementException;

public class RemoveAnyByEnginePowerCommand extends Commands{
    private CollectionManager collectionManager;
    private int engine_power;

    public RemoveAnyByEnginePowerCommand(CollectionManager collectionManager){
        super("remove_by_engine_power","engine_power","remove element which engine power is equal to given");
        this.collectionManager = collectionManager;

    }

    public void execute() throws NoSuchElementException {
        if(!this.collectionManager.containsEnginePower(engine_power)){
            throw new NoSuchElementException("No element with such engine power");
        }
        this.collectionManager.removeByEnginePower(engine_power);
        Console.getInstance().printLn("Element removed successfully");

    }
    @Override
    public void initCommandArgs(String[] commandArgs) throws WrongArgsException, InvalidDataException {
        if(commandArgs.length != 1) throw new WrongArgsException("Wrong amount of arguments!", 1, commandArgs.length);
        this.engine_power = Parsers.integerParser.parse(commandArgs[0]);
        Validators.enginePowerValidator.validate(engine_power);
    }
}
