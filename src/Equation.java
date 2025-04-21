public class Equation {
    private LinkedLst firstNumber;
    private LinkedLst secNumber;
    private char operator;
    private LinkedLst answer;

    Equation() {
        this.firstNumber = null;
        this.secNumber = null;
        this.operator = ' ';
    }

    Equation(LinkedLst firstNumber, LinkedLst secNumber, char operator) {
        this.firstNumber = firstNumber;
        this.secNumber = secNumber;
        this.operator = operator;
    }

    public LinkedLst getFirstNumber() {
        return this.firstNumber;
    }

    public void setFirstNumber(LinkedLst firstNum) {
        this.firstNumber = firstNum;
    }

    public LinkedLst getSecNumber() {
        return this.secNumber;
    }

    public void setSecNumber(LinkedLst secNum) {
        this.secNumber = secNum;
    }

    public char getOperator() {
        return this.operator;
    }

    public void setOperator(char op) {
        this.operator = op;
    }

    public LinkedLst getAnswer() {
        return answer;
    }

    public void setAnswer(LinkedLst answer) {
        this.answer = answer;
    }

    /**
     * Adds two numbers stored in the Equation class (firstNum and secNum)
     */
    public void addTwoNums() {
        LinkedLst finalAnswer = new LinkedLst(); // Stored in a linked list to represent # as single digits in a LL
        LinkedLst firstNum = this.getFirstNumber();
        LinkedLst secNum = this.getSecNumber();
        int firstNumDig; // declaring variables early for clarity
        int secNumDig;
        int columnTotal;
        int columnRemainder;
        int columnCarry = 0;
        int countLoop = 0;

        while(countLoop < firstNum.getSize() || countLoop < secNum.getSize()) { // runs until all digits are explored

            // if-else logic takes care of one number being shorter than the other
            if(countLoop >= firstNum.getSize()){
                firstNumDig = 0;
                secNumDig = secNum.getNum(countLoop);

            } else if(countLoop >= secNum.getSize()){
                firstNumDig = firstNum.getNum(countLoop);
                secNumDig = 0;

            } else {
                firstNumDig = firstNum.getNum(countLoop);
                secNumDig = secNum.getNum(countLoop);
            }

            columnTotal = firstNumDig + secNumDig + columnCarry; // adding total, including columnCarry to account for carried values
            columnCarry = columnTotal /  10; // storing the powers of ten to add to next column
            columnRemainder = columnTotal % 10;
            finalAnswer.addNumBack(columnRemainder); // only recording remainder to account for carried values in columnCarry
            countLoop++; // incrementing to keep track of loop number
        }

        if(columnCarry > 0){ // in case the final two digits create a num to be carried
            finalAnswer.addNumBack(columnCarry);
        }

        finalAnswer.removeLeadZeros();
        this.setAnswer(finalAnswer); // store our answer in our equation object (to be printed separately)

    }

    /**
     * Multiplies two numbers stored in the Equation class (firstNum and secNum)
     */
    public void multiplyTwoNums() {
        LinkedLst finalAnswer = new LinkedLst(); // Stored in a linked list to represent # as single digits in a LL
        LinkedLst firstNum = this.getFirstNumber();
        LinkedLst secNum = this.getSecNumber();
        int totalNum = 0;
        String totalString;
        int tempTotal;
        int placeValueI;
        int placeValueJ;

        for(int i = firstNum.getSize() - 1; i >= 0; i--) { // multiplying all digits of one number...
            int firstDigit = firstNum.getNum(i);
            tempTotal = 0;
            placeValueI = (int) Math.pow(10, i);

            for(int j = secNum.getSize() - 1; j >= 0; j--) { // by all digits of another number
                placeValueJ = (int) Math.pow(10, j);
                int secDigit = secNum.getNum(j);
                tempTotal = tempTotal + (placeValueJ * (firstDigit * secDigit)); // multiply by placeValueJ to account for decimal system
            }
            totalNum += placeValueI * tempTotal; // multiply by placeValueI to account for decimal system
        }

        totalString = "" + totalNum;

        for(char ch : totalString.toCharArray()) {
            finalAnswer.addNumBack(ch - '0');
        }

        finalAnswer.removeLeadZeros();
        this.setAnswer(finalAnswer);
    }

//    public void multiplyTwoNums() {
//        LinkedLst finalAnswer = new LinkedLst();
//        LinkedLst firstNum = this.getFirstNumber();
//        LinkedLst secNum = this.getSecNumber();
//        int digitFirst;
//        int digitSec;
//        int columnTotal;
//        int columnRemainder;
//        int columnCarry = 0;
//
//        for(int i = firstNum.getSize() - 1; i >= 0; i--) {
//            digitFirst = firstNum.getNum(i);
//            LinkedLst temp = new LinkedLst();
//
//            for(int j = secNum.getSize() - 1; j >= 0; j--) {
//                digitSec = secNum.getNum(i);
//                columnTotal = digitFirst * digitSec;
//                columnRemainder = columnTotal / 10;
//                columnCarry = columnTotal % 10;
//                finalAnswer.addNumBack(columnRemainder);
//            }
//        }
//    }

    /**
     * Prints the specified equation. Formatted like [firstNum] [operator] [secNum] = [answer]
     */
    public void printEq(){
        LinkedLst firstNum = this.getFirstNumber();
        LinkedLst secNum = this.getSecNumber();
        LinkedLst ans = this.getAnswer();

        for(int i = firstNum.getSize() - 1; i >= 0; i--) {
            System.out.print(firstNum.getNum(i));
        }

        System.out.print(" " + this.getOperator() + " ");

        for(int i = secNum.getSize() - 1; i >= 0; i--) {
            System.out.print(secNum.getNum(i));
        }

        System.out.print(" = ");

        for(int i = 0; i < ans.getSize(); i++) {
            System.out.print(ans.getNum(i));
        }

        System.out.println();
    }

    public void exponent() {
        LinkedLst base = this.getFirstNumber();
        LinkedLst exponent = this.getSecNumber();
        LinkedLst oldAns;

        String expo_str = exponent.getExpoInt();
        int expo_int = Integer.parseInt(expo_str);

        Equation temp = new Equation(base, base, '*');
        temp.multiplyTwoNums();
        oldAns = temp.getAnswer();
//        LinkedLst temp = multiply(base, base);

        // If odd
        if(expo_int % 2 == 1){
            for(int i = 0; i <= (expo_int - 1)/2; i++){
                oldAns = temp.getAnswer();
                temp.setFirstNumber(oldAns);
                temp.multiplyTwoNums();
                //temp = multiply(temp, base);
            }
            temp.setFirstNumber(oldAns);
            temp.multiplyTwoNums();
            this.setAnswer(temp.getAnswer());
            //return multiply(temp, base);
        }
        // If even
        else{
            for(int i = 0; i < expo_int/2; i++){
                oldAns = temp.getAnswer();
                temp.setFirstNumber(oldAns);
                temp.multiplyTwoNums();
                // temp = multiply(temp, base);
            }
            this.setAnswer(temp.getAnswer());
            // return temp;
        }
    }
}
