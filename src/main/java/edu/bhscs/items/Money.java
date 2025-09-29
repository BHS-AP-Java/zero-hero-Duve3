package edu.bhscs.items;

public class Money extends Item {
  protected double _value;

  public Money(double value) {
    super("Money");
    this._value = value;
  }

  public double getValue() {
    return this._value;
  }

  public boolean stack(Item other) {
    if (other instanceof Money) {
      ((Money) other)._value += this._value;

      return true;
    }

    return false;
  }
}
