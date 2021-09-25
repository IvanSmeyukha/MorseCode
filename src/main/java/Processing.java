
import java.io.*;
import java.util.Map;
import java.util.TreeMap;

public class Processing {

    public static void code(String textForCoding){
        MorseCode morseCode = new MorseCode();
        StringBuilder result = new StringBuilder();
        textForCoding = textForCoding.toUpperCase().replaceAll(" ", "");
        statistic(textForCoding.trim());
        for(int i = 0; i < textForCoding.length(); i++){
            result.append(morseCode.getMorseCode().get(textForCoding.charAt(i)) + ' ');
        }
        fileWriting(result.toString().trim(), "D:/Result.txt");
        System.out.println("Текст успешно зашифрован. Результат хранится в файле D:/Result.txt.");
    }

    public static void decode(String textForDecoding){
        MorseCode morseCode = new MorseCode();
        StringBuilder result = new StringBuilder();
        String[] text = textForDecoding.split(" ");
        for(String code : text){
            for(Map.Entry<Character, String> symbol : morseCode.getMorseCode().entrySet()){
                if(symbol.getValue().equals(code)){
                    result.append(symbol.getKey());
                    break;
                }
            }
        }
        statistic(result.toString().trim());
        fileWriting(result.toString().trim(), "D:/Result.txt");
        System.out.println("Текст успешно расшифрован. Результат хранится в файле D:/Result.txt.");
    }

    private static void statistic(String text){
        TreeMap<Character, Integer> stat = new TreeMap<Character, Integer>();
        for(int i = 65; i <= 90; i++){
            stat.put((char)i, 0);
        }
        for(int i = 0; i < text.length(); i++){
            stat.replace(text.charAt(i), stat.get(text.charAt(i)) + 1);
        }
        fileWriting(stat.toString(), "D:/Statistic.txt");
    }

    private static void fileWriting(String textForWriting, String fileName){
        BufferedWriter bufferedWriter = null;
        FileWriter fileWriter = null;
        File file = new File(fileName);
        try {
            fileWriter = new FileWriter(file);
            bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(textForWriting);
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                bufferedWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
