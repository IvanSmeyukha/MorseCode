import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String commandForCoding = "code";
        String commandForDecoding = "decode";
        String fileForResult = "D:/Result.txt";
        Scanner scanner = new Scanner(System.in);
        String textFromFile;
        System.out.println("Введите команду(code или decode). В качестве аргумента команде указано имя исходного текстового файла.");
        String[] task = scanner.nextLine().split(" ");
        if(task[0].equals(commandForCoding)) {
            textFromFile = Utils.readFile(task[1]);
            Coder.code(textFromFile, fileForResult);
        }
        else if(task[0].equals(commandForDecoding)) {
            textFromFile = Utils.readFile(task[1]);
            Coder.decode(textFromFile, fileForResult);
        }
    }
}
