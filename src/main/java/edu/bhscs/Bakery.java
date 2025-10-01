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

package edu.bhscs;

import edu.bhscs.items.*;

public class Bakery extends Store {
  private Baker baker;

  public Bakery(String name, String description, Baker baker) {
    super(name, description);
    this.baker = baker;
  }

  public Cake bake(Sellable[] ingredients) {
    return baker.bake(new Cake(ingredients));
  }
}
