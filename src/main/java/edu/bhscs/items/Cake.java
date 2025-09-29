package edu.bhscs.items;

public class Cake extends Item {
  private int _slices;
  private String _flavor;
  private String _color;
  private int _weight;

  public Cake(String[] ingredients, int slices) {
    super("Cake");
    this._slices = slices;
    this.amount = 1;

    System.out.println(
        "baking a " + slices + " slices cake with... " + String.join(", ", ingredients));
  }

  public void eat() {
    System.out.println("Eating a slice of cake");
    this._slices--;
    System.out.println("There are " + this._slices + " slices left!");
  }

  public boolean stack(Item other) {
    return false; // we do not stack ts
  }
}
