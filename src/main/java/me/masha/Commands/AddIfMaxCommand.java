package me.masha.Commands;

import me.masha.Exeptions.InvalidDataException;
import me.masha.Exeptions.WrongArgsException;
import me.masha.Managers.CollectionManager;
import me.masha.Models.Vehicle;
import me.masha.Models.VehicleReader;
import me.masha.Utility.Console;

public class AddIfMaxCommand extends Commands{
    private VehicleReader vehicleReader;
    private CollectionManager collectionManager;

    public AddIfMaxCommand(VehicleReader vehicleReader, CollectionManager collectionManager){
        super("add_if_max","{element}","add new element if it is the greatest");
        this.collectionManager = collectionManager;
        this.vehicleReader = vehicleReader;
    }

    @Override
    public void execute() throws InvalidDataException {
        int size = collectionManager.getCollection().size();
        Vehicle vehicle = this.vehicleReader.readVehicle();
        collectionManager.addIfMax(vehicle);
        int sizeAfter = collectionManager.getCollection().size();
        if (size < sizeAfter){
            Console.getInstance().printLn("Max Vehicle added successfully");
        }
        Console.getInstance().printLn("No elements added");
    }

    @Override
    public void initCommandArgs(String[] commandArgs) throws WrongArgsException {
        if(commandArgs.length != 0) throw new WrongArgsException("Wrong amount of arguments!", 0, commandArgs.length);
    }
}
