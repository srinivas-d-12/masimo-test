package com.masimo.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;

/**
 * Created by sdhruvakumar.
 */
@RunWith(MockitoJUnitRunner.class)
public class MatrixWrapperTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));

    }


    @Test(expected = IllegalArgumentException.class)
    public void testInValidMatrixWrapperInstantiation() {
        // dimension cannot be greater than length
        MatrixWrapper matrixWrapper = new MatrixWrapper(new ArrayList<Float>(Arrays.asList(0.026f, 0.025f)), 4, 2);
    }


    @Test
    public void testProcess() {
        MatrixWrapper matrixWrapper = new MatrixWrapper(new ArrayList<Float>(Arrays.asList(0.0532925166190f,
                0.0516683794558f,
                0.0476902537048f,
                0.0413647554815f,
                0.0329319946468f)), 1, 5);
        matrixWrapper.process();
        assertEquals("| 0.007740 0.008553 |\n" +
                "| 0.008553 0.009495 |\n", outContent.toString());

    }

    @After
    public void restoreStreams() {
        System.setOut(System.out);
    }

}
