package edu.bhscs;

import edu.bhscs.items.*;

public class Baker extends Person {

  // fields and properities
  public String name;

  // constructor definition
  public Baker(String name) {
    super(name);
    this.name = name;
  }

  // methods

  /**
   * Starts baking a cake, currently just a placeholder (in the future there will be timers and stuff)
   *
   * @param cake The cake to back
   */
  public Cake bake(Cake cake) {
    Console console = Console.getInstance();
    console.println(this.name + " is baking a " + cake.getName() + "!");

    return cake;
  }
}
