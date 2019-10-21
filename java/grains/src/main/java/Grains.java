import java.math.BigInteger;

class Grains {

    BigInteger computeNumberOfGrainsOnSquare(final int square) {
        if (square < 1 || square > 64)
            throw new IllegalArgumentException("square must be between 1 and 64");

        // Powers of two relate to binary strings with only one bit set.
        BigInteger n = new BigInteger("0");
        return n.setBit(square - 1);
    }

    BigInteger computeTotalNumberOfGrainsOnBoard() {
        BigInteger sum = new BigInteger("0");
        for (int i = 1; i <= 64; i++)
            // Since only one bit is set in each value, we can OR or XOR them together.
            // An alternative would just be to set the bits directly in this loop but
            //  we couldn't use computeNumberOfGrainsOnSquare then.
            sum = sum.xor(computeNumberOfGrainsOnSquare(i));
        return sum;
    }

}
