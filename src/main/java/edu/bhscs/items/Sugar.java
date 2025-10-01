package edu.bhscs.items;

import java.util.Random;

public class Sugar extends Sellable {
  public Sugar() {
    super("Sugar", new Random().nextInt(10) + 1);
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
