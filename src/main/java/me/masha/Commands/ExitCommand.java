package me.masha.Commands;

import me.masha.Exeptions.WrongArgsException;
import me.masha.Managers.CollectionManager;
import me.masha.Utility.Console;
import me.masha.Utility.YesNoQuestionAsker;

public class ExitCommand extends Commands{
    private CollectionManager collectionManager;
    public ExitCommand(CollectionManager collectionManager){
        super("exit","stop program without saving");
        this.collectionManager = collectionManager;
    }

    @Override
    public void execute(){
        if(this.collectionManager.wasChanged()){
            Console.getInstance().printLn("Last changes aren't saved!");
        }
        YesNoQuestionAsker questionAsker = new YesNoQuestionAsker("Do you want to exit?");
        if(questionAsker.ask()){
            System.exit(0);
        }
    }
    @Override
    public void initCommandArgs(String[] commandArgs) throws WrongArgsException {
        if(commandArgs.length != 0) throw new WrongArgsException("Wrong amount of arguments!", 1, commandArgs.length);
    }
}
