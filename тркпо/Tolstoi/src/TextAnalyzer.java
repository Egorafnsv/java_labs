import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class TextAnalyzer {
    private final ArrayList<String> text = new ArrayList<>();
    private Map<String, Integer> sortedStat;

    public TextAnalyzer(String path) {
        try(FileInputStream in = new FileInputStream(path)){
            Scanner scan = new Scanner(in);
            while (scan.hasNext()){
                text.add(scan.next());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void AnalyzeText (int min, int max){
        HashMap<String, Integer> stat = new HashMap<>();

        text.stream()
                .map(this::deletePunctuation)
                .filter(word -> word.length() > 0 && word.length() >= min && word.length() <= max)
                .map(String::toLowerCase)
                .filter(this::filterAdjective)
                .forEach(word -> {if (stat.containsKey(word)){
                    stat.put(word, stat.get(word) + 1);
        } else {
                    stat.put(word, 1);
                }
                });


        sortedStat = stat.entrySet()
                .stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .collect(Collectors
                        .toMap(Map.Entry::getKey,
                                Map.Entry::getValue,
                                (x, y) -> x,
                                LinkedHashMap::new));

        System.out.println("Слово" + " ".repeat(10) + "Количество");
        System.out.println("-".repeat(25));
        sortedStat.entrySet().stream().limit(15)
                .forEach(line -> System.out.println(line.getKey() + " " + ".".repeat(16-line.getKey().length())+ " " + line.getValue()));

    }

    private String deletePunctuation(String str){
        Pattern pattern = Pattern.compile("[\\[\\]:;*!—\\-?.,\"()]");
        Matcher matcher = pattern.matcher(str);
        return matcher.replaceAll("");
    }

    int maxLenWords(){
        return sortedStat.keySet()
                .stream()
                .mapToInt(String::length)
                .max()
                .orElse(-1);

    }

    int minLenWords(){
        return sortedStat.keySet()
                .stream()
                .mapToInt(String::length)
                .min()
                .orElse(-1);
    }
    private Boolean filterAdjective(String str){
//        Pattern pattern = Pattern.compile("((.+?[ыо]й)|(.+?[оиы]е)|(.+?ого)|(.+?[иы]х)|(.+?ая)|(.+?ую)|(.+?[ыио]м[уи]?))\\z");
        Pattern pattern = Pattern.compile("((.+?ый)|(.+?ая)|(.+?ое))\\z");
        Matcher matcher = pattern.matcher(str);
        return matcher.lookingAt();
    }
}
