package me.masha.Commands;

import me.masha.Exeptions.WrongArgsException;
import me.masha.Managers.CollectionManager;
import me.masha.Utility.Console;

public class InfoCommand extends Commands{
    private CollectionManager collectionManager;
    public InfoCommand(CollectionManager collectionManager){
        super("info", "print information about collection");
        this.collectionManager = collectionManager;
    }

    @Override
    public void execute(){
        Console.getInstance().printLn(this.collectionManager.getInfo());
    }

    @Override
    public void initCommandArgs(String[] commandArgs) throws WrongArgsException{
        if(commandArgs.length!=0) throw new WrongArgsException("Wrong amount of arguments!", 0, commandArgs.length);
    }
}
