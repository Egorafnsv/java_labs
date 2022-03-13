package lab5;

import java.util.*;
import java.util.stream.Collectors;

public class StreamApi {

    public static double avgValueList(ArrayList<Integer> array){
        return array.stream()
                .mapToInt(n -> n)
                .average()
                .orElse(Double.NaN);
    }

    public static ArrayList<String> toUpperCaseList(ArrayList<String> array){
       return array.stream()
               .map(String::toUpperCase)
               .map(n -> n = "_new_" + n)
               .collect(Collectors.toCollection(ArrayList::new));
    }

        public static int[] squareNumbers(int[] array) {
            return Arrays.stream(array)
                    .filter(n -> Arrays.stream(array).filter(m -> m == n).count() < 2)
                    .map(n -> n * n)
                    .toArray();
        }

    public static double[] squareNumbers(double[] array) {
        return Arrays.stream(array)
                .filter(n -> Arrays.stream(array).filter(m -> m == n).count() < 2)
                .map(n -> n * n)
                .toArray();
    }

    public static ArrayList<String> filterAndSortedStringList (ArrayList<String> array, char x){
        return array.stream()
                .filter(n -> !n.equals(""))
                .filter(n -> n.toLowerCase().charAt(0) == x)
                .sorted()
                .collect(Collectors.toCollection(ArrayList::new));

    }

    public static Object getLastElement (ArrayList<?> array) throws NoSuchElementException {
        return array.stream()
                .reduce((x,y) -> y)
                .orElseThrow();
    }

    public static Integer sumEvenIntegers(ArrayList<Integer> array){
        return array.stream()
                .filter(n -> n % 2 == 0)
                .reduce(Integer::sum)
                .orElse(0);
    }

    public static Map<String, String> stringToMap (ArrayList<String> array){
        return array.stream()
                .filter(n -> !n.equals(""))
                .filter(n -> array.stream()
                        .filter(m -> !m.equals(""))
                        .takeWhile(m -> !m.equals(n))
                        .noneMatch(m -> n.charAt(0) == m.charAt(0)))
                .collect(Collectors.toMap(n -> n.substring(0, 1), n -> n.substring(1)));
    }
}
