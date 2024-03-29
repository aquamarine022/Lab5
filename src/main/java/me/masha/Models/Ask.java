package me.masha.Models;

import me.masha.Utility.Console;

import java.time.Instant;
import java.util.Date;
import java.util.NoSuchElementException;

public class Ask{
    public static class AskBreak extends Exception {}

    public static Vehicle askVehicle(Console console, int id) throws AskBreak {
        /**
         *     private long id; //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
         *     private String name; //Поле не может быть null, Строка не может быть пустой
         *     private Coordinates coordinates; //Поле не может быть null
         *     private java.util.Date creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
         *     private int enginePower; //Значение поля должно быть больше 0
         *     private Long numberOfWheels; //Поле не может быть null, Значение поля должно быть больше 0
         *     private Long capacity; //Поле может быть null, Значение поля должно быть больше 0
         *     private VehicleType type; //Поле может быть null
         */
        try {
            console.print("name: ");
            String name;
            while (true) {
                name = console.readln().trim();
                if (name.equals("exit")) throw new AskBreak();
                if (!name.isEmpty()) break;
                console.print("name: ");
            }
            var coordinates = askCoordinates(console);
            console.print("engine power: ");
            Integer enginePower;
            while (true) {
                var line = console.readln().trim();
                if (line.equals("exit")) throw new AskBreak();
                if (line.equals("")) { enginePower = null; break;}
                try { enginePower = Integer.parseInt(line);
                    if (enginePower>0) break; }
                catch (NumberFormatException e) { }
                console.print("engine power: ");
            }
            console.print("number of wheels: ");
            Long numberOfWheels;
            while (true) {
                var line = console.readln().trim();
                if (line.equals("exit")) throw new AskBreak();
                if (line.equals("")) { numberOfWheels = null; break;}
                try { numberOfWheels = Long.parseLong(line);
                    if (numberOfWheels>0) break; }
                catch (NumberFormatException e) { }
                console.print("number of wheels: ");
            }

            console.print("capacity: ");
            Long capacity;
            while (true) {
                var line = console.readln().trim();
                if (line.equals("exit")) throw new AskBreak();
                if (line.equals("")) { capacity = null; break;}
                try { capacity = Long.parseLong(line);
                    if (capacity>0) break; }
                catch (NumberFormatException e) { }
                console.print("capacity: ");
            }

            var vehicleType = askVehicleType(console);
            return new Vehicle(id, name, Date.from(Instant.now()), coordinates, enginePower, numberOfWheels, capacity, vehicleType);
        } catch (NoSuchElementException | IllegalStateException e) {
            console.printError("Ошибка чтения");
            return null;
        }
    }

    public static Coordinates askCoordinates(Console console) throws AskBreak {
        try {
            int x;
            while (true) {
                console.print("coordinates.x: ");
                var line = console.readln().trim();
                if (line.equals("exit")) throw new AskBreak();
                if (!line.equals("")) {
                    try { x = Integer.parseInt(line); if (x<717) break; } catch (NumberFormatException e) { }
                }
            }
            float y;
            while (true) {
                console.print("coordinates.y: ");
                var line = console.readln().trim();
                if (line.equals("exit")) throw new AskBreak();
                if (!line.equals("")) {
                    try { y = Float.parseFloat(line); break; }catch(NumberFormatException e) { }
                }
            }
            return new Coordinates(x, y);
        } catch (NoSuchElementException | IllegalStateException e) {
            console.printError("Ошибка чтения");
            return null;
        }
    }
    public static VehicleType askVehicleType(Console console) throws AskBreak {
        try {
            VehicleType r;
            while (true) {
                console.print("VehicleType ("+VehicleType.names()+"): ");
                var line = console.readln().trim();
                if (line.equals("exit")) throw new AskBreak();
                if (!line.equals("")) {
                    try {
                        r = VehicleType.valueOf(line); break;
                    } catch (NullPointerException | IllegalArgumentException  e) { }
                } else return null;
            }
            return r;
        } catch (NoSuchElementException | IllegalStateException e) {
            console.printError("Ошибка чтения");
            return null;
        }
    }

}
