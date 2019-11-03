import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

class RomanNumeral {

    private final int decimalNumber;
    private String romanNumeral;

    private static Map<Integer, StringBuilder> numerals = new LinkedHashMap<>();
    static {
        numerals.put(1000, new StringBuilder("M"));
        numerals.put(900, new StringBuilder("CM"));
        numerals.put(500, new StringBuilder("D"));
        numerals.put(100)
    }

    RomanNumeral(int decimalNumber) {
        this.decimalNumber = decimalNumber;
    }

    String getRomanNumeral() {
        if (romanNumeral.isEmpty())
            computeRomanNumeral();

        return this.romanNumeral;
    }

    private void computeRomanNumeral() {
       int dec = decimalNumber;
       StringBuilder romNum;

    }
}