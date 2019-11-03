import java.util.LinkedHashMap;
import java.util.Map;

class RomanNumeral {

    private final int decimalNumber;
    private String romanNumeral;

    // LinkedHashMap is used to preserve insertion order, which is necessary for
    // the method computeRomanNumeral.
    private static Map<Integer, StringBuilder> numerals = new LinkedHashMap<>();
    static {
        numerals.put(1000, new StringBuilder("M"));
        numerals.put(900, new StringBuilder("CM"));
        numerals.put(500, new StringBuilder("D"));
        numerals.put(400, new StringBuilder("CD"));
        numerals.put(100, new StringBuilder("C"));
        numerals.put(90, new StringBuilder("XC"));
        numerals.put(50, new StringBuilder("L"));
        numerals.put(40, new StringBuilder("XL"));
        numerals.put(10, new StringBuilder("X"));
        numerals.put(9, new StringBuilder("IX"));
        numerals.put(5, new StringBuilder("V"));
        numerals.put(4, new StringBuilder("IV"));
        numerals.put(1, new StringBuilder("I"));
    }

    RomanNumeral(int decimalNumber) {
        this.decimalNumber = decimalNumber;
        // Although it may no be best practise to perform much computation in the constructor,
        // since the only thing this class does it provide the roman numeral representation
        // of a decimal number, it is reasonable to presume that the caller will want to
        // perform this computation always.
        computeRomanNumeral();
    }

    String getRomanNumeral() {
        return this.romanNumeral;
    }

    private void computeRomanNumeral() {
       int dec = this.decimalNumber;
       StringBuilder romNums = new StringBuilder();
       for (int val : numerals.keySet()) {
           while (dec >= val) {
               romNums.append(numerals.get(val));
               dec -= val;
           }
       }
       this.romanNumeral = romNums.toString();
    }
}