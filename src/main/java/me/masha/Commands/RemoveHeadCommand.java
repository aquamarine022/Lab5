package me.masha.Commands;

import me.masha.Exeptions.WrongArgsException;
import me.masha.Managers.CollectionManager;
import me.masha.Utility.Console;

public class RemoveHeadCommand extends Commands{
    private CollectionManager collectionManager;

    public RemoveHeadCommand(CollectionManager collectionManager){
        super("remove_head", "print and remove first element from collection");
        this.collectionManager = collectionManager;
    }
    @Override
    public void execute(){
       if(this.collectionManager.getCollection().isEmpty()){
           Console.getInstance().printLn("Collection is empty");
           return;
       }
       this.collectionManager.removeHead();
       Console.getInstance().printLn("Element removed successfully");
    }

    @Override
    public void initCommandArgs(String[] commandArgs) throws WrongArgsException {
        if(commandArgs.length != 0) throw new WrongArgsException("Wrong amount of arguments!", 1, commandArgs.length);
    }
}
