import org.junit.Before;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class NaturalNumberTest {

    private Set<Integer> expectedFactors;

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Before
    public void setup() {
        expectedFactors = new HashSet<>();
    }

    @Test
    public void testSmallPerfectNumberIsClassifiedCorrectly() {
        assertEquals(Classification.PERFECT, new NaturalNumber(6).getClassification());
    }

    @Test
    public void testMediumPerfectNumberIsClassifiedCorrectly() {
        assertEquals(Classification.PERFECT, new NaturalNumber(28).getClassification());
    }

    @Test
    public void testLargePerfectNumberIsClassifiedCorrectly() {
        assertEquals(Classification.PERFECT, new NaturalNumber(33550336).getClassification());
    }

    @Test
    public void testSmallAbundantNumberIsClassifiedCorrectly() {
        assertEquals(Classification.ABUNDANT, new NaturalNumber(12).getClassification());
    }

    @Test
    public void testMediumAbundantNumberIsClassifiedCorrectly() {
        assertEquals(Classification.ABUNDANT, new NaturalNumber(30).getClassification());
    }

    @Test
    public void testLargeAbundantNumberIsClassifiedCorrectly() {
        assertEquals(Classification.ABUNDANT, new NaturalNumber(33550335).getClassification());
    }

    @Test
    public void testSmallestPrimeDeficientNumberIsClassifiedCorrectly() {
        assertEquals(Classification.DEFICIENT, new NaturalNumber(2).getClassification());
    }

    @Test
    public void testSmallestNonPrimeDeficientNumberIsClassifiedCorrectly() {
        assertEquals(Classification.DEFICIENT, new NaturalNumber(4).getClassification());
    }

    @Test
    public void testMediumDeficientNumberIsClassifiedCorrectly() {
        assertEquals(Classification.DEFICIENT, new NaturalNumber(32).getClassification());
    }

    @Test
    public void testLargeDeficientNumberIsClassifiedCorrectly() {
        assertEquals(Classification.DEFICIENT, new NaturalNumber(33550337).getClassification());
    }

    @Test
    /*
     * The number 1 has no proper divisors (https://en.wikipedia.org/wiki/Divisor#Further_notions_and_facts), and the
     * additive identity is 0, so the aliquot sum of 1 should be 0. Hence 1 should be classified as deficient.
     */
    public void testThatOneIsCorrectlyClassifiedAsDeficient() {
        assertEquals(Classification.DEFICIENT, new NaturalNumber(1).getClassification());
    }

    @Test
    public void testThatNonNegativeIntegerIsRejected() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("You must supply a natural number (positive integer)");

        new NaturalNumber(0);
    }

    @Test
    public void testThatNegativeIntegerIsRejected() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("You must supply a natural number (positive integer)");

        new NaturalNumber(-1);
    }

    @Test
    public void testAliquotSum6() {
        assertEquals(6, new NaturalNumber(6).computeAliquotSum());
    }

    @Test
    public void testAliquotSum8() {
        assertEquals(7, new NaturalNumber(8).computeAliquotSum());
    }

    @Test
    public void testAliquotSum12() {
        assertEquals(16, new NaturalNumber(12).computeAliquotSum());
    }

    @Test
    public void testAliquotSum15() {
        assertEquals(9, new NaturalNumber(15).computeAliquotSum());
    }

    @Test
    public void testAliquotSum24() {
        assertEquals(36, new NaturalNumber(24).computeAliquotSum());
    }

    @Test
    public void testAliquotSum28() {
        assertEquals(28, new NaturalNumber(28).computeAliquotSum());
    }

    @Test
    public void testFactorsOf6() {
        expectedFactors.add(1);
        expectedFactors.add(2);
        expectedFactors.add(3);
        assertEquals(expectedFactors, new NaturalNumber(6).getFactors());
    }

    @Test
    public void testFactorsOf15() {
        expectedFactors.add(1);
        expectedFactors.add(3);
        expectedFactors.add(5);
        assertEquals(expectedFactors, new NaturalNumber(15).getFactors());
    }

    @Test
    public void testFactorsOf28() {
        expectedFactors.add(1);
        expectedFactors.add(2);
        expectedFactors.add(4);
        expectedFactors.add(7);
        expectedFactors.add(14);
        assertEquals(expectedFactors, new NaturalNumber(28).getFactors());
    }

}
