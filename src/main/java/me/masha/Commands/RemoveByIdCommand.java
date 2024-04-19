package me.masha.Commands;

import me.masha.Exeptions.InvalidDataException;
import me.masha.Exeptions.WrongArgsException;
import me.masha.Managers.CollectionManager;
import me.masha.Parsers.Parsers;
import me.masha.Utility.Console;
import me.masha.Utility.Validators;

import java.util.NoSuchElementException;

public class RemoveByIdCommand extends Commands{
    private CollectionManager collectionManager;
    private long id;

    public RemoveByIdCommand(CollectionManager collectionManager){
        super("remove_by_id","id","remove element which id is equal to given");
        this.collectionManager = collectionManager;

    }

    public void execute() throws NoSuchElementException {
        if(!this.collectionManager.containsId(id)){
            throw new NoSuchElementException("No element with such id");
        }
        this.collectionManager.removeById(id);
        Console.getInstance().printLn("Element removed successfully");

    }
    @Override
    public void initCommandArgs(String[] commandArgs) throws WrongArgsException, InvalidDataException {
        if(commandArgs.length != 1) throw new WrongArgsException("Wrong amount of arguments!", 1, commandArgs.length);
        this.id = Parsers.longParser.parse(commandArgs[0]);
        Validators.idValidator.validate(id);
    }
}
