export class HighScores {
  constructor(scores) {
    this._scores = scores;
    this._scores_sorted_descending = [...scores].sort( (a, b) => {
      return b - a;
    });
  }

  get scores() {
    return this._scores;
  }

  get latest() {
    return this._scores[this._scores.length - 1];
  }

  get personalBest() {
    return this._scores_sorted_descending[0];
  }

  get personalTopThree() {
    return this._scores_sorted_descending.slice(0, 3);
  }
}
