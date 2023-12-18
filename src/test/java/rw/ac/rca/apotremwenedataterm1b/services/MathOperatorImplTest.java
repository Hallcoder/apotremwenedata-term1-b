package rw.ac.rca.apotremwenedataterm1b.services;


import org.hamcrest.MatcherAssert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.Mockito;
import rw.ac.rca.apotremwenedataterm1b.exceptions.InvalidOperationException;
import rw.ac.rca.apotremwenedataterm1b.services.Impl.MathOperatorImpl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

@RunWith(JUnit4.class)
public class MathOperatorImplTest {
    private MathOperator mathOperator = new MathOperatorImpl();
    private final MathOperatorImpl mathOperatorService = Mockito.mock(MathOperatorImpl.class);
    // Define expected values for each operation
    private double expectedAdditionResult = 3.0;
    private double expectedSubtractionResult = 2.0;
    private double expectedMultiplicationResult = 15.0;
    private double expectedDivisionResult = 1.0;

    @Test
    public void givenTwoNumbers_whenAdded_ReturnsSum() throws InvalidOperationException {
        double result = mathOperator.doMath(1.0, 2.0, "+");
        assertEquals(expectedAdditionResult, result, 0.001);
    }
    @Test
    public void should_create_math_operation_success() throws InvalidOperationException {
        double operand1 = 8;
        double operand2 = 4;
        String operation = "+";

        double mathOperation = mathOperatorService.doMath(operand1,operand2, operation);
        when(mathOperatorService.doMath(operand1, operand2, operation)).thenReturn(mathOperation);

        double actualMathOperator = mathOperatorService.doMath(operand1, operand2, operation);

        MatcherAssert.assertThat(mathOperation).usingRecursiveComparison().isEqualTo(actualMathOperator);
    }
    @Test
    public void givenTwoNumbers_whenSubstracted_ReturnsDifference() throws InvalidOperationException {
        double result = mathOperator.doMath(5.0, 3.0, "-");
        assertEquals(expectedSubtractionResult, result, 0.001);
    }

    @Test
    public void givenTwoNumbers_whenMultiplied_ReturnsProduct() throws InvalidOperationException {
        double result = mathOperator.doMath(5.0, 3.0, "*");
        assertEquals(expectedMultiplicationResult, result, 0.001);
    }
    @Test
    public void givenTwoNumbers_whenDivided_ReturnsQuotient() throws InvalidOperationException {
        double result = mathOperator.doMath(5.0, 3.0, "/");
        assertEquals(expectedDivisionResult, result, 0.001);
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
