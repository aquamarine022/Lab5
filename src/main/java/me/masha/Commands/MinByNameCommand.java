package me.masha.Commands;

import me.masha.Exeptions.WrongArgsException;
import me.masha.Managers.CollectionManager;
import me.masha.Utility.Console;

public class MinByNameCommand extends Commands{
    private CollectionManager collectionManager;

    public MinByNameCommand(CollectionManager collectionManager){
        super("min_by_name", "print any element which name is minimal");
        this.collectionManager = collectionManager;
    }

    @Override
    public void execute(){
        if(this.collectionManager.getCollection().isEmpty()){
            Console.getInstance().printLn("Collection is empty");
            return;
        }
        this.collectionManager.removeHead();
        Console.getInstance().printLn(this.collectionManager.getMinByName());
    }

    @Override
    public void initCommandArgs(String[] commandArgs) throws WrongArgsException {
        if(commandArgs.length != 0) throw new WrongArgsException("Wrong amount of arguments!", 1, commandArgs.length);
    }
}
