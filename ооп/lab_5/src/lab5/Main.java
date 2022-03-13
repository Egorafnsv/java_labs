package lab5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> intList = Stream.generate(Math::random)
                .limit(5)
                .map(x -> (int) (x * 11 - 5))
                .collect(Collectors.toCollection(ArrayList::new));

        ArrayList<String> stringList = Stream.of("cat", "", "dog", "4", "DOGs", "HotDog", "dogGiE", "CatAssassin", "African Clawed Frog", "f")
                .collect(Collectors.toCollection(ArrayList::new));

        ArrayList<Integer> intOddList = Stream.of(1,3,5,7,9)
                .collect(Collectors.toCollection(ArrayList::new));

        int[] etoInt = new int[]{1, 3, 3, 2, 6, 11, 20, 25, 61, 20};
        double[] etoDouble = new double[]{1.1, 3.2, 3.2, 2.5, 6.1};

        System.out.println("Среднее целых чисел: ");
        System.out.println(intList + " -> " + StreamApi.avgValueList(intList));

        System.out.println("\nВерхний регистр с префиксом: ");
        System.out.println(stringList + " -> " + StreamApi.toUpperCaseList(stringList));

        System.out.println("\nКвадрат целых: ");
        System.out.println(Arrays.toString(etoInt) + " -> " +
                Arrays.toString(StreamApi.squareNumbers(etoInt)));

        System.out.println("\nКвадрат чисел с запятой: ");
        System.out.print(Arrays.toString(etoDouble) + " -> ");
        Arrays.stream(StreamApi.squareNumbers(etoDouble)).forEach(n -> System.out.printf("%.3f  ", n));

        System.out.println("\n\nФильтрация строк по 1-й букве: ");
        System.out.println(stringList + " -> " + StreamApi.filterAndSortedStringList(stringList, 'd'));

        System.out.println("\nПолучить последний элемент:");
        try{
            System.out.println(StreamApi.getLastElement(intList));
            System.out.println(StreamApi.getLastElement(stringList));
            System.out.println(StreamApi.getLastElement(new ArrayList<>()));
        }
        catch (NoSuchElementException e){
            System.out.println("Кинули исключение: " + e);
        }

        System.out.println("\nСумма четных чисел: ");
        System.out.println(intList + " -> " + StreamApi.sumEvenIntegers(intList));
        System.out.println(intOddList + " -> " + StreamApi.sumEvenIntegers(intOddList));

        System.out.println("\nПреобразование в словарь: ");
        System.out.println(stringList + "-> " + StreamApi.stringToMap(stringList));
    }
}
