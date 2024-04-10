package me.masha.Models;

import me.masha.Constants;
import me.masha.Exeptions.InvalidDataException;
import me.masha.Parsers.Parser;
import me.masha.Utility.Console;
import me.masha.Utility.Validator;

public abstract class ValueReader {

    public <T> T readValue(String valueName, Validator<T> validator, Parser<T> parser) throws InvalidDataException {
        T value;
        while (true) {
            if(!Constants.SCRIPT_MODE) Console.getInstance().print("Enter " + valueName + ": ");
            String s = Console.getInstance().readLine().trim();
            try {
                value = s.isEmpty() ? null : parser.parse(s);
                validator.validate(value);
                break;
            } catch (InvalidDataException e){
                if(Constants.SCRIPT_MODE) throw e;
                else{
                    Console.getInstance().printLn(e.getMessage());
                }
            }
        }
        return value;
    }
}
