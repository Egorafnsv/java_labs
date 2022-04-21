public class Main {
    public static void main(String[] args) {
        String pathIn = ".\\src\\vim1.txt";
        TextAnalyzer textTolstoy = new TextAnalyzer(pathIn);
        textTolstoy.AnalyzeText(4, 20);
    }
}


