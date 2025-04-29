import java.io.File;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;




/**
 * This is the package for Factorial.java
 *
 * The Factorial program reads an int from a file
 * calculates the factorial of the int
 * using recursion
 * then writes the result to a file.
 *
 * <p>This class satisfies style checkers.</p>
 *
 * @author Val Ijaola
 * @version 1.0
 * @since 2025-04-11
 */


public final class Factorial {


    private Factorial() {
        throw new IllegalStateException("Utility class");
    }
    /**
     * This method calculates factorial using recursion.
     *
     * @param num
     * @return the factorial of the int
     */
    public static int factorial(final int num) {
        if (num == 0 || num == 1) {
            return 1;
        }
        return factorial(num - 1) * num;
    }


    /**
     * This is the main method.
     *
     * @param args the command line arguments
     */
    public static void main(final String[] args) {
        try {
            // Specify the file paths
            String filePath = "input.txt";
            File outputFile = new File("output.txt");


            // Create a FileWriter and PrintWriter for the output file
            FileWriter fileWriter = new FileWriter(outputFile);
            PrintWriter printWriter = new PrintWriter(fileWriter);


            // Read the word from the input file
            File file = new File(filePath);
            Scanner scanner = new Scanner(file);


            while (scanner.hasNextLine()) {
                String word = scanner.nextLine();

                // Convert the string to an int
                try {
                    int number = Integer.parseInt(word);

                    if (number < 0) {
                        printWriter.println("Number is negative.");
                    } else if (number > 10) {
                        printWriter.println("Factorial is too large.");
                    } else {
                        int factorialValue = factorial(number);
                        printWriter.println("Factorial = " + factorialValue);
                    }

                } catch (NumberFormatException ex) {
                    printWriter.println(word + " is not a valid integer.");
                }
            }


            // Close the scanner and writer
            scanner.close();
            printWriter.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Error reading the file: " + ex.getMessage());
        } catch (IOException ex) {
            System.out.println("Error writing to the file: " + ex.getMessage());
        }
    }
}
