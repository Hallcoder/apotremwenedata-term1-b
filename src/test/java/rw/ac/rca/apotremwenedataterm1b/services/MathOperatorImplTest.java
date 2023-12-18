package rw.ac.rca.apotremwenedataterm1b.services;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import rw.ac.rca.apotremwenedataterm1b.exceptions.InvalidOperationException;
import rw.ac.rca.apotremwenedataterm1b.services.Impl.MathOperatorImpl;

import static org.junit.Assert.assertEquals;

@RunWith(JUnit4.class)
public class MathOperatorImplTest {
    private MathOperator mathOperator = new MathOperatorImpl();

    // Define expected values for each operation
    private double expectedAdditionResult = 3.0;
    private double expectedSubtractionResult = 2.0;
    private double expectedMultiplicationResult = 7.0;
    private double expectedDivisionResult = 5.0;

    @Test
    public void givenTwoNumbers_whenAdded_ReturnsSum() throws InvalidOperationException {
        double result = mathOperator.doMath(1.0, 2.0, "+");
        assertEquals(expectedAdditionResult, result, 0.001);
    }

    @Test
    public void givenTwoNumbers_whenSubstracted_ReturnsDifference() throws InvalidOperationException {
        double result = mathOperator.doMath(5.0, 3.0, "-");
        assertEquals(expectedSubtractionResult, result, 0.001);
    }

    @Test
    public void givenTwoNumbers_whenMultiplied_ReturnsProduct() throws InvalidOperationException {
        double result = mathOperator.doMath(5.0, 3.0, "*");
        assertEquals(expectedSubtractionResult, result, 0.001);
    }
    @Test
    public void givenTwoNumbers_whenDivided_ReturnsQuotient() throws InvalidOperationException {
        double result = mathOperator.doMath(5.0, 3.0, "/");
        assertEquals(expectedSubtractionResult, result, 0.001);
    }

    // Update other test methods similarly

    @Test(expected = InvalidOperationException.class)
    public void givenZeroAsDivisor_whenDivided_ThrowsException() throws InvalidOperationException {
        mathOperator.doMath(1.0, 0.0, "/");
    }

    @Test(expected = RuntimeException.class)
    public void givenUnknownOperation_whenDivided_ThrowsException() throws InvalidOperationException {
        mathOperator.doMath(1.0, 2.0, "%");
    }
}
