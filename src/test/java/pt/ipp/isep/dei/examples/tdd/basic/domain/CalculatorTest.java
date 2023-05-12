package pt.ipp.isep.dei.examples.tdd.basic.domain;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class CalculatorTest {

    @BeforeAll
    public static void classSetUp() {
        //HACK: for demonstration purposes only
        System.out.println(
                "This is a CalculatorTest class method and takes place before any @Test is executed");
    }

    @AfterAll
    public static void classTearDown() {
        //HACK: for demonstration purposes only
        System.out.println(
                "This is a CalculatorTest class method and takes place after all @Test are executed");
    }

    @BeforeEach
    public void setUp() {
        //HACK: for demonstration purposes only
        System.out.println(
                "\tThis call takes place before each @Test is executed");
    }

    @AfterEach
    public void tearDown() {
        //HACK: for demonstration purposes only
        System.out.println(
                "\tThis call takes place after each @Test is executed");
    }

    @Test
    @Disabled
    public void failingTest() {
        fail("a disabled failing test");
    }

    /**
     * Test to ensure two positive numbers are summed correctly.<p>
     * <p>
     * For demonstration purposes the Arrange/Act/Assert syntax is used:<p>
     * Arrange: one positive number (three) and another positive number (two).<p>
     * Act: sum both numbers (three and two).<p>
     * Assert: the result is five.
     */
    @Test
    public void ensureThreePlusTwoEqualsFive() {

        //HACK: for demonstration purposes only
        System.out.println("\t\tExecuting " + new Object() {
        }.getClass().getEnclosingMethod().getName() + " Test");

        // Arrange
        int expectedResult = 5;
        int firsOperand = 3;
        int secondOperand = 2;
        int result = 3;

        // Act
        result = new Calculator().sum(firsOperand, secondOperand);

        // Assert
        assertEquals(expectedResult, result);
    }



    /**
     * Test to ensure positive and negative numbers are summed correctly.<p>
     * <p>
     * For demonstration purposes the Arrange/Act/Assert syntax is used:<p>
     * Arranje a positive number (three) and a negative number (minus two)<p>
     * Act I sum three to minus two<p>
     * Assert the sum result should be one.
     */
    @Test
    public void ensureThreePlusMinusTwoEqualsOne() {
        //HACK: for demonstration purposes only
        System.out.println("\t\tExecuting " + new Object() {
        }.getClass().getEnclosingMethod().getName() + " Test");

        // Arrange
        int firsOperand = 3;
        int secondOperand = -2;
        int expectedResult = 1;
        int result = 3;

        // Act
        result = new Calculator().sum(firsOperand, secondOperand);

        // Assert
        assertEquals(expectedResult, result);
    }

    @Test
    public void ensureSubPositiveNumbers() {
        //HACK: for demonstration purposes only
        System.out.println("\t\tExecuting " + new Object() {
        }.getClass().getEnclosingMethod().getName() + " Test");

        // Arrange
        int firsOperand = 10;
        int secondOperand = 5;
        int expectedResult = 5;

        // Act
        int result = new Calculator().subtract(firsOperand, secondOperand);

        // Assert
        assertEquals(expectedResult, result);
    }
    @Test
    public void ensureSubMixedNumbers() {
        //HACK: for demonstration purposes only
        System.out.println("\t\tExecuting " + new Object() {
        }.getClass().getEnclosingMethod().getName() + " Test");

        // Arrange
        int firsOperand = 10;
        int secondOperand = -5;
        int expectedResult = -5;

        // Act
        int result = new Calculator().subtract(firsOperand, secondOperand);

        // Assert
        assertEquals(expectedResult, result);
    }
    public void ensureSubNegativNumbers() {
        //HACK: for demonstration purposes only
        System.out.println("\t\tExecuting " + new Object() {
        }.getClass().getEnclosingMethod().getName() + " Test");

        // Arrange
        int firsOperand = -5;
        int secondOperand = -5;
        int expectedResult = 0;

        // Act
        int result = new Calculator().subtract(firsOperand, secondOperand);

        // Assert
        assertEquals(expectedResult, result);
    }
    public void ensureSubZero() {
        //HACK: for demonstration purposes only
        System.out.println("\t\tExecuting " + new Object() {
        }.getClass().getEnclosingMethod().getName() + " Test");

        // Arrange
        int firsOperand = 5;
        int secondOperand = 0;
        int expectedResult = 5;

        // Act
        int result = new Calculator().subtract(firsOperand, secondOperand);

        // Assert
        assertEquals(expectedResult, result);
    }

    /**
     * Test to ensure positive and negative numbers are summed correctly.<p>
     * <p>
     * For demonstration purposes the Arrange/Act/Assert syntax is used:<p>
     * Arranje a positive number (three) and a negative number (minus two)<p>
     * Act I sum three to minus two<p>
     * Assert the sum result should be one.
     */
    @Test
    public void ensureFivePlusFiveEquals10() {
        //HACK: for demonstration purposes only
        System.out.println("\t\tExecuting " + new Object() {
        }.getClass().getEnclosingMethod().getName() + " Test");
        // Arrange
        int firsOperand = 5;
        int secondOperand = 5;
        int expectedResult = 10;
        int result = 10;
        // Act
        result = new Calculator().sum(firsOperand, secondOperand);
        // Assert
        assertEquals(expectedResult, result);
    }

    @Test
    public void ensureFivePlusNegativeFiveEqualsZero() {
        //HACK: for demonstration purposes only
        System.out.println("\t\tExecuting " + new Object() {
        }.getClass().getEnclosingMethod().getName() + " Test");
        // Arrange
        int firsOperand = 5;
        int secondOperand = -5;
        int expectedResult = 0;
        int result = 0;
        // Act
        result = new Calculator().sum(firsOperand, secondOperand);
        // Assert
        assertEquals(expectedResult, result);
    }
    @Test
    public void ensureFivePlusNegativeTenEqualsNegative5() {
        //HACK: for demonstration purposes only
        System.out.println("\t\tExecuting " + new Object() {
        }.getClass().getEnclosingMethod().getName() + " Test");
        // Arrange
        int firsOperand = 5;
        int secondOperand = -10;
        int expectedResult = -5;
        int result = -5;
        // Act
        result = new Calculator().sum(firsOperand, secondOperand);
        // Assert
        assertEquals(expectedResult, result);
    }

    @Test
    public void ensureNegativeTwoPlusNegativeTwoEqualsNegativeFour() {
        //HACK: for demonstration purposes only
        System.out.println("\t\tExecuting " + new Object() {
        }.getClass().getEnclosingMethod().getName() + " Test");
        // Arrange
        int firsOperand = -2;
        int secondOperand = -2;
        int expectedResult = -4;
        int result = -4;
        // Act
        result = new Calculator().sum(firsOperand, secondOperand);
        // Assert
        assertEquals(expectedResult, result);
    }

    @Test
    public void ensureOverflowIsCoughByException() {
        //HACK: for demonstration purposes only
        System.out.println("\t\tExecuting " + new Object() {
        }.getClass().getEnclosingMethod().getName() + " Test");
        // Arrange


            int firsOperand = 999999999;
            int secondOperand = 999999999;

            // Act
            int result = new Calculator().sum(firsOperand, secondOperand);
        Assertions.assertThrows(ArithmeticException.class,
                ()->{
                    //do whatever you want to do here
                    new Calculator().sum(firsOperand, secondOperand);
                });


}

    @Test
    public void ensureDivisionByZeroThrowsException() {
        //HACK: for demonstration purposes only
        System.out.println("\t\tExecuting " + new Object() {
        }.getClass().getEnclosingMethod().getName() + " Test");
        // Arrange


        int firsOperand = 2;
        int secondOperand = 0;
        // Act
        int result = new Calculator().sum(firsOperand, secondOperand);
        Assertions.assertThrows(ArithmeticException.class,
                ()->{
                    //do whatever you want to do here
                    new Calculator().divide(firsOperand, secondOperand);
                });
    }


    @Test
    public void ensureDivisionByZero() {
        //HACK: for demonstration purposes only
        System.out.println("\t\tExecuting " + new Object() {
        }.getClass().getEnclosingMethod().getName() + " Test");
        // Arrange


        int firsOperand = 5;
        int secondOperand = 1;
        int expectedResult = 5;
        // Act
        int result = new Calculator().divide(firsOperand, secondOperand);

        assertEquals(expectedResult, result);

    }

    @Test
    public void ensureOverflowIsCoughByExceptionMin() {
        //HACK: for demonstration purposes only
        System.out.println("\t\tExecuting " + new Object() {
        }.getClass().getEnclosingMethod().getName() + " Test");
        // Arrange

        int firsOperand = -999999999;
        int secondOperand = -999999999;

        // Act
        Assertions.assertThrows(ArithmeticException.class,
                ()->{
                    //do whatever you want to do here
                   new Calculator().sum(firsOperand, secondOperand);
                });
    }


}

