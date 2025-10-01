package edu.bhscs.items;

import java.util.Arrays;

public class Cake extends Sellable {

  public Cake(Sellable[] ingredients) {
    // YES this is bad code, but i dont feel like making a proper name generator for cakes (its ragebait since super call has to be first)
    super(String.join("-", Arrays.stream(ingredients).map((ingredient) -> ingredient.getName()).toArray(String[]::new)) + " Cake", Math.round(Sellable.SumQualities(ingredients) / ingredients.length));
    this.amount = 1;
  }

  /**
   * Stacking function, always false.
   *
   * @param other
   * @return boolean
   */
  public boolean stack(Item other) {
    return false; // cakes cannot stack (duh??)
  }

  /**
   * Price calculation for quality
   *
   * @param quality an int containing the quality
   * @return double the price
   */
  public double CalculatePrice(int quality) {
    return quality * 2 + 20;
  }
}
