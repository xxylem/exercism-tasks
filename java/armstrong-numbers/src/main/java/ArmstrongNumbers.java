class ArmstrongNumbers {

	boolean isArmstrongNumber(int numberToCheck) {

		String digits = String.valueOf(numberToCheck);
		int sum = 0;
		int num_digits = digits.length();
		for (int i = 0; i < num_digits; i++)
			sum += Math.pow(Character.getNumericValue(digits.charAt(i)), num_digits);

		return sum == numberToCheck;

	}

}
