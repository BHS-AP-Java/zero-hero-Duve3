package edu.bhscs.items;

import java.util.Random;

public class Butter extends Sellable {
  public Butter() {
    super("Butter", new Random().nextInt(10) + 1);
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
   * Calculates the price based on quality
   *
   * @param quality an int containing the quality
   * @return double the price
   */
  public double CalculatePrice(int quality) {
    return quality * 0.75 + 10; // butter is expensive!
  }
}
