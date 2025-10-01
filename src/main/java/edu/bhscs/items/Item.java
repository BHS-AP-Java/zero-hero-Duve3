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

public abstract class Item {
  private String name;
  public int amount;

  public Item(String name) {
    this.name = name;
  }

  /**
   * @return String
   */
  public String getName() {
    return name;
  }

  public abstract boolean stack(Item other);
}
