package com.masimo.test;

import java.util.List;

/**
 * Created by sdhruvakumar.
 * A class that calculates the summation of floating point numbers and
 * prints a matrix to console
 */

public class MatrixWrapper {

    private final List<Float> input;
    private final int dimension;
    private final int length;

    public MatrixWrapper(List<Float> input, int dimension, int length) {
        this.input = input;
        this.length = length;
        this.dimension = dimension;
        validate();
    }

    //     Algorithm
    //     k = 0..c
    //     j = 0..c
    //       N-1
    //       ---
    //       \     I    *  I
    //       /      i-k      i-j
    //       ---
    //       i=c
    public void process() {
        for (int column = 0; column <= dimension; column++) {
            System.out.print("| ");
            for (int row = 0; row <= dimension; row++) {
                float output = calculateSummation(column, row);
                // precision : keeping 6 decimal points after dot
                System.out.printf("%6f ", output);
            }
            System.out.print("|\n");
        }
    }

    private float calculateSummation(int column, int row) {
        float sum = 0;
        for (int i = dimension; i < length; i++) {
            float a = (input.get(i - column));
            float b = (input.get(i - row));
            // if results are not contained in floating point then we could use double
            float result = a * b;
            sum += result;
        }
        return sum;
    }


    private void validate() {
        if (dimension >= length) {
            System.err.println("Error: Dimension (-c) cannot be greater or equal to length of input ");
            throw new IllegalArgumentException("Dimension cannot be greater or equal to length of the input");
        }
        if (length != input.size()) {
            System.err.println("Error: length(-n) is not equal to input length. This could lead to Array Out Of Bounds ");
            throw new IllegalArgumentException("Length not equal to input size. If greater this could lead to Array Out Of Bounds ");
        }

    }
}
