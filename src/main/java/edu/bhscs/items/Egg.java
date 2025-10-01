package edu.bhscs.items;

import java.util.Random;

public class Egg extends Sellable {
  public Egg() {
    super("Egg", new Random().nextInt(10) + 1);
  }

  /**
   * clones the other object and returns a deepcopy
   *
   * @param other the other sellable
   */
  public Sellable deepClone(Sellable other) {
    if (other instanceof Egg) {
      Egg dup = new Egg();
      dup.quality = this.quality;
      dup.price = this.price;
      dup.amount = this.amount;
      return dup;
    }

    return null;
  }

  /**
   * Stacks with the other item, always false for eggs.
   *
   * @param other
   * @return boolean
   */
  public boolean stack(Item other) {
    return false; // eggs cannot stack (duh??)
  }

  /**
   * Calculates the price based on quality
   *
   * @param quality an int containing the quality
   * @return double the price
   */
  public double CalculatePrice(int quality) {
    return quality * 0.25 + 5;
  }
}
