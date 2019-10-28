function mod(n, m) {
  return ((n % m) + m) % m;
}

export class Clock {

  constructor(hours=0, minutes=0) {
    this._minutes = 0;
    this._hours = 0;
    this.plus(hours * 60 + minutes);
  }

  toString() {
    return  String(this._hours).padStart(2, '0')
        +   ":"
        +   String(this._minutes).padStart(2, '0');
  }

  plus(minutes) {
    this._hours = mod(this._hours + Math.floor((this._minutes + minutes) / 60), 24);
    this._minutes = mod(this._minutes + minutes, 60);
    return this;
  }

  minus(minutes) {
    return this.plus(-minutes);
  }

  equals(other) {
    return this._minutes === other._minutes
          &&  this._hours === other._hours;
  }
}
