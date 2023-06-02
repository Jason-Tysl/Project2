/*
 * @author Jason Tysl.
 */

import java.util.HashMap;
import java.util.Stack;

public class Parser {
    
    // Initialize instance variables to be used throughout the program

    public static Scanner scanner;

    // Using a stack of maps allows easy recursive search through the tree as well as single-layer searches
    public static Stack<HashMap<String, Core>> stackOfMaps;

    


    public static void printHello(String str) {
        System.out.println(str);
    }

}
