package me.masha.Commands;

import me.masha.Exeptions.InvalidDataException;
import me.masha.Exeptions.WrongArgsException;
import me.masha.Managers.CollectionManager;
import me.masha.Models.Vehicle;
import me.masha.Models.VehicleReader;
import me.masha.Parsers.Parsers;
import me.masha.Utility.Console;
import me.masha.Utility.Validators;

import java.util.NoSuchElementException;

public class UpdateByIdCommand extends Commands{
    private CollectionManager collectionManager;
    private VehicleReader vehicleReader;
    private long id;

    public UpdateByIdCommand(VehicleReader vehicleReader, CollectionManager collectionManager){
        super("update","id {element}","update value of collection element which id is equal to given");
        this.vehicleReader = vehicleReader;
        this.collectionManager = collectionManager;

    }

    public void execute() throws InvalidDataException, NoSuchElementException {
        if(!this.collectionManager.containsId(id)){
            throw new NoSuchElementException("No element with such id");
        }
        Vehicle vehicle = this.vehicleReader.readVehicle();
        this.collectionManager.update(id, vehicle);
        Console.getInstance().printLn("Element updated successfully");

    }
    @Override
    public void initCommandArgs(String[] commandArgs) throws WrongArgsException, InvalidDataException {
        if(commandArgs.length != 1) throw new WrongArgsException("Wrong amount of arguments!", 1, commandArgs.length);
        this.id = Parsers.longParser.parse(commandArgs[0]);
        Validators.idValidator.validate(id);
    }
}
