// Dhruv Hooda
// P2
// Zero Hero
// 9/19/25

/*
 * DESCRIPTION: Flour class that extends sellable
 * INPUT: No real input i guess!
 * OUTPUT: Creates flour, which is needed for cakes
 * EDGE CASE: uhh, not really?
 */

package edu.bhscs.items;

import java.util.Random;

public class Flour extends Sellable {
  // constructor
  public Flour() {
    super("Flour", new Random().nextInt(10) + 1);
    this.amount = 1;
  }

  /**
   * clones the other object and returns a deepcopy
   *
   * @param other the other sellable
   */
  public Sellable deepClone(Sellable other) {
    if (other instanceof Flour) {
      Flour dup = new Flour();
      dup.quality = this.quality;
      dup.price = this.price;
      dup.amount = this.amount;
      return dup;
    }

    return null;
  }

  // methods
  /**
   * Stacks another item onto this one, if possible.
   *
   * @param other
   * @return boolean
   */
  public boolean stack(Item other) {
    if (other instanceof Flour) {
      this.amount += other.amount;

      // averaging quality based on our two combined flours
      this.quality = CalculateQuality(((Flour) other).quality);

      // each "tier" of quality is expoentially more expensive
      this.price = CalculatePrice(this.quality);
      return true;
    }

    return false;
  }

  /**
   * Calculates the price based on quality
   *
   * @param quality an int containing the quality
   * @return double the price
   */
  public double CalculatePrice(int quality) {
    return quality * 0.5;
  }
}
