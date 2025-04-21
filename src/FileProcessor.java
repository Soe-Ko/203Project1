import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileProcessor {

    /**
     * Processes arithmetic expressions line-by-line in the given file.
     *
     * @param filePath Path to a file containing arithmetic expressions.
     */
    public static LinkedLst processFile(String filePath) {
        File infile = new File(filePath);
        LinkedLst equationList = new LinkedLst();

        try (Scanner scan = new Scanner(infile)) {

            while (scan.hasNext()) {
                String line = scan.nextLine();
                Equation equation = new Equation();
                LinkedLst first = new LinkedLst();
                LinkedLst second = new LinkedLst();
                boolean firstNum = true; // create a boolean to track which part of the equation is being observed
                                        // ex. True means the first number or operator, False means the second number

                for(char ch: line.toCharArray()) {
                    if (ch == ' '){
                        continue; // move on if we see a space

                    } else if (ch == '+' || ch == '*' || ch == '^') {
                        equation.setFirstNumber(first); // once you reach the operator, you know you are finished recording the first num
                        equation.setOperator(ch);  // you also record the operator so you know what operation to perform later
                        firstNum = false; // since you are no longer on the first num, change to false...

                    } else if (!firstNum) { // ... thus, you start recording the second number
                        second.addNumFront(ch - '0');

                    } else{ // if you are not at an operator and not on the second num, you must be on the first num
                        first.addNumFront(ch - '0');
                    }

                }

                if(first.getSize() != 0) { // to catch blank or empty lines. you *will* have a first number if your line is not empty
                    equation.setSecNumber(second);
                    equationList.addEq(equation);
                }
            }
            return equationList;

        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + infile.getPath());
            return equationList; // return an empty linked list
        }
    }
}
