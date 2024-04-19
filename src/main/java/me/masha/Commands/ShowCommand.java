package me.masha.Commands;

import me.masha.Exeptions.WrongArgsException;
import me.masha.Managers.CollectionManager;
import me.masha.Utility.Console;

public class ShowCommand extends Commands{
    private CollectionManager collectionManager;

    public ShowCommand(CollectionManager collectionManager){
        super("show","print all elements of collection");
        this.collectionManager=collectionManager;
    }

    @Override
    public void execute(){
        if(this.collectionManager.getCollection().isEmpty()){
            Console.getInstance().printLn("Collection is empty");
            return;
        }
        this.collectionManager.getCollection().forEach(vehicle -> Console.getInstance().printLn(vehicle));
    }

    @Override
    public void initCommandArgs(String[] commandArgs) throws WrongArgsException {
        if(commandArgs.length != 0) throw new WrongArgsException("Wrong amount of arguments!", 1, commandArgs.length);
    }
}
