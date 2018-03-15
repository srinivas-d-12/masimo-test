package com.masimo.test;


import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by sdhruvakumar.
 * A command line tool to parse input and respresent the summation in
 * a matrix.
 */
public class Main {


    public static void main(String[] argv) {

        Args args = new Args();
        JCommander jc = JCommander.newBuilder()
                .addObject(args)
                .build();

        try {
            jc.parse(argv);
        } catch (Exception e) {
            System.err.printf("Error: %s%n", e.getMessage());

            jc.usage();
            System.exit(1);
        }

        if (args.help) {
            jc.usage();
            return;
        }

        List input = parseFile(args.filePath);
        MatrixWrapper matrixWrapper = new MatrixWrapper(input, args.dimension, args.length);
        matrixWrapper.process();

    }

    private static List<Float> parseFile(String path) {
        List<Float> input = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                if (!line.isEmpty()) {
                    input.add(Float.parseFloat(line));
                }
            }
        } catch (NumberFormatException ex) {
            System.err.printf("Error: Converting to float: %s%n", ex.getMessage());
            System.exit(1);

        } catch (IOException ex) {
            System.err.printf("Error: File Not Found: %s%n", ex.getMessage());
            System.exit(1);
        }

        return input;
    }


    static class Args {
        @Parameter(names = {"-file", "-f"}, required = true,
                description = "input file path")
        String filePath;

        @Parameter(names = "-c", required = true, description = "matrix dimension C X C")
        int dimension;

        @Parameter(names = "-n", required = true, description = "size of the input list")
        int length;

        @Parameter(names = {"-help", "-h"}, help = true, description = "print this help message")
        boolean help;
    }
}
