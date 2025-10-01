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
