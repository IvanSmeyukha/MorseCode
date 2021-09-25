
import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String task;
        String textFromFile;
        System.out.println("Введите команду(code или decode). В качестве аргумента команде указано имя исходного текстового файла.");
        task = scanner.nextLine();
        if(task.lastIndexOf("decode") != -1) {
            textFromFile = fileReader(task.trim().substring(task.lastIndexOf("decode") + 7));
            Processing.decode(textFromFile);
        }
        else if(task.lastIndexOf("code") != -1){
            textFromFile = fileReader(task.trim().substring(task.lastIndexOf("code") + 5));
            Processing.code(textFromFile);
        }
    }

    private static String fileReader(String fileToOpen){
        StringBuilder textFromFile = new StringBuilder();
        String line;
        BufferedReader bufferedReader = null;
        FileReader fileReader;
        File file = new File(fileToOpen);
        try {
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
            while((line = bufferedReader.readLine()) != null){
                textFromFile.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if(null != bufferedReader){
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return textFromFile.toString();
    }
}
