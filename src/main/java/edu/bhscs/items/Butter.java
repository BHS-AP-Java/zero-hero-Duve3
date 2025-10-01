package edu.bhscs.items;

import java.util.Random;

public class Butter extends Sellable {
  public Butter() {
    super("Butter", new Random().nextInt(10) + 1);
    this.amount = 1;
  }

  /**
   * Stacks with the other item, always false for butter.
   *
   * @param other
   * @return boolean
   */
  public boolean stack(Item other) {
    return false; // butter cannot stack (duh??)
  }

  /**
   * clones the other object and returns a deepcopy
   *
   * @param other the other sellable
   */
  public Sellable deepClone(Sellable other) {
    if (other instanceof Butter) {
      Butter dup = new Butter();
      dup.quality = this.quality;
      dup.price = this.price;
      dup.amount = this.amount;
      return dup;
    }

    return null;
  }

  /**
   * Calculates the price based on quality
   *
   * @param quality an int containing the quality
   * @return double the price
   */
  public double CalculatePrice(int quality) {
    return quality * 0.75 + 10; // butter is expensive!
  }
}
