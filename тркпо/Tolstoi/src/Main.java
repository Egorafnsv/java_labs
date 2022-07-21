//"Подсчет частоты появления слов во входном потоке. Дать возможность указывать минимальную/максимальную длину слова, участвующую в подсчёте частоты, для фильтрации предлогов и местоимений. Использовать Java8 Stream API. Файл для анализа https://drive.google.com/open?id=1YnRy5H8Emx4kyA1-lLZkNuY8LDTplulu
//        * Выяснить самые популярные прилагательные в тексте."

public class Main {
    public static void main(String[] args) {
        String pathIn = ".\\src\\vim1.txt";
        TextAnalyzer textTolstoy = new TextAnalyzer(pathIn);
        textTolstoy.AnalyzeText(4, 20);
    }
}


