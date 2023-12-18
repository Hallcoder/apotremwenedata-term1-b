package rw.ac.rca.apotremwenedataterm1b.services;

import rw.ac.rca.apotremwenedataterm1b.exceptions.InvalidOperationException;

public interface MathOperator {
    public double doMath(double operand1, double operand2, String operation) throws InvalidOperationException;
}
