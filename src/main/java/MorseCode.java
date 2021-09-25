
import java.io.*;
import java.util.TreeMap;

public class MorseCode {
    private TreeMap<Character, String> morseCode = new TreeMap<>();

    public MorseCode() {
        readMorseCode();
    }

    private void readMorseCode() {
        BufferedReader bufferedReader = null;
        FileReader fileReader;
        File file = new File("D:/MorseCode.txt");
        String line;
        try {
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
            while ((line = bufferedReader.readLine()) != null) {
                String code;
                if(line.indexOf('.') == -1)
                    code = line.substring(line.indexOf('-'));
                else if(line.indexOf('-') == -1)
                    code = line.substring(line.indexOf('.'));
                else if(line.indexOf('.') < line.indexOf('-'))
                    code = line.substring(line.indexOf('.'));
                else
                    code = line.substring(line.indexOf('-'));
                morseCode.put(line.charAt(0), code);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public TreeMap<Character, String> getMorseCode(){
        return morseCode;
    }
}