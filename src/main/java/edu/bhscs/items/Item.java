// Dhruv Hooda
// P2
// Zero Hero
// 9/19/25

/*
 * DESCRIPTION: Base abstract Item class that is used for all items!
 * INPUT: No real input i guess!
 * OUTPUT: Creates items which is used throughout the game
 * EDGE CASE: probably some major bug in here but idk what it is
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
