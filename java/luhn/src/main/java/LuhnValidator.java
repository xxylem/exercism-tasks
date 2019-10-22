class LuhnValidator {

    boolean isValid(String candidate) {
        String digits = candidate.replaceAll(" ", "");

        if (digits.matches("[^0-9]") || digits.length() < 2)
            return false;

        // Double every second digit from the right.
        boolean double_this_digit = digits.length() % 2 == 0;
        int sum = 0;
        for (char digit : digits.toCharArray()) {
            int d = Character.getNumericValue(digit);

            if (double_this_digit) {
                d *= 2;
                if (d > 9)
                    d -= 9;
            }

            sum += d;
            double_this_digit = !double_this_digit;
        }

        return sum % 10 == 0;
    }
}
