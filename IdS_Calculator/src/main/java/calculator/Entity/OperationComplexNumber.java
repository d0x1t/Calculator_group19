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
        this.real = 0.0;
        this.imaginary = 0.0;

        if (complex_number == null) {
            return;
        }

        //CONTROLLO DEI CASI LIMITE: L'UTENTE HA INSERITO: j o +j o -j
        if (complex_number.equals("+j") || complex_number.equals("j")) {
            this.real = 0.0;
            this.imaginary = 1.0;
            return;
        } else if (complex_number.equals("-j")) {
            this.real = 0.0;
            this.imaginary = -1.0;
            return;
        }

        //CONTROLLO SE L'UTENTE HA INSERITO SOLO UN NUMERO REALE
        int jIndex = complex_number.indexOf('j');   //indexOf restituisce l'indice della stringa appena trova il carattere j. ritorna -1 in caso contrario.
        if (jIndex == -1) { // Nessuna parte immaginaria
            this.real = Double.parseDouble(complex_number);
            this.imaginary = 0.0;
            return;
        }

        // Rimuove 'j' dalla sua posizione
        complex_number = complex_number.replace("j", "");

        // Trova l'indice di inizio della seconda parte
        int lastPlusMinus = Math.max(complex_number.lastIndexOf('+'), complex_number.lastIndexOf('-'));
        if (lastPlusMinus >= 0) {
            // Estrai le parti
            String firstPart = complex_number.substring(0, lastPlusMinus);
            String secondPart = complex_number.substring(lastPlusMinus);

            // Determina quale parte è reale e quale è immaginaria
            if (jIndex != -1 && jIndex <= lastPlusMinus) {
                // La parte immaginaria è prima
                if (firstPart.equals("+") || firstPart.equals("-") || firstPart.isEmpty()) {
                    this.imaginary = 1.0;
                } else {
                    this.imaginary = Double.parseDouble(firstPart);
                }

                this.real = secondPart.isEmpty() ? 0.0 : Double.parseDouble(secondPart);
            } else {
                // La parte reale è prima
                this.real = firstPart.isEmpty() ? 0.0 : Double.parseDouble(firstPart);

                if (secondPart.equals("+") || secondPart.equals("-") || secondPart.isEmpty()) {
                    this.imaginary = 1.0;
                } else {
                    this.imaginary = Double.parseDouble(secondPart);
                }
            }
        } else {
            if (jIndex != -1) { // Se c'era 'j', allora è tutto immaginario
                this.imaginary = Double.parseDouble(complex_number);
                this.real = 0.0;
            } else { // Altrimenti, è tutto reale
                this.real = Double.parseDouble(complex_number);
                this.imaginary = 0.0;
            }
        }
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

    public String formatDouble(double value) {
        if (value == (long) value) {
            // Se il valore è effettivamente un intero, convertilo direttamente in Long e poi in String
            return String.format("%d", (long) value);
        } else {
            // Altrimenti, usa String.format per ridurre il numero di cifre decimali solo se necessario
            return String.format("%.2f", value).replaceAll("0*$", "").replaceAll("\\.$", "");
        }
    }

    @Override
    public String toString() {

    return null;
}

 
}
