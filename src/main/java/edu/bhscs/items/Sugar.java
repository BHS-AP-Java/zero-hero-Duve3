// Dhruv Hooda
// P2
// Zero Hero
// 9/19/25

/*
 * DESCRIPTION: Sugar class that extends sellable and is used for sugar!
 * INPUT: No real input i guess!
 * OUTPUT: Creates sugar which is quite important for all the ingredients
 * EDGE CASE: probably a bug in here but idk what it is
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
