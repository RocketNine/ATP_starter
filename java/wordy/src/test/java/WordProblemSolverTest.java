import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class WordProblemSolverTest {

    WordProblemSolver solver = new WordProblemSolver();

    @Test
    void testJustANumber() {
        assertEquals(5, solver.solve("What is 5?"));
    }

    @Disabled("Remove to run test")
    @Test
    void testSingleAddition1() {
        assertEquals(2, solver.solve("What is 1 plus 1?"));
    }

    @Disabled("Remove to run test")
    @Test
    void testSingleAddition2() {
        assertEquals(55, solver.solve("What is 53 plus 2?"));
    }

    @Disabled("Remove to run test")
    @Test
    void testSingleAdditionWithNegativeNumbers() {
        assertEquals(-11, solver.solve("What is -1 plus -10?"));
    }

    @Disabled("Remove to run test")
    @Test
    void testSingleAdditionOfLargeNumbers() {
        assertEquals(45801, solver.solve("What is 123 plus 45678?"));
    }

    @Disabled("Remove to run test")
    @Test
    void testSingleSubtraction() {
        assertEquals(16, solver.solve("What is 4 minus -12?"));
    }

    @Disabled("Remove to run test")
    @Test
    void testSingleMultiplication() {
        assertEquals(-75, solver.solve("What is -3 multiplied by 25?"));
    }

    @Disabled("Remove to run test")
    @Test
    void testSingleDivision() {
        assertEquals(-11, solver.solve("What is 33 divided by -3?"));
    }

    @Disabled("Remove to run test")
    @Test
    void testMultipleAdditions() {
        assertEquals(3, solver.solve("What is 1 plus 1 plus 1?"));
    }

    @Disabled("Remove to run test")
    @Test
    void testAdditionThenSubtraction() {
        assertEquals(8, solver.solve("What is 1 plus 5 minus -2?"));
    }

    @Disabled("Remove to run test")
    @Test
    void testMultipleSubtractions() {
        assertEquals(3, solver.solve("What is 20 minus 4 minus 13?"));
    }

    @Disabled("Remove to run test")
    @Test
    void testSubtractionThenAddition() {
        assertEquals(14, solver.solve("What is 17 minus 6 plus 3?"));
    }

    @Disabled("Remove to run test")
    @Test
    void testMultipleMultiplications() {
        assertEquals(-12, solver.solve("What is 2 multiplied by -2 multiplied by 3?"));
    }

    @Disabled("Remove to run test")
    @Test
    void testAdditionThenMultiplication() {
        assertEquals(-8, solver.solve("What is -3 plus 7 multiplied by -2?"));
    }

    @Disabled("Remove to run test")
    @Test
    void testMultipleDivisions() {
        assertEquals(2, solver.solve("What is -12 divided by 2 divided by -3?"));
    }

    @Disabled("Remove to run test")
    @Test
    void testUnknownOperation() {
        IllegalArgumentException expected =
            assertThrows(
                IllegalArgumentException.class,
                () -> solver.solve("What is 52 cubed?"));

        assertThat(expected)
            .hasMessage("I'm sorry, I don't understand the question!");
    }

    @Disabled("Remove to run test")
    @Test
    void testNonMathQuestion() {
        // See https://en.wikipedia.org/wiki/President_of_the_United_States if you really need to know!
        IllegalArgumentException expected =
            assertThrows(
                IllegalArgumentException.class,
                () -> solver.solve("Who is the President of the United States?"));

        assertThat(expected)
            .hasMessage("I'm sorry, I don't understand the question!");
    }

    @Disabled("Remove to run test")
    @Test
    void testMissingAnOperand() {
        IllegalArgumentException expected =
            assertThrows(
                IllegalArgumentException.class,
                () -> solver.solve("What is 1 plus?"));

        assertThat(expected)
            .hasMessage("I'm sorry, I don't understand the question!");
    }

    @Disabled("Remove to run test")
    @Test
    void testNoOperandsOrOperators() {
        IllegalArgumentException expected =
            assertThrows(
                IllegalArgumentException.class,
                () -> solver.solve("What is?"));

        assertThat(expected)
            .hasMessage("I'm sorry, I don't understand the question!");
    }

    @Disabled("Remove to run test")
    @Test
    void testTwoOperationsInARow() {
        IllegalArgumentException expected =
            assertThrows(
                IllegalArgumentException.class,
                () -> solver.solve("What is 1 plus plus 2?"));

        assertThat(expected)
            .hasMessage("I'm sorry, I don't understand the question!");
    }

    @Disabled("Remove to run test")
    @Test
    void testTwoNumbersAfterOperation() {
        IllegalArgumentException expected =
            assertThrows(
                IllegalArgumentException.class,
                () -> solver.solve("What is 1 plus 2 1?"));

        assertThat(expected)
            .hasMessage("I'm sorry, I don't understand the question!");
    }

    @Disabled("Remove to run test")
    @Test
    void testPostfixNotation() {
        IllegalArgumentException expected =
            assertThrows(
                IllegalArgumentException.class,
                () -> solver.solve("What is 1 2 plus?"));

        assertThat(expected)
            .hasMessage("I'm sorry, I don't understand the question!");
    }

    @Disabled("Remove to run test")
    @Test
    void testPrefixNotation() {
        IllegalArgumentException expected =
            assertThrows(
                IllegalArgumentException.class,
                () -> solver.solve("What is plus 1 2?"));

        assertThat(expected)
            .hasMessage("I'm sorry, I don't understand the question!");
    }
}
