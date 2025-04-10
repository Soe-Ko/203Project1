public class BigNumArithmetic {

    /**
     * The entry point of the program.
     * @param args Command line arguments. Should have exactly one argument: a file name.
     */

    public static void main(String[] args) {
//        if (args.length != 1) {
//            throw new IllegalArgumentException(
//                    "Expected exactly 1 argument: a file name.");
//        }
//        String filePath = args[0];
//        FileProcessor.processFile(filePath);

        // assuming the Linked List class..
            // 1. takes a String of numbers as an argument
            // 2. converts the String to a Linked List of nodes
            // 3. each Node contains an integer value and a next *note that Node is its own class*
            // 3. supports the operations adding and getting

        // for the number of lines in our file, do:
            // init a Linked List to store the first number
            // init a char to store the operator
            // init a Linked List to store the second number

            // use a switch case on the variable storing the operator
                // case +:
                    // call the add method
                // case *:
                    // call the multiplication method
                // case ^:
                    // call the exp method

    }

    // create the private add method
    /**
     * Adds two numbers.
     *
     * @param numA A number to be added, represented by a Linked List
     * @param numB A number to be added, represented by a Linked List
     * @return The integer result of adding numA and numB
     */

    // create the private multiplitication method
    /**
     * Multiplies two numbers.
     *
     * @param numA A number to be multiplied, represented by a Linked List
     * @param numB A number to be multiplied, represented by a Linked List
     * @return The integer result of multiplying numA and numB
     */

    // create the private exponentiation method
    /**
     * Raises a number to a specified power.
     *
     * @param mum A base number to be multiplied, represented by a Linked List
     * @param exp The number of times to multiply *num* by itself, represented by a Linked List
     * @return The integer result of raising *num* to the specified power
     */
}