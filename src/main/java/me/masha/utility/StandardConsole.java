package me.masha.utility;

import java.util.Scanner;

/**
 * class for input and output of the result
 */
public class StandardConsole implements Console{
    private static final String P = "$ ";
    private static Scanner fileScanner = null;
    private static Scanner defScanner = new Scanner(System.in);
    /**
     * output obj.toString() in console
     * @param obj - object for output
     */
    @Override
    public void print(Object obj) {
        System.out.print(obj);
    }

    /**
     * output obj.toString() + \n in console
     * @param obj - object for output
     */
    @Override
    public void println(Object obj) {
        System.out.println(obj);
    }
    @Override
    public String readln() {
        return (fileScanner!=null?fileScanner:defScanner).nextLine();
    }
    @Override
    public boolean isCanReadln() {
        return (fileScanner!=null?fileScanner:defScanner).hasNextLine();
    }

    /**
     * output error: obj.toString()
     * @param obj - name of the error
     */
    @Override
    public void printError(Object obj) {
        System.err.println("Error: " + obj);
    }

    /**
     * @param scanner
     */
    @Override
    public void selectFileScanner(Scanner scanner) {
        this.fileScanner = scanner;
    }

    /**
     *
     */
    @Override
    public void selectConsoleScanner() {
        this.fileScanner = null;
    }
}
