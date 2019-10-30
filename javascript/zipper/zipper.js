export class Zipper {
  /* A Zipper has two parts:
    subtree: the part of the tree from the focused node down.
    thread: the sequence of steps required to reach the focused
            node from the root of the tree. 
      Each step in the thread contains:
        -val: the value of the node that was removed
        -direction: the direction taken from the node
        -otherSubtree: the subtree that branches off in the
          direction not taken. */
  constructor(subtree, thread) {
    this.subtree = Object.freeze(subtree);
    this.thread = Object.freeze(thread);
  }

  static fromTree(tree) {
    return Object.freeze(
      new Zipper(
        tree, 
        [] // The thread is empty: we haven't taken any steps yet.
    ));
  }

  toTree() {
    // We are at the root of the tree.
    if (this.thread.length === 0)
      return this.subtree;

    // We need to reverse steps to get back to the root of the tree.
    return this.up().toTree();
  }

  value() {
    return this.subtree.value;
  }

  // Creates an immutable entry that can be added to the thread.
  static threadEntry(val, direction, otherSubtree) {
    return Object.freeze({
      val,
      direction,
      otherSubtree
    });
  }

  // Creates an immutable copy of the thread of this Zipper that
  // is extended in the given direction.
  extendThread(direction) {
    const endOfThread = Zipper.threadEntry(
        this.subtree.value, 
        direction, 
        direction === 'l' ? this.subtree.right : this.subtree.left
    );
    
    const threadNew = [...this.thread];
    threadNew.push(endOfThread);

    return Object.freeze(threadNew);
  }

  // Returns a new zipper focused on the left subtree.
  left() {
    if (this.subtree.left === null)
      return null;

    return Object.freeze(
      new Zipper(
        this.subtree.left, 
        this.extendThread('l')
    ));
  }

  // Returns a new zipper focused on the right subtree.
  right() {
    if (this.subtree.right === null)
      return null;

    return Object.freeze(
      new Zipper(
        this.subtree.right, 
        this.extendThread('r')
    ));
  }

  // Duplicated from the test suite to avoid depending on the test suite.
  // Modified to guarantee immutability.
  static bt(value, left, right) {
    return Object.freeze({
      value,
      left,
      right
    });
  }

  // Steps backwards once based on the last step taken in the thread.
  up() {
    if (this.thread.length === 0)
      return null;

    // Rebuild subtree from thread.
    const {val, direction, otherSubtree} = this.thread[this.thread.length - 1];
    const subtree =
      Zipper.bt(val, 
        direction === 'l' ? this.subtree : otherSubtree,
        direction === 'r' ? this.subtree : otherSubtree);

    return Object.freeze(
      new Zipper(
        subtree, 
        this.thread.slice(0, -1) // Remove last step in thread.
    ));
  }

  // Returns a new Zipper with the current node's value set to value.
  setValue(value) {
    const {left, right} = this.subtree;
    const subtree =
      Zipper.bt(value, left, right);

    return Object.freeze(
      new Zipper(
        subtree, 
        this.thread)
    );
  }

  // Returns a new Zipper with the current node's left subtree set to left.
  setLeft(left) {
    const {value, right} = this.subtree;
    const subtree =
      Zipper.bt(value, left, right);

    return Object.freeze(
      new Zipper(
        subtree, 
        this.thread)
    );
  }

  // Returns a new Zipper with the current node's right subtree set to right.
  setRight(right) {
    const {value, left} = this.subtree;
    const subtree =
      Zipper.bt(value, left, right);

    return Object.freeze(
      new Zipper(
        subtree, 
        this.thread)
    );
  }
}
