package me.masha.Utility;
import java.util.Scanner;

/**
 * console for input and output of the result
 */
public interface Console {
    void print(Object obj);
    void println(Object obj);
    String readln();
    boolean isCanReadln();
    void printError(Object obj);
    void selectFileScanner(Scanner obj);
    void selectConsoleScanner();

}
