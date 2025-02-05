import java.util.ArrayList;
import java.util.LinkedHashMap;
public class TokenWriter {
    public static void writeTokensToScreen(LinkedHashMap<String,ArrayList<String>> tokens) {
        ArrayList<String> theList;
        for (String key: tokens.keySet()) {
            System.out.println("These are tokens of category " + key + ":");
            theList = tokens.get(key);
            for (String entry: theList) {
                System.out.println(entry);
            }
            System.out.println();
        }
    }
}
