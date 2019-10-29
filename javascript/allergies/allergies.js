const ALL_ALLERGIES = new Map([
  ['eggs', 1 ], 
  ['peanuts', 2 ], 
  ['shellfish', 4 ], 
  ['strawberries', 8 ], 
  ['tomatoes', 16 ],
  ['chocolate', 32 ],
  ['pollen', 64 ],
  ['cats', 128 ] 
]);

export class Allergies {

  constructor(allergyScore) {

    this.allergies = [...ALL_ALLERGIES].reduce(
      
      (acc, [allergy, value]) => {
        // Bitwise and because each allergy is represented by a
        // different bit.
        if (value & allergyScore)
          acc.push(allergy)

        return acc;
      }, 
      
      []);
  }

  list() { return this.allergies; }

  allergicTo(allergy) { return this.allergies.includes(allergy); }
}
