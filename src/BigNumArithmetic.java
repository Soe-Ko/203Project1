public class BigNumArithmetic {
    /**
     * The entry point of the program.
     *
     * @param args Command line arguments. Should have exactly one argument: a file name.
     */
    public static void main(String[] args) {
        // Declaring variables to be initialized later.
        int sizeEqLst;
        Equation eq;

        if (args.length != 1) {
            throw new IllegalArgumentException(
                    "Expected exactly 1 argument: a file name.");
        }

        String filePath = args[0];
        LinkedLst equationList = FileProcessor.processFile(filePath);
        sizeEqLst = equationList.getSize();

        if (sizeEqLst != 0) { // if you have a non-empty file, do:

            for (int i = 0; i < sizeEqLst; i++) { // iterate through the equations in our file
                eq = equationList.getEq(i); // get the ith equation
                char operator = eq.getOperator();

                switch (operator) {
                    case '+':
                        eq.addTwoNums();
                        eq.printEq();
                        break;
                    case '*':
                        eq.multiplyTwoNums();
                        eq.printEq();
                        break;
                        // call multiplication method on the equation
                    case '^':
                        eq.exponent();
                        eq.printEq();
                        // call exponentiation method on equation
                }
            }
        }
    }
}

    // exponent stuff:
    //  if odd: (x * x^2) ^ ((n-1)/2)
    //  if even: (x^2) ^ (n/2)
    // for test cases:
    // control shift t... select JUnit5... select which files you want to test
    // ex.
    // assertEquals(*expected ans*, method(param));
    // note, if your function is not static, you need to create an obj first


