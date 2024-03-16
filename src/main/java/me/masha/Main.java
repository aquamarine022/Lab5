package me.masha;

import me.masha.models.*;
import me.masha.utility.*;

import java.util.ArrayList;
import java.util.List;

public class Main {
    static List<Vehicle> vehicles = new ArrayList<Vehicle>();

    public static void main(String[] args) throws Ask.AskBreak {
        var console = new StandardConsole();
        vehicles.add(Ask.askVehicle(console, 100));

        for (var e : vehicles) System.out.println(e);
    }
}

