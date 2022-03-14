package lab_big_int;

import java.util.ArrayList;

public class AvgLongClass {
    public static Long averageLong(ArrayList<Long> numbers){
        return numbers.stream().map(x -> x/numbers.size()).reduce(Long::sum).orElse(null);
    }
}
