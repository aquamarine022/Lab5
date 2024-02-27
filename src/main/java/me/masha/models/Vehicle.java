package me.masha.models;

import java.time.Instant;
import java.util.Date;

public class Vehicle {
        private long id; //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
        private String name; //Поле не может быть null, Строка не может быть пустой
        private Coordinates coordinates; //Поле не может быть null
        private java.util.Date creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
        private int enginePower; //Значение поля должно быть больше 0
        private Long numberOfWheels; //Поле не может быть null, Значение поля должно быть больше 0
        private Long capacity; //Поле может быть null, Значение поля должно быть больше 0
        private VehicleType type; //Поле может быть null

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
        public Vehicle(int id, String name, Coordinates coordinates, Integer enginePower,Long numberOfWheels, Long capacity, VehicleType vehicleType) {
            this(id, name, Date.from(Instant.now()), coordinates, enginePower, numberOfWheels, capacity, vehicleType);
        }
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
