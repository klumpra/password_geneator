import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Scanner;
import java.io.File;
/**
 * Reads a tab delimited list of words and their types
 */
public class TokenReader {
    public static LinkedHashMap<String,ArrayList<String>> readTokensFromFile(String fileName) {
        try {
            LinkedHashMap<String,ArrayList<String>> result = new LinkedHashMap<String,ArrayList<String>>();
            Scanner fsc = new Scanner(new File(fileName));
            String line;
            String word, category;
            String[] parts;
            while (fsc.hasNextLine()) {
                line = fsc.nextLine().trim();
                if (line.isEmpty()) {
                    continue;
                }
                parts = line.split("\t");
                word = parts[0];
                category = parts[1];
                if (!result.containsKey(category)) {
                    result.put(category,new ArrayList<String>());
                }
                result.get(category).add(word);
            }
            fsc.close();
            return result;
        } catch (Exception ex) {
            return null;
        }
    }
}
