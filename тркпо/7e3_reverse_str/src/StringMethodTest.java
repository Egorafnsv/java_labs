import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringMethodTest {

    @Test
    void reverseStringTest1() {
        assertEquals("level noon deed", StringMethod.reverseString("deed noon level"));
    }

    @Test
    void reverseStringTest2() {
        assertEquals("12345", StringMethod.reverseString("54321"));
    }
    @Test
    void reverseStringTest3() {
        assertEquals(" ", StringMethod.reverseString(" "));
    }
}