package me.masha.Utility;
import java.util.Scanner;

/**
 * console for input and output of the result
 */
public class Console {
    private static Console CONSOLE;
    private Scanner scanner;
    private Console(){}
    public static Console getInstance(){
        if (CONSOLE == null){
            CONSOLE = new Console();
        }
        return CONSOLE;
    }
    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }

    /**
     * Method to get Console scanner
     * @return scanner
     */
    public Scanner getScanner() {
        return scanner;
    }

    /**
     * Method to read next line from input stream
     * @return String line
     */
    public String readLine(){
        return scanner.nextLine();
    }

    /**
     * Method to check if input stream has next line
     * @return true if it has, false otherwise
     */
    public boolean hasNextLine(){
        return scanner.hasNextLine();
    }

    /**
     * Method to print data to user output
     * @param o Object to print
     */
    public void print(Object o){
        System.out.print(o);
    }

    /**
     * Method to print data to user output with \n in the end
     * @param o Object to print
     */
    public void printLn(Object o){
        System.out.println(o);
    }
    /**
     * Method to print error message to user
     * @param error Message to print
     */
    public void printError(String error){
        System.err.println(error);
    }


}
