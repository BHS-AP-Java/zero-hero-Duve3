// Dhruv Hooda
// P2
// Zero Hero
// 9/19/25

/*
 * DESCRIPTION: Its a game where you can buy cakes from bakeries to help fund the PTSA!
 * INPUT: You can eat more cake!
 * OUTPUT: You can watch yourself eat cake!!
 * EDGE CASE: Shortage of cakes!
 */

package edu.bhscs.items;

import java.util.Random;

public class Sugar extends Sellable {
  public Sugar() {
    super("Sugar", new Random().nextInt(10) + 1);
    this.amount = 1;
  }

  /**
   * clones the other object and returns a deepcopy
   *
   * @param other the other sellable
   */
  public Sellable deepClone(Sellable other) {
    if (other instanceof Sugar) {
      Sugar dup = new Sugar();
      dup.quality = this.quality;
      dup.price = this.price;
      dup.amount = this.amount;
      return dup;
    }

    return null;
  }

  /**
   * Stacks with the other item, increases amount of sugar and averages quality.
   *
   * @param other
   * @return boolean
   */
  public boolean stack(Item other) {
    if (other instanceof Sugar) {
      this.amount += other.amount;

      // averaging quality based on our two combined sugars
      this.quality = CalculateQuality(((Sugar) other).quality);

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
    return quality * 0.5 + 5; // sugar is cheaper!
  }
}
