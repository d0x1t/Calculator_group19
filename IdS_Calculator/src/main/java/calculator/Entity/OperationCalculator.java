package calculator.Entity;

public interface OperationCalculator {

    public OperationComplexNumber add(OperationComplexNumber other);

    public OperationComplexNumber subtract(OperationComplexNumber other);

    public OperationComplexNumber multiply(OperationComplexNumber other);

    public OperationComplexNumber divide(OperationComplexNumber other);

    public OperationComplexNumber sqrt();

    public OperationComplexNumber inverse();

    public OperationComplexNumber negate();

    @Override
    public String toString();
}
