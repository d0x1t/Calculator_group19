/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator.Entity;

import org.apache.commons.math3.complex.Complex;

/**
 *
 * @author Admin
 */
public class OperationComplexNumber implements OperationCalculator {

    private double real;
    private double imaginary;

    public OperationComplexNumber(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    public OperationComplexNumber(String complex_number) {

    }

    public double getReal() {
        return real;
    }

    public double getImaginary() {
        return imaginary;
    }

    @Override
    public OperationComplexNumber add(OperationComplexNumber other) {
        Complex cn = new Complex(this.real, this.imaginary);
        Complex cn2 = new Complex(other.real, other.imaginary);
        Complex result = cn.add(cn2);
        return new OperationComplexNumber(result.getReal(), result.getImaginary());
    }

    @Override
    public OperationComplexNumber subtract(OperationComplexNumber other) {
        Complex cn = new Complex(this.real, this.imaginary);
        Complex cn2 = new Complex(other.real, other.imaginary);
        Complex result = cn.subtract(cn2);
        return new OperationComplexNumber(result.getReal(), result.getImaginary());
    }

    @Override
    public OperationComplexNumber multiply(OperationComplexNumber other) {
        Complex cn = new Complex(this.real, this.imaginary);
        Complex cn2 = new Complex(other.real, other.imaginary);
        Complex result = cn.multiply(cn2);
        return new OperationComplexNumber(result.getReal(), result.getImaginary());
    }

    @Override
    public OperationComplexNumber divide(OperationComplexNumber other) {
        Complex cn = new Complex(this.real, this.imaginary);
        Complex cn2 = new Complex(other.real, other.imaginary);
        Complex result = cn.divide(cn2);

        return new OperationComplexNumber(result.getReal(), result.getImaginary());

    }

    @Override
    public OperationComplexNumber sqrt() {

        Complex cn = new Complex(this.real, this.imaginary);
        Complex cn2 = cn.sqrt();
        return new OperationComplexNumber(cn2.getReal(), cn2.getImaginary());
    }

    @Override
    public OperationComplexNumber inverse() {

        if (this.real == 0.0 && this.imaginary == 0.0) {
            return this;
        }
        if (this.real == 0.0 && this.imaginary != 0.0) {
            return new OperationComplexNumber(this.real, -this.imaginary);
        }
        if (this.real != 0.0 && this.imaginary == 0.0) {
            return new OperationComplexNumber(-this.real, this.imaginary);
        }
        return new OperationComplexNumber(-this.real, -this.imaginary);
    }

    @Override
    public OperationComplexNumber negate() {
        return new OperationComplexNumber(-this.real, -this.imaginary);
    }

    public String formatDouble(double value) {
      return null;
    }

    @Override
    public String toString() {

    return null;
}
}
