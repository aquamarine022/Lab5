package me.masha;

import me.masha.Commands.Commands;
import me.masha.Managers.CollectionManager;
import me.masha.Managers.CommandsManager;
import me.masha.Managers.FileDataManager;
import me.masha.Managers.Loader;
import me.masha.Models.Vehicle;
import me.masha.Models.VehicleReader;
import me.masha.Utility.Console;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    private static CollectionManager collectionManager;
    private static VehicleReader vehicleReader;

    private static CommandsManager commandsManager;
    private static FileDataManager fileDataManager;


    public static void main(String[] args) {
        if(args.length > 0) {
            String fileName = args[0];
            System.out.println("Имя файла: " + fileName);
        } else {
            System.out.println("Имя файла не было передано через аргумент командной строки");
        }

        Console.getInstance().setScanner(new Scanner(System.in));
        collectionManager = new CollectionManager(loadData(args[0]));
        vehicleReader = new VehicleReader(collectionManager);
        commandsManager = new CommandsManager(collectionManager,vehicleReader,fileDataManager);
        interactiveMode();

    }

    public static void scriptMode() throws Exception{
        while (Console.getInstance().hasNextLine()){
            String s = Console.getInstance().readLine();
            String[] input = (s.trim() + " ").split(" ");
            if(input.length == 0) continue;
            String commandName = input[0];
            Console.getInstance().printLn(commandName);
            String[] commandArgs = Arrays.copyOfRange(input,1,input.length);
            Commands command = commandsManager.launchCommand(commandName,commandArgs);
            command.execute();
        }
    }

    public static void interactiveMode(){
        while (Console.getInstance().hasNextLine()){
            String s = Console.getInstance().readLine();
            String[] input = (s.trim() + " ").split(" ");
            if(input.length == 0) continue;
            String commandName = input[0];
            String[] commandArgs = Arrays.copyOfRange(input,1,input.length);
            try {
                Commands command = commandsManager.launchCommand(commandName,commandArgs);
                command.execute();
            } catch (Exception e) {
                Console.getInstance().printError(e.getMessage());
            }
        }
    }

    private static ArrayDeque<Vehicle> loadData(String fileName){
        ArrayDeque<Vehicle> data = null;
        File dataFile = null;
        try {
            dataFile = new Loader().loadFile(fileName, "json", "rw", "data file");
        } catch (FileNotFoundException e){
            Console.getInstance().printError(e.getMessage());
        }
       // fileDataManager = new FileDataManager(dataFile);
        try {
        data = fileDataManager.readJSON();
        } catch (Exception e) {
            //Console.getInstance().printError(e.getMessage());
            //Console.getInstance().printError("Data file reading error!");
            //System.exit(0);
        }
        if (data==null) data = new ArrayDeque<>();
        if(!CollectionManager.isValid(data)){
            Console.getInstance().printError("Data file is not valid!");
            System.exit(0);
        }
        Console.getInstance().printLn("Data loaded successfully!");
        return data;
    }
}

