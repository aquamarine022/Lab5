package me.masha.Commands;

import me.masha.Constants;
import me.masha.Exeptions.RecursiveScriptException;
import me.masha.Exeptions.WrongArgsException;
import me.masha.Main;
import me.masha.Managers.Loader;
import me.masha.Utility.Console;

import java.io.File;
import java.io.FileInputStream;
import java.util.Scanner;

public class ExecuteScriptCommand extends Commands{
    private String scriptFilePath;
    public ExecuteScriptCommand(){
        super("execute_script", "file_name", "read and execute script from given file");
    }

    @Override
    public void execute() throws Exception{
        File scriptFile = new Loader().loadFile(scriptFilePath, "txt", "r", "Script file");

        if(!Constants.scriptStack.isEmpty() && Constants.scriptStack.contains(scriptFilePath)){
            throw new RecursiveScriptException("Script is recursive");
        }

        Constants.scriptStack.push(scriptFilePath);

        Scanner prevScanner = Console.getInstance().getScanner();
        Console.getInstance().setScanner(new Scanner(new FileInputStream(scriptFile)));

        Constants.SCRIPT_MODE = true;

        try {
            Main.scriptMode();
            Console.getInstance().printLn("Script executed successfully!");
        }finally {
            Constants.scriptStack.pop();
            Constants.SCRIPT_MODE = false;
            Console.getInstance().setScanner(prevScanner);
        }
    }
    @Override
    public void initCommandArgs(String[] commandArgs) throws WrongArgsException {
        if(commandArgs.length != 1) throw new WrongArgsException("Wrong amount of arguments!", 1, commandArgs.length);
        this.scriptFilePath = commandArgs[0];
    }
}
