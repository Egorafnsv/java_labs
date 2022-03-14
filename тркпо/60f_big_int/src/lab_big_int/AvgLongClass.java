package lab_big_int;

import java.util.ArrayList;

public class AvgLongClass {
    public static Double averageLong(ArrayList<Long> numbers){
        return numbers.stream()
                .map(Long::doubleValue)
                .map(x ->  x/numbers.size())
                .reduce(Double::sum)
                .orElse(null);
    }
}
