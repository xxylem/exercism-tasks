class PhoneNumber {

    private static final String wrongLengthExceptionMessage = "incorrect number of digits";
    private static final String moreThan11DigitsExceptionMessage = "more than 11 digits";
    private static final String numberIs11DigitsButDoesNotStartWith1ExceptionMessage =
            "11 digits must start with 1";
    private static final String illegalCharacterExceptionMessage =
            "letters not permitted";
    private static final String illegalPunctuationExceptionMessage =
            "punctuations not permitted";
    private static final String areaCodeStartsWithZeroExceptionMessage =
            "area code cannot start with zero";
    private static final String areaCodeStartsWithOneExceptionMessage =
            "area code cannot start with one";
    private static final String exchangeCodeStartsWithZeroExceptionMessage =
            "exchange code cannot start with zero";
    private static final String exchangeCodeStartsWithOneExceptionMessage =
            "exchange code cannot start with one";

    private String number;


    PhoneNumber(String number) {
        this.number = number;
        parseNumber();
    }


    String getNumber() {
        return number;
    }

    // I would prefer to do a full regex match on the number, but the test cases want
    // very specific errors.
    private void parseNumber() {
        checkInvalidCharacters();
        number = number.replaceAll("\\D", "");
        checkInvalidLength();
        stripCountryCode();
        checkAreaCode();
        checkExchangeCode();
    }

    private void checkInvalidCharacters() {
        if (number.matches(".*[a-zA-Z].*"))
            throw new IllegalArgumentException(illegalCharacterExceptionMessage);

        if (number.matches(".*[@:!].*"))
            throw new IllegalArgumentException(illegalPunctuationExceptionMessage);
    }

    // ASSUMES: number only contains digits.
    private void checkInvalidLength() {
        int numDigits = number.length();

        if (numDigits < 10)
            throw new IllegalArgumentException(wrongLengthExceptionMessage);
        if (numDigits > 11)
            throw new IllegalArgumentException(moreThan11DigitsExceptionMessage);
    }

    // ASSUMES: number only contains digits. number is 10 or 11 digits long.
    private void stripCountryCode() {
        if (number.length() == 11) {
            if (number.charAt(0) != '1')
                throw new IllegalArgumentException(numberIs11DigitsButDoesNotStartWith1ExceptionMessage);

            number = number.substring(1);
        }
    }

    // ASSUMES: Country code and any non-digits have been stripped from number already.
    private void checkAreaCode() {
        if (number.charAt(0) == '0')
            throw new IllegalArgumentException(areaCodeStartsWithZeroExceptionMessage);

        if (number.charAt(0) == '1')
            throw new IllegalArgumentException(areaCodeStartsWithOneExceptionMessage);
    }

    // ASSUMES: Country code and any non-digits have been stripped from number already.
    private void checkExchangeCode() {
        if (number.charAt(3) == '0')
            throw new IllegalArgumentException(exchangeCodeStartsWithZeroExceptionMessage);

        if (number.charAt(3) == '1')
            throw new IllegalArgumentException(exchangeCodeStartsWithOneExceptionMessage);
    }
}