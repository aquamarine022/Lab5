package me.masha.Parsers;


import me.masha.Exeptions.InvalidDataException;
import me.masha.Models.VehicleType;

/**
 * Class with parsers which are required to read Worker objects
 */
public class Parsers {
    /**
     * String parser
     */
    public static Parser<String> stringParser = s -> s;
    /**
     * Long parser
     */
    public static Parser<Long> longParser = s -> {
        try{
            return Long.parseLong(s);
        } catch (NumberFormatException e){
            throw new InvalidDataException("Value must be a long!");
        }
    };
    /**
     * Integer parser
     */
    public static Parser<Integer> integerParser = s -> {
        try{
            return Integer.parseInt(s);
        } catch (NumberFormatException e){
            throw new InvalidDataException("Value must be an integer!");
        }
    };
    /**
     * Double parser
     */
    public static Parser<Double> doubleParser = s -> {
        try{
            return Double.parseDouble(s);
        } catch (NumberFormatException e){
            throw new InvalidDataException("Value must be a double!");
        }
    };
    /**
     * VehicleType parser
     */
    public static Parser<VehicleType> statusParser = s -> {
        try{
            return VehicleType.valueOf(s);
        } catch (IllegalArgumentException e){
            throw new InvalidDataException("VehicleType not found! Please choose value from list!");
        }
    };
}
