package edu.bhscs.items;

public abstract class Item {
  private String name;
  public int amount;

  public Item(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public abstract boolean stack(Item other);
}
