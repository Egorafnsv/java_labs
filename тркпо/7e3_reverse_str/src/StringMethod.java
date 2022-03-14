import java.util.Arrays;

public class StringMethod {
    public static String reverseString (String original){
        String[] arrayString = original.split("");

        return Arrays.stream(arrayString)
                .reduce((x, y) -> y + x)
                .orElse(null);
    }

//    public static String reverseString (String original){
//        String[] arrayString = original.split("");
//        StringBuilder result = new StringBuilder();
//        for(int i = original.length()-1; i >= 0; i--){
//            result.append(arrayString[i]);
//        }
//        return result.toString();
//    }
}
