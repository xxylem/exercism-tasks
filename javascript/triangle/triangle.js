export class Triangle {
  // Creates a Triangle with sides of length a, b, c.
  constructor(a, b, c) {

    this.a = a;
    this.b = b;
    this.c = c;

  }

  /** SIDE-EFFECTS: Sets this.tkind to the type of triangle.
   *  OUTPUT: returns the type of this triangle. */
  kind() {
    // Ideally I would call these from the constructor
    // and forbid creating an invalid triangle, but the
    // test suite expects the errors to be thrown from here.
    // In that case, this would be a simple getter.
    this.validate_sides();
    this.determine_kind();
    return this.tkind;
  }

  /** SIDE-EFFECTS: Sets this.tkind to the type of triangle. */
  determine_kind() {
    
    // Count how many sides are equal
    let equality_count = 0;
    if (this.a == this.b)
      equality_count++
    if (this.b == this.c)
      equality_count++
    if (this.a == this.c)
      equality_count++

    switch (equality_count) {

      case 3:
        this.tkind = "equilateral";
        return;
  
      case 1:
        this.tkind = "isosceles";
        return;

      case 0:
        this.tkind = "scalene";
        return;
    } 
  }

  /** SIDE-EFFECTS: Will throw an error if the sides are not valid.
   *  OUTPUT: returns true if the sides are a valid description of
   *          a triangle, false otherwise. */
  validate_sides () {
    return this.are_positive_lengths() && this.triangle_inequality_holds(); 
  }
  
  /** SIDE-EFFECTS: Will throw an error if the sides are not positive. */
  are_positive_lengths () {
    if (this.a > 0 && this.b > 0 && this.c > 0)
      return true; 
    else
      throw (new Error("All sides must have positive length."));
  }
  
  /** SIDE-EFFECTS: Will throw an error if inequality doesn't hold. */
  triangle_inequality_holds () {
    if ((this.a + this.b > this.c) 
        && (this.a + this.c > this.b) 
        && (this.b + this.c > this.a))
      return true;
    else
      throw (new Error("The triangle inequality must hold."));
  }
}