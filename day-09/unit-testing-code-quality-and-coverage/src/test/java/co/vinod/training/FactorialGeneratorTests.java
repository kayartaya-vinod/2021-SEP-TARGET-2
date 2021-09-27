package co.vinod.training;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

// import all static members from Assertions class
import static org.junit.jupiter.api.Assertions.*;

class FactorialGeneratorTests {
    FactorialGenerator fg;

    @BeforeEach
    void setup() {
        fg = new FactorialGenerator();
    }

    @Test
    void shouldGetFactorialOfPositiveNumber() throws FactorialException {
        Long actual = fg.factorial(5);
        Long expected = 120L;
        assertEquals(expected, actual);
    }

    @Test
    void shouldThrowExceptionForNegativeInput() {
        assertThrows(FactorialException.class, () -> fg.factorial(-5));
    }

    @Test
    void shouldGetNullForFactorialOfNull() throws FactorialException {
        assertNull(fg.factorial(null));
    }

    @Test
    void shouldGetFactorialOfNumberInStringFormat() throws FactorialException {

        assertDoesNotThrow(() -> {
            Long actual = fg.factorial("5");
            Long expected = 120L;
            assertEquals(expected, actual);
        });
    }

    @Test
    void shouldThrowErrorForNonNumericString() {
        assertThrows(NumberFormatException.class, () -> fg.factorial("asdf"));
    }

}
