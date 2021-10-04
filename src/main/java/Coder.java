import java.util.HashMap;
import java.util.Map;

public class Coder {

    public static void code(String textForCoding, String fileName) {
        HashMap<Character, String> morseCode = MorseCode.getMorseCode();
        StringBuilder result = new StringBuilder();
        StatisticCounter statistic = new StatisticCounter();
        char symbol;
        textForCoding = textForCoding.toUpperCase();
        statistic.Count(textForCoding);
        for (int i = 0; i < textForCoding.length(); i++) {
            symbol = textForCoding.charAt(i);
            if (symbol == '\n' || symbol == '\r')
                result.append(symbol);
            else if (symbol == ' ')
                result.append("  ");
            else {
                result.append(morseCode.get(symbol));
                result.append(" ");
            }
        }
        Utils.writeToFile(result.toString(), fileName);
        System.out.println("Текст успешно зашифрован. Результат хранится в файле " + fileName);
    }

    public static void decode(String textForDecoding, String fileName) {
        StatisticCounter statistic = new StatisticCounter();
        HashMap<Character, String> morseCode = MorseCode.getMorseCode();
        StringBuilder result = new StringBuilder();
        String[] text = textForDecoding.replaceAll("   ", " * ").replaceAll("\n", " n ").replaceAll("\r", " r ").split(" ");
        for (String symbol : text) {
            for (Map.Entry entry : morseCode.entrySet()) {
                if (symbol.equals("*")) {
                    result.append(" ");
                    break;
                } else if (symbol.equals("r")) {
                    result.append("\r");
                    break;
                } else if (symbol.equals("n")) {
                    result.append("\n");
                    break;
                } else if (entry.getValue().equals(symbol)) {
                    result.append(entry.getKey());
                    break;
                }
            }
        }
        statistic.Count(result.toString());
        Utils.writeToFile(result.toString(), fileName);
        System.out.println("Текст успешно расшифрован. Результат хранится в файле " + fileName);
    }
}