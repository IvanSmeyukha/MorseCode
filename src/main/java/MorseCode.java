import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MorseCode {
    static String fileToRead = "morseCode.csv";

    public static Map<Character, String> getMorseCode() {
        Map<Character, String> morseCode = new HashMap<>();
        InputStream inStream = MorseCode.class.getResourceAsStream(fileToRead);
        if (inStream == null) {
            System.err.println("Cannot open an alphabet file with name " + fileToRead);
            return null;
        }
        Scanner scanner = new Scanner(new BufferedInputStream(inStream));
        String[] line;
        while(scanner.hasNextLine()){
            line = scanner.nextLine().split(" ");
            morseCode.put(line[0].charAt(0), line[1]);
        }
        return morseCode;
    }
}