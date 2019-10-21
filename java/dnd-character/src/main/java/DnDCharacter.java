import java.util.Random;
import java.util.stream.IntStream;

class DnDCharacter {

    static private final Random r = new Random();

    private int strength;
    private int dexterity;
    private int constitution;
    private int intelligence;
    private int wisdom;
    private int charisma;
    private int hitpoints;

    DnDCharacter() {
        strength = ability();
        dexterity = ability();
        constitution = ability();
        intelligence = ability();
        wisdom = ability();
        charisma = ability();
        hitpoints = 10 + modifier(constitution);
    }

    int ability() {
        IntStream dice = r.ints(4, 1, 7);
        dice = dice.sorted();
        dice = dice.skip(1);
        return dice.sum();
    }

    int modifier(int input) { return Math.floorDiv(input - 10, 2); }

    // Getters
    int getStrength() { return strength; }
    int getDexterity() { return dexterity; }
    int getConstitution() { return constitution; }
    int getIntelligence() { return intelligence; }
    int getWisdom() { return wisdom; }
    int getCharisma() { return charisma; }
    int getHitpoints() { return hitpoints; }
}
