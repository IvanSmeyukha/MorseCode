import java.io.*;

public class Utils {

    public static void writeToFile(String textForWriting, String fileName){

        try {
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName)));
            writer.write(textForWriting);
            writer.flush();
        } catch (IOException e) {
            System.err.println("Reading file error: " + e.getMessage());
        }
    }

    public static String readFile(String fileForOpen){
        StringBuilder text = new StringBuilder();
        try {
            Reader rd = new InputStreamReader(new FileInputStream(fileForOpen));
            int symbol;
            while((symbol = rd.read()) != -1){
                text.append(Character.toString(symbol));
            }
        } catch (IOException e) {
            System.err.println("Reading file error: " + e.getMessage());
        }
        return text.toString();
    }
}
