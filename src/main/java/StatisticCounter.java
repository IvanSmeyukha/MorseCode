import java.util.HashMap;
import java.util.Map;

public class StatisticCounter {
    private final HashMap<Character, Integer> stat = new HashMap<>();
    private final String statFile = "D:/Statistic.txt";

    public void Count(String text){
        for(char i = 'A'; i <= 'Z'; i++){
            stat.put(i, 0);
        }
        for(int i = 0; i < text.length(); i++){
            if(text.charAt(i) >= 'A' && text.charAt(i) <= 'Z')
                stat.replace(text.charAt(i), stat.get(text.charAt(i)) + 1);
        }
        Utils.writeToFile(toString(), statFile);
    }

    @Override
    public String toString(){
        StringBuilder str = new StringBuilder();
        for(Map.Entry entry : stat.entrySet())
            str.append("'").append(entry.getKey()).append("'").append(" = ").append(entry.getValue()).append('\n');
        return str.toString();
    }
}
