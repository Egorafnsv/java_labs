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
        assertEquals("тсет", StringMethod.reverseString("тест"));
    }
    @Test
    void isPalindromeTest1() {
        assertTrue(StringMethod.isPalindrome("Я — арка края"));
    }
    @Test
    void isPalindromeTest2() {
        assertFalse(StringMethod.isPalindrome("it's not a palindrome"));
    }
    @Test
    void isPalindromeTest3() {
        assertTrue(StringMethod.isPalindrome("Madam, I’m Adam"));
    }
}