export const abilityModifier = (abilityScore) => {

  if (abilityScore > 18)
    throw new Error('Ability scores can be at most 18');
  if (abilityScore < 3)
    throw new Error('Ability scores must be at least 3');

  return Math.floor((abilityScore - 10) / 2);
};

export class Character {

  static rollAbility() {

    let fourRandomRolls = [...Array(4)].map(() => Math.floor(Math.random() * 6) + 1);
    return fourRandomRolls.sort().slice(1).reduce((a, b) => a + b, 0);
  }

  rollAndSetAbility(ability) {
    let score = Character.rollAbility();
    Object.defineProperty(this, ability, { value: score });
    return score;
  }
  
  get strength()      { return this.rollAndSetAbility("strength"); }
  get dexterity()     { return this.rollAndSetAbility("dexterity"); }
  get constitution()  { return this.rollAndSetAbility("constitution"); }
  get intelligence()  { return this.rollAndSetAbility("intelligence"); }
  get wisdom()        { return this.rollAndSetAbility("wisdom"); }
  get charisma()      { return this.rollAndSetAbility("charisma"); }

  get hitpoints() {
    let hp = 10 + abilityModifier(this.constitution);
    Object.defineProperty(this, "hitpoints", { value: hp });
    return hp;
  }
}
