package edu.bhscs;

import edu.bhscs.items.*;

public class Baker extends Person {

  // fields and properities
  public String name;
  public Store bakery;
  public int skill = 5; // can only cook stuff using items below this quality value!!

  public double BAKE_TIME = 5; // time it takes to bake a cake in seconds
  public double FINISH_TIME = 0; // time when the cake will be finished

  private boolean ACTIVELY_BAKING = false; // whether the baker is currently baking

  // constructor definition
  public Baker(String name, Store bakery) {
    super(name, 30);
    this.name = name;
    this.bakery = bakery;
  }

  // methods
  public void bake(Cake cake) {
    if (ACTIVELY_BAKING) {
      if (System.currentTimeMillis() >= FINISH_TIME) {
        ACTIVELY_BAKING = false;
        System.out.println(this.name + " has finished baking the " + cake.getName() + "!");
        this.giveItem(cake, true); // give the cake to the baker, forcing it into their inventory
        return;
      } else {
        System.out.println(this.name + " is still baking the " + cake.getName() + "!");
        return;
      }
    }

    ACTIVELY_BAKING = true;
    FINISH_TIME = System.currentTimeMillis() + (BAKE_TIME * 1000);
    System.out.println(
        this.name + " is baking a " + cake.getName() + " at " + this.bakery.getName() + "!");
  }
}
