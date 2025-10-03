// Dhruv Hooda
// P2
// Zero Hero
// 9/19/25

/*
 * DESCRIPTION: Base abstract Sellable class that extends Item and is used for all ingredients!
 * INPUT: No real input i guess!
 * OUTPUT: Creates sellables which is quite important for all the ingredients
 * EDGE CASE: probably a bug in here but idk what it is
 */

package edu.bhscs.items;

public abstract class Sellable extends Item {
  public double price;
  public int quality;

  public Sellable(String name, int quality) {
    super(name);
    this.quality = quality;
    this.price = CalculatePrice(quality);
  }

  public abstract Sellable deepClone(Sellable other);

  /**
   * @param other
   * @return int
   */
  public int CalculateQuality(int other) {
    return Math.round((this.quality + other) / 2);
  }

  public abstract double CalculatePrice(int quality);

  /**
   * @param items
   * @return int
   */
  public static int SumQualities(Sellable[] items) {
    int total = 0;
    for (Sellable item : items) {
      total += item.quality;
    }
    return total;
  }
}
