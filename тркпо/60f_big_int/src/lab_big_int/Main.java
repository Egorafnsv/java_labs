//Найдите среднее арифметическое чисел 9_000_000_000_000_000_000 8_444_444_444_444_444_444

package lab_big_int;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        long x = 9_000_000_000_000_000_000L;
        long y = 8_444_444_444_444_444_444L;

        ArrayList<Long> numbers = Stream.of(x, y)
                .collect(Collectors.toCollection(ArrayList::new));

        System.out.println(AvgLongClass.averageLong(numbers));
    }
}
