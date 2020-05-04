using System;
using System.Linq;

public enum Allergen
{
    Eggs =          0b1,
    Peanuts =       0b10,
    Shellfish =     0b100,
    Strawberries =  0b1000,
    Tomatoes =      0b10000,
    Chocolate =     0b100000,
    Pollen =        0b1000000,
    Cats =          0b10000000,
}

public class Allergies
{
    private readonly int mask;

    public Allergies(int mask) => this.mask = mask;

    public bool IsAllergicTo(Allergen allergen) => ((int)allergen & mask) > 0;

    public Allergen[] List() => Enum.GetValues(typeof(Allergen))
        .Cast<Allergen>()
        .Where(a => IsAllergicTo(a))
        .ToArray();
}