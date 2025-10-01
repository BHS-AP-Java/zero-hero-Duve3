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
   * Starts baking a cake, currently just a placeholder (in the future there will be timers and
   * stuff)
   *
   * @param cake The cake to back
   */
  public Cake bake(Cake cake) {
    Console console = Console.getInstance();
    console.println(this.name + " is baking a " + cake.getName() + "!");

    return cake;
  }
}
