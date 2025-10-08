// Dhruv Hooda
// P2
// Zero Hero
// 9/19/25

/*
 * DESCRIPTION: Money item that is used for transactions
 * INPUT: No real input i guess!
 * OUTPUT: Creates money which is used throughout the game
 * EDGE CASE: probably some major bug in here but idk what it is
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
