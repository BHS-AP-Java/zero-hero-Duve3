package edu.bhscs.items;

public class Money extends Item {
  public double value;

  public Money(double value) {
    super("Money");
    this.value = value;
  }

  /**
   * @param other
   * @return boolean
   */
  public boolean stack(Item other) {
    if (other instanceof Money) {
      this.value += ((Money) other).value;

      return true;
    }

    return false;
  }
}
