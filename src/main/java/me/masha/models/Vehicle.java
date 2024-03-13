package me.masha.models;

import me.masha.utility.Validatable;

import java.time.Instant;
import java.util.Date;

/**
 * Class to operate with vehicle
 */
public class Vehicle implements Validatable {
    /**
     * Vehicle's id, must be greater than 0, must be unique, must be generated automatically
     */
     private long id;
    /**
     * Vehicle's name, can't be null, can't be empty
     */
    private String name;
    /**
     * Vehicle's coordinates, can't be null
     */
     private Coordinates coordinates;
    /**
     * Vehicle's creationDate, can't be null, must be generated automatically
     */
    private java.util.Date creationDate;
    /**
     * Vehicle's engine power, must be greater than 0
     */
     private int enginePower;
    /**
     * Vehicle's number of wheels, must be greater than 0, can't be null
     */
    private Long numberOfWheels;
    /**
     * Vehicle's capacity, can be null, must be greater than 0
     */
     private Long capacity;
    /**
     * Vehicle's type, can be null
     */
    private VehicleType type;

    /**
     * Constructor
     * @param id - id
     * @param name - name
     * @param creationDate - creationDate
     * @param coordinates - coordinates
     * @param enginePower - enginePower
     * @param numberOfWheels - numberOfWheels
     * @param capacity - capacity
     * @param vehicleType - vehicleType
     */
        public Vehicle(int id, String name, java.util.Date creationDate, Coordinates coordinates, Integer enginePower,Long numberOfWheels, Long capacity, VehicleType vehicleType) {
            this.id = id;
            this.name = name;
            this.creationDate = creationDate;
            this.coordinates = coordinates;
            this.enginePower = enginePower;
            this.numberOfWheels = numberOfWheels;
            this.capacity = capacity;
            this.type = vehicleType;
        }

    /**
     * constructor to generate creationDate
     */
        public Vehicle(int id, String name, Coordinates coordinates, Integer enginePower,Long numberOfWheels, Long capacity, VehicleType vehicleType) {
            this(id, name, Date.from(Instant.now()), coordinates, enginePower, numberOfWheels, capacity, vehicleType);
        }

    /**
     * Checker of correct values
     * @return true if value is correct and false if incorrect
     */
    public boolean validate() {
            if (id <= 0) return false;
            if (name == null || name.isEmpty()) return false;
            if (creationDate == null) return false;
            if (coordinates == null || !coordinates.validate()) return false;
            return true;
    }

    /**
     * Method to get formatted string representation of vehicle
     * @return String value
     */
    @Override
    public String toString() {
        return "vehicle{\"id\": " + id + ", " +
            "\"name\": \"" + name + "\", " +
            "\"creationDate\": \"" + creationDate + "\", " +
            "\"coordinates\": \"" + coordinates + "\", " +
            "\"enginePower\": \"" + enginePower + "\", " +
            "\"numberOfWheels\": \"" + (numberOfWheels == null ? "null" : "\""+numberOfWheels+"\"") + "\", " +
            "\"capacity\": \"" + (capacity == null ? "null" : "\""+capacity+"\"") + "\", " +
            "\"vehicleType\": " + (type == null ? "null" : "\""+type+"\"") + "}";
        }
    }
