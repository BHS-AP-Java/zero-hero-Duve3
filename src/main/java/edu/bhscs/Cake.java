package edu.bhscs;

public class Cake extends Item {
  private int _slices;

  public Cake(String[] ingredients, int slices) {
    super("Cake");
    this._slices = slices;
    System.out.println(
        "baking a " + slices + "-inch cake with... " + String.join(", ", ingredients));
  }

  public void eat() {
    System.out.println("Eating a slice of cake");
    this._slices--;
    System.out.println("There are " + this._slices + " slices left!");
  }
}
