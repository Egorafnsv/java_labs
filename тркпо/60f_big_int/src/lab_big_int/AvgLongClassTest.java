package lab_big_int;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class AvgLongClassTest {

    @Test
    void averageLongTest1() {
        ArrayList<Long> numbers = Stream.of(9_000_000_000_000_000_000L, 9_000_000_000_000_000_000L, 9_000_000_000_000_000_000L,
                        9_000_000_000_000_000_000L, 9_000_000_000_000_000_000L, 9_000_000_000_000_000_000L)
                .collect(Collectors.toCollection(ArrayList::new));
        assertEquals(9_000_000_000_000_000_000L, AvgLongClass.averageLong(numbers));
    }

    @Test
    void averageLongTest2() {
        ArrayList<Long> numbers = Stream.of(9_000_000_000_000_000_000L, 8_000_000_000_000_000_000L)
                .collect(Collectors.toCollection(ArrayList::new));
        assertEquals(8_500_000_000_000_000_000L, AvgLongClass.averageLong(numbers));
    }

    @Test
    void averageLongTest3() {
        ArrayList<Long> numbers = Stream.of(9_000_000_000_000_000_000L, 8_444_444_444_444_444_444L)
                .collect(Collectors.toCollection(ArrayList::new));
        assertEquals(9_000_000_000_000_000_000L/2 + 8_444_444_444_444_444_444L/2, AvgLongClass.averageLong(numbers));
    }

    @Test
    void averageLongTest4() {
        ArrayList<Long> numbers = Stream.of(Long.MAX_VALUE, Long.MIN_VALUE)
                .collect(Collectors.toCollection(ArrayList::new));
        assertEquals(Long.MAX_VALUE/2 + Long.MIN_VALUE/2, AvgLongClass.averageLong(numbers));
    }
}