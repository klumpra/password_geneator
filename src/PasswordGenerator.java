import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Random;
public class PasswordGenerator {
    private LinkedHashMap<String,ArrayList<String>> tokens;
    private Random rnd;
    private int symbolChance;
    private int numberChance;
    public int getSymbolChance() {
        return symbolChance;
    }
    public int getNumberChance() {
        return numberChance;
    }
    public void setSymbolChance(int sc) {
        if (sc > 10) {
            symbolChance = 10;
        } else if (sc < 0) {
            symbolChance = 0;
        } else {
            symbolChance = sc;
        }
    }
    public void setNumberChance(int nc) {
        if (nc > 10) {
            numberChance = 10;
        } else if (nc < 0) {
            numberChance = 0;
        } else {
            numberChance = nc;
        }        
    }
    public PasswordGenerator() {
        this(null,0,0);
    }
    public PasswordGenerator(LinkedHashMap<String,ArrayList<String>> tokens) {
        this(tokens,5,5);
    }
    public PasswordGenerator(LinkedHashMap<String,ArrayList<String>> tokens, int symbolChance, int numberChance) {
        this.tokens = tokens;
        setSymbolChance(symbolChance);
        setNumberChance(numberChance);
        rnd = new Random();
    }
    public String chooseToken(String category) {
        ArrayList<String> theList;
        if (tokens.containsKey(category)) {
            theList = tokens.get(category);
            return theList.get(rnd.nextInt(theList.size()));
        } else {
            return "";
        }
    }
    public ArrayList<String> generatePasswords(int count) {
        ArrayList<String> result = new ArrayList<String>();
        String password;
        int decider;
        for (int i = 0; i < count; i++) {
            password = chooseToken("col");
            decider = rnd.nextInt(10);
            if (decider < symbolChance) {
                password = password + chooseToken("sym");
            }
            password = password + chooseToken("shp") + chooseToken("bbt");
            decider = rnd.nextInt(10);
            if (decider < numberChance) {
                password = password + chooseToken("num");
            }
            result.add(password);
        }
        return result;
    }
}
