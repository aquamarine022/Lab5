package me.masha.Managers;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;

import com.google.gson.stream.JsonReader;
import me.masha.Constants;
import me.masha.Models.Vehicle;
import me.masha.Parsers.*;

import java.io.*;
import java.lang.reflect.Type;
import java.util.Date;
import java.util.PriorityQueue;

public class FileDataManager {
    /**
     * path to file with data
     */
    private final File file;
    /**
     * object for operations with Json
     */
    private final Gson gson;

    /**
     * conctructor
     * @param file file with data
     */
    public FileDataManager(File file){
        this.file = file;

        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(Date.class, new CreationDateDeserializer());
        gsonBuilder.registerTypeAdapter(Date.class, new CreationDateSerializer());

        this.gson = gsonBuilder.registerTypeAdapter(Date.class, Constants.formatter).serializeNulls().setPrettyPrinting().create();
    }

    /**
     * Metod to input collection to file
     * @param data collection to write
     * @throws IOException in case there are errors while writing
     */
    public void writeTofile(PriorityQueue<Vehicle> data) throws IOException {
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream(file));
        Type dataType = new TypeToken<PriorityQueue<Vehicle>>(){}.getType();
        String output = this.gson.toJson(data, dataType);
        outputStreamWriter.write(output);
        outputStreamWriter.flush();
        outputStreamWriter.close();
    }

    /**
     * Method to read data from file
     * @return collection
     * @throws IOException in case there are errors while reading
     * @throws JsonParseException in case there are troubles with deserializing
     */
    public PriorityQueue<Vehicle> readJSON() throws IOException, JsonParseException {
        InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(file));
        Type dataType = new TypeToken<PriorityQueue<Vehicle>>(){}.getType();
        return this.gson.fromJson(new JsonReader(inputStreamReader), dataType);
    }
}
