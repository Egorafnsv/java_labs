import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TextAnalyzerTest {

    @Test
    void maxLenWords() {
        int max = 10;

        String pathIn = ".\\src\\text.txt";
        TextAnalyzer text = new TextAnalyzer(pathIn);
        text.AnalyzeText(Integer.MIN_VALUE, max);
        assertTrue(text.maxLenWords() <= max);
    }

    @Test
    void minLenWords() {
        int min = 3;

        String pathIn = ".\\src\\text.txt";
        TextAnalyzer text = new TextAnalyzer(pathIn);
        text.AnalyzeText(min, Integer.MAX_VALUE);
        assertTrue(text.minLenWords() <= min);
    }
}