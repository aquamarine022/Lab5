package me.masha;

import me.masha.models.Coordinates;
import me.masha.models.Vehicle;
import me.masha.models.VehicleType;

import java.util.ArrayList;
import java.util.List;

public class Main {
    static List<Vehicle> vehicles = new ArrayList<Vehicle>();
    public static void main(String[] args) {
        vehicles.add(new Vehicle(10, "car", new Coordinates(9000,2f), 70, 4L, null, VehicleType.CAR));
        vehicles.add(new Vehicle(11, "not a car", new Coordinates(1,2f),20, null, null, null));

        for (var e: vehicles) System.out.println(e);
    }
}

