package me.masha.Commands;

import me.masha.Constants;
import me.masha.Exeptions.InvalidDataException;
import me.masha.Exeptions.WrongArgsException;
import me.masha.Managers.CollectionManager;
import me.masha.Managers.FileDataManager;
import me.masha.Models.VehicleReader;
import me.masha.Utility.Console;

public class FilterStartsWithNameCommand extends Commands{
    private VehicleReader vehicleReader;
    private CollectionManager collectionManager;

    public FilterStartsWithNameCommand(VehicleReader vehicleReader, CollectionManager collectionManager) {
        super("filter_starts_with_name","name","print all elements whose beginning is same with pattern");
        this.collectionManager = collectionManager;
        this.vehicleReader = vehicleReader;
    }

    @Override
    public void execute()throws InvalidDataException{
        if(this.collectionManager.getCollection().isEmpty()){
            Console.getInstance().printLn("Collection is empty");
            return;
        }
        String name = vehicleReader.readName();
        Console.getInstance().printLn(this.collectionManager.getStartsWithName(name));

    }

    @Override
    public void initCommandArgs(String[] commandArgs) throws WrongArgsException {
        if(commandArgs.length != 0) throw new WrongArgsException("Wrong amount of arguments!", 1, commandArgs.length);
    }
}
