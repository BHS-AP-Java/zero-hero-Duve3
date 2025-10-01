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
