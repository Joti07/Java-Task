package model;
import java.util.Objects;

public final class Operation {
    private final double numOne;
    private final double numTwo;
    private final String operator;
    private final double result;

    public Operation(double numOne, double numTwo, String operator) {
        this.numOne = numOne;
        this.numTwo = numTwo;
        this.operator = operator;
        this.result = calculate();
    }

    private double calculate() {
        switch (operator) {
            case "+": return numOne + numTwo;
            case "-": return numOne - numTwo;
            case "*": return numOne * numTwo;
            case "/": return numTwo != 0 ? numOne / numTwo : Double.NaN;
            default: return Double.NaN;
        }
    }

    // Getters
    public double getNumOne() { return numOne; }
    public double getNumTwo() { return numTwo; }
    public String getOperator() { return operator; }
    public double getResult() { return result; }

    @Override
    public String toString() {
        return numOne + " " + operator + " " + numTwo + " = " + result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Operation)) return false;
        Operation that = (Operation) o;
        return Double.compare(that.numOne, numOne) == 0 &&
                Double.compare(that.numTwo, numTwo) == 0 &&
                Double.compare(that.result, result) == 0 &&
                Objects.equals(operator, that.operator);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numOne, numTwo, operator, result);
    }
}
