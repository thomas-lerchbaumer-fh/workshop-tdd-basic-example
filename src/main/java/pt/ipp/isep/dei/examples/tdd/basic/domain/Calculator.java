package pt.ipp.isep.dei.examples.tdd.basic.domain;

import static java.lang.Integer.MAX_VALUE;

/**
 * Calculator class.
 * This class is very simple in order to demonstrate how to build test cases for Unit Testing.
 */
public class Calculator {

    /**
     * Sums one operand to the other, returning the result.
     *
     * @param firstOperand  First operand to sum.
     * @param secondOperand Second Operand to sum.
     * @return The sum of firstOperand with secondOperand.
     */
    public int sum(int firstOperand, int secondOperand) throws ArithmeticException {
            int res = firstOperand + secondOperand;
            //if(res > MAX_VALUE || res < Integer.MIN_VALUE) throw new ArithmeticException("overflow");

           return firstOperand + secondOperand;

    }

    public int subtract(int firstOperand, int secondOperand) {
        return firstOperand - secondOperand;
    }

    public int divide(int dividend, int divisor) {
        if(divisor == 0)
            throw new ArithmeticException("Division by zero");

        return dividend / divisor;
    }

    public int multiply(int firstOperand, int secondOperand) {
        throw new UnsupportedOperationException();
    }

    public int factorial(int firstOperand) {
        throw new UnsupportedOperationException();
    }
}
