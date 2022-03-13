package lab2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class CalcStatistics {
    private final LinkedHashMap<String, List<Integer>> arrayWords = new LinkedHashMap<>();

    void startCalculate() {
        Scanner userInput = new Scanner(System.in);
        String inputPath;
        String outputPath;
        File inputFile;
        File outputFile;

        System.out.println("Входной файл: ");
        inputPath = ".\\resources\\input\\" + userInput.nextLine();
        inputFile = new File(inputPath);

        try(Scanner fileStream = new Scanner(inputFile)){
            readLines(fileStream);
        }
        catch (FileNotFoundException e){
            System.out.println(e.getMessage());
            System.exit(1);
        }

        System.out.println("Выходной файл: ");

        while(true) {
            outputPath = ".\\resources\\output\\" + userInput.nextLine();
            outputFile = new File(outputPath);

            if (outputFile.exists()){
                System.out.println("Такой файл уже существует!");}
            else{
                break;}
        }

        try(FileWriter outputFileWriter = new FileWriter(outputFile, false)){
            writeStatistics(outputFileWriter);
        }
        catch (IOException e){
            System.out.println(e.getMessage());
            System.exit(1);
        }
    }

    private void writeStatistics(FileWriter outputFileWriter) throws IOException {
        Set<String> keys = arrayWords.keySet();
        List<Integer> wordStat;

        if (keys.size() > 0){
            outputFileWriter.write("Слово | Количество повторений | Номер строки:Номер слова в строке\n");
            for (String key : keys){
                wordStat = arrayWords.get(key);
                outputFileWriter.write(key + " | " + wordStat.get(0) + " | ");

                for (int i = 1; i < wordStat.size(); i += 2)
                    outputFileWriter.write(wordStat.get(i) + ":" + wordStat.get(i + 1) + " ");

                outputFileWriter.append("\n");
            }
        }
        else {
            outputFileWriter.write("¯\\_(ツ)_/¯");
        }
    }

    private void readLines(Scanner fileStream) {
        String string;
        int indexString = 0;

        while(fileStream.hasNext()){
            indexString++;
            string = fileStream.nextLine();
            analyzeLine(string, indexString);
        }
    }

    private void analyzeLine(String string, int indexString){
        String word;
        int indexWord = 0;
        List<Integer> wordStat;

        Scanner scanLine = new Scanner(string);

        while(scanLine.hasNext()){
            indexWord++;
            word = scanLine.next().toLowerCase();
            wordStat = arrayWords.get(word);

            if(wordStat != null){
                wordStat.set(0, wordStat.get(0) + 1);
                wordStat.add(indexString);
                wordStat.add(indexWord);
            }
            else{
                wordStat = new ArrayList<>();  // [количество слов, позиция строки, позиция слова]
                wordStat.add(1);
                wordStat.add(indexString);
                wordStat.add(indexWord);
            }

            arrayWords.put(word, wordStat);
        }
    }
}
