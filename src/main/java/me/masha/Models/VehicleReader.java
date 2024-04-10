package me.masha.Models;

import me.masha.Constants;
import me.masha.Exeptions.InvalidDataException;
import me.masha.Managers.CollectionManager;
import me.masha.Parsers.Parsers;
import me.masha.Utility.Console;
import me.masha.Utility.Validators;

import java.time.Instant;
import java.util.Date;

public class VehicleReader extends ValueReader{
    private final CollectionManager collectionManager;
    public VehicleReader(CollectionManager collectionManager){
        this.collectionManager = collectionManager;
    }

    public Vehicle readVehicle() throws InvalidDataException{
        long id = this.collectionManager.generateId();
        String name = readName();
        Date creationDate = Date.from(Instant.now());
        Coordinates coordinates = readCoordinates();
        Integer enginePower = readEnginePower();
        Long numberOfWheels = readNumberOfWheels();
        Long capacity = readCapacity();
        VehicleType vehicleType = readVehicleType();
        return new Vehicle(id, name, creationDate, coordinates, enginePower, numberOfWheels, capacity, vehicleType);

    }

    public String readName() throws InvalidDataException {
        return readValue("name", Validators.nameValidator, Parsers.stringParser);
    }

    public Coordinates readCoordinates() throws InvalidDataException {
        return new Coordinates(readX(), readY());
    }

    public int readX() throws InvalidDataException {
        return readValue("x coordinate", Validators.xValidator, Parsers.integerParser);
    }


    public float readY() throws InvalidDataException {
        return readValue("y coordinate", Validators.yValidator, Parsers.floatParser);
    }

    public Integer readEnginePower() throws InvalidDataException {
        return readValue("engine power", Validators.enginePowerValidator, Parsers.integerParser);
    }

    public Long readNumberOfWheels() throws InvalidDataException {
        return readValue("number of wheels", Validators.numberOfWheelsValidator, Parsers.longParser);
    }

    public Long readCapacity() throws InvalidDataException {
        return readValue("capacity", Validators.capacityValidator, Parsers.longParser);
    }

    public VehicleType readVehicleType() throws InvalidDataException {
        if(!Constants.SCRIPT_MODE) {
            Console.getInstance().printLn("List of possible status values:");
            for (VehicleType i : VehicleType.values()) {
                Console.getInstance().printLn(i);
            }
        }
        return readValue("vehicle type", Validators.vehicleTypeValidator, Parsers.statusParser);
    }




}
