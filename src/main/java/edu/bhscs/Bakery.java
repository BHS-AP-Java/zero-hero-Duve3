// Dhruv Hooda
// P2
// Zero Hero
// 9/19/25

/*
 * DESCRIPTION: A bakery that sells and bakes cakes!
 * INPUT: Baking a whole lotta cakes!
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
