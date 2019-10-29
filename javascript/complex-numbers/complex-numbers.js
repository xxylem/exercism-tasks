export class ComplexNumber {
  constructor(a, b) {
    this.a = a;
    this.b = b;
  }

  get real() { return this.a; }
  get imag() { return this.b; }

  add(other) {
    return new ComplexNumber(
      this.a + other.a, 
      this.b + other.b);
  }

  sub(other) {
    return new ComplexNumber(
      this.a - other.a, 
      this.b - other.b);
  }

  div(other) {
    const denominator = other.a ** 2 + other.b ** 2;
    return new ComplexNumber(
      (this.a * other.a + this.b * other.b) / denominator,
      (this.b * other.a - this.a * other.b) / denominator
    ); 
  }

  mul(other) {
    return new ComplexNumber(
      this.a * other.a - this.b * other.b,
      this.b * other.a + this.a * other.b);
  }

  get abs() {
    const val = Math.hypot(this.a, this.b);
    Object.defineProperty(this, "abs", { value: val });
    return val;
  }


  get conj() {
    const val = new ComplexNumber(
      this.a, 
      this.b === 0 ? 0 : -this.b);  // Needed to avoid -0
    Object.defineProperty(this, "conj", { value: val })
    return val;
  }
  
  get exp() {
    const ea = Math.exp(this.a);
    const val = new ComplexNumber(
      ea * Math.cos(this.b),
      ea * Math.sin(this.b)
    );
    Object.defineProperty(this, "exp", { value: val })
    return val;
  }
}
