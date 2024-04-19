package me.masha.Commands;

import me.masha.Exeptions.WrongArgsException;
import me.masha.Managers.CollectionManager;
import me.masha.Managers.FileDataManager;
import me.masha.Utility.Console;

import java.io.IOException;

public class SaveCommand extends Commands{
    private CollectionManager collectionManager;
    private FileDataManager fileDataManager;
    public SaveCommand(CollectionManager collectionManager, FileDataManager fileDataManager){
        super("save", "save collection to data file");
        this.collectionManager = collectionManager;
        this.fileDataManager = fileDataManager;
    }

    @Override
    public void execute() throws IOException {
        try {
            this.fileDataManager.writeToFile(this.collectionManager.getCollection());
            this.collectionManager.removeFlag();
            Console.getInstance().printLn("Collection saved successfully");

        }
        catch (IOException e){
            throw new IOException("An error occurred while writing the file");
        }
    }
    @Override
    public void initCommandArgs(String[] commandArgs) throws WrongArgsException {
        if(commandArgs.length != 0) throw new WrongArgsException("Wrong amount of arguments!", 0, commandArgs.length);
    }
}
