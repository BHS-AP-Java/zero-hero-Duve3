package edu.bhscs.items;

public class Egg extends Item {
  public Egg() {
    super("Egg");
  }

  public boolean stack(Item other) {
    return false; // eggs cannot stack (duh??)
  }
}
