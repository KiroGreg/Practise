public class SimpleCalculator {

    private double firstNumber;
    private double secondNumber;

    public double getDivisionResult(){
        double divisionValue = secondNumber/firstNumber;
        return divisionValue;
    }

    public double getMultiplicationResult(){
        double multiplicationValue = firstNumber*secondNumber;
        return multiplicationValue;
    }

    public double getAdditionResult(){
        double sumValue = firstNumber+secondNumber;
        return sumValue;
    }

    public double getSubtractionResult(){
        double subtractingValue = secondNumber-firstNumber;
        return subtractingValue;
    }

    public void setFirstNumber(double firstNumber) {
        this.firstNumber = firstNumber;
    }

    public void setSecondNumber(double secondNumber) {
        this.secondNumber = secondNumber;
    }

    public double getFirstNumber() {
        return firstNumber;
    }

    public double getSecondNumber() {
        return secondNumber;
    }
}
