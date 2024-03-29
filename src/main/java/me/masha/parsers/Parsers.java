package me.masha.parsers;


import me.masha.Exeptions.InvalidDataException;


import java.time.format.DateTimeParseException;

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
}
