class IsbnVerifier {

    boolean isValid(String stringToVerify) {
        // Remove everything but digits.
        String digits = stringToVerify.replaceAll("[^0-9X ]", "");

        if (digits.length() != 10)
            return false;

        int checksum = 0;
        int multiplicand = 10;
        for (int i = 0; i < 9; i++) {
            char d = digits.charAt(i);

            if (!Character.isDigit(d))
                return false;

            checksum += Character.getNumericValue(d) * multiplicand;
            multiplicand--;
        }

        // Last digit is a special case.
        if (digits.charAt(9) == 'X')
            checksum += 10;
        else
            checksum += Character.getNumericValue(digits.charAt(9));

        return checksum % 11 == 0;
    }
}
