package edu.bhscs.items;

import java.util.Random;

public class Flour extends Sellable {
  // sellable attrs
  public double price;
  public int quality;

  // constructor
  public Flour() {
    super("Flour", new Random().nextInt(10) + 1);
    this.amount = 1;
  }

  // methods
  /*
   * Method to stack flour items together
   * @param other The other item to stack with
   * @return true if the items were stacked, false otherwise
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

  public double CalculatePrice(int quality) {
    return quality * 0.5;
  }
}
