package me.masha.Commands;

import me.masha.Exeptions.WrongArgsException;
import me.masha.Managers.CollectionManager;
import me.masha.Utility.Console;

public class ClearCommand extends Commands{
    private CollectionManager collectionManager;

    public ClearCommand(CollectionManager collectionManager){
        super("clear","delete all element from collection");
        this.collectionManager = collectionManager;
    }

    @Override
    public void execute(){
        this.collectionManager.clear();
        Console.getInstance().printLn("Collection cleared successfully");
    }

    @Override
    public void initCommandArgs(String[] commandArgs) throws WrongArgsException {
        if(commandArgs.length != 0) throw new WrongArgsException("Wrong amount of arguments!", 0, commandArgs.length);
    }
}
