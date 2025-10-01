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

public class Money extends Item {
  public double value;

  public Money(double value) {
    super("Money");
    this.value = value;
  }

  /**
   * @param other
   * @return boolean
   */
  public boolean stack(Item other) {
    if (other instanceof Money) {
      this.value += ((Money) other).value;

      return true;
    }

    return false;
  }
}
