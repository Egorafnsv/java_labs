import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringMethod {
    public static String reverseString (String original){
        String[] arrayString = original.split("");

        return Arrays.stream(arrayString)
                .reduce((x, y) -> y + x)
                .orElse(null);
    }

    public static boolean isPalindrome(String input){
        input = input.toLowerCase();

        Pattern pattern = Pattern.compile("[^а-яa-z0-9]");
        Matcher matcher = pattern.matcher(input);
        input = matcher.replaceAll("");

        String reverse = reverseString(input);
        return reverse.equals(input);
    }
}
