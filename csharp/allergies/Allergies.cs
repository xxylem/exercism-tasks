using System;
using System.Linq;

[Flags]
public enum Allergen
{
    Eggs =          0b_0000_0001,  // 1
    Peanuts =       0b_0000_0010,  // 2
    Shellfish =     0b_0000_0100,  // 4
    Strawberries =  0b_0000_1000,  // 8
    Tomatoes =      0b_0001_0000,  // 16
    Chocolate =     0b_0010_0000,  // 32
    Pollen =        0b_0100_0000,  // 64
    Cats =          0b_1000_0000,  // 128
}

public class Allergies
{
    private readonly Allergen mask;

    public Allergies(int mask) => this.mask = (Allergen)mask;

    public bool IsAllergicTo(Allergen allergen) => mask.HasFlag(allergen);

    public Allergen[] List() => Enum.GetValues(typeof(Allergen))
        .Cast<Allergen>()
        .Where(a => IsAllergicTo(a))
        .ToArray();
}