package me.masha.Managers;

import me.masha.Exeptions.InvalidDataException;
import me.masha.Models.Vehicle;
import me.masha.Utility.Validators;

import java.util.*;
import java.util.stream.Collectors;

import static me.masha.Constants.formatter;

public class CollectionManager {
    private ArrayDeque<Vehicle> collection;

    private final Date creationDate;

    private boolean changeFlag;

    public CollectionManager(ArrayDeque<Vehicle> collection){
        this.collection = collection;
        this.creationDate = new Date();
        this.changeFlag = false;
    }

    public static boolean isValid(ArrayDeque<Vehicle> collection){
        Set<Long> idSet = collection.stream().map(Vehicle::getId).collect(Collectors.toSet());
        if (idSet.size() != collection.size()) return false;
        for (Vehicle vehicle : collection){
            try {
                Validators.vehicleValidator.validate(vehicle);
            }
            catch (InvalidDataException e){
                return false;
            }
        }
        return true;
    }

    public boolean wasChanged(){
        return this.changeFlag;
    }

    public void removeFlag(){
        this.changeFlag = false;
    }

    public long generateId(){
        if(this.collection.isEmpty()) return 1;
        return this.collection.stream().map(Vehicle::getId).max(Long::compareTo).get()+1;
    }

    public ArrayDeque<Vehicle> getCollection(){
        return this.collection;
    }

    public boolean containsId(long id){
        if (this.collection.isEmpty()) return false;
        return this.collection.stream().anyMatch(vehicle -> vehicle.getId() == id);
    }

    public boolean containsEnginePower(int engine_power){
        if (this.collection.isEmpty()) return false;
        return this.collection.stream().anyMatch(vehicle -> vehicle.getEnginePower() == engine_power);
    }

    public String getInfo(){
        return "Type: " + this.collection.getClass().getName() +
                "\nCreation date: " + formatter.format(this.creationDate) +
                "\nSize: " + this.collection.size();
    }

    public void add(Vehicle newVehicle){
        this.collection.add(newVehicle);
        this.changeFlag = true;
    }

    public void update(long id, Vehicle newVehicle){
        removeById(id);
        newVehicle.setId(id);
        add(newVehicle);
    }

    public void removeById(long id){
        this.collection.removeIf(vehicle -> vehicle.getId()==id);
    }

    public void clear(){
        this.collection.clear();
        this.changeFlag = true;
    }

    public void removeHead(){
        System.out.println(this.collection.getFirst());
        this.collection.poll();
        this.changeFlag = true;
    }

    public void addIfMax(Vehicle vehicle) {
        List<Vehicle> vehicles = new ArrayList<>();
        Vehicle maxVehicle = Collections.max(vehicles);
        if (vehicle.compareTo(maxVehicle) > 0) {
            vehicles.add(vehicle);
        }
    }

    public void addIfMin(Vehicle vehicle) {
        List<Vehicle> vehicles = new ArrayList<>();
        Vehicle minVehicle = Collections.min(vehicles);
        if (vehicle.compareTo(minVehicle) > 0) {
            vehicles.add(vehicle);
        }
    }

    public void removeByEnginePower(Integer enginePower){
        this.collection.removeIf(vehicle -> vehicle.getEnginePower() == enginePower);
    }

    public Vehicle getMinByName(){
        return this.collection.stream().min(Comparator.comparing(Vehicle::getName)).orElseThrow(NoSuchElementException::new);
    }

    public List<Vehicle> getStartsWithName(String name){
        return this.collection.stream().filter(vehicle ->vehicle.getName().startsWith(name)).toList();
    }
}
