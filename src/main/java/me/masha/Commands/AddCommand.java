package me.masha.Commands;

import me.masha.Exeptions.InvalidDataException;
import me.masha.Exeptions.WrongArgsException;
import me.masha.Managers.CollectionManager;
import me.masha.Models.Vehicle;
import me.masha.Models.VehicleReader;
import me.masha.Utility.Console;

public class AddCommand extends Commands{
    private CollectionManager collectionManager;
    private VehicleReader vehicleReader;

    public AddCommand(VehicleReader vehicleReader, CollectionManager collectionManager){
        super("add", "{element}", "add new element to collection");
        this.collectionManager = collectionManager;
        this.vehicleReader = vehicleReader;
    }

    @Override
    public void execute() throws InvalidDataException {
        Vehicle vehicle = this.vehicleReader.readVehicle();
        collectionManager.add(vehicle);
        Console.getInstance().printLn("Vehicle added successfully");
    }
    @Override
    public void initCommandArgs(String[] commandArgs) throws WrongArgsException {
        if(commandArgs.length != 0) throw new WrongArgsException("Wrong amount of arguments!", 0, commandArgs.length);
    }
}
