// Dhruv Hooda
// P2
// Zero Hero
// 9/19/25

/*
 * DESCRIPTION: mr reibers super cool baker class baker bkaer
 * INPUT: Name is put in the constructor
 * OUTPUT: Cake is outputted from the bake function
 * EDGE CASE: This class does not really do anything, so its hard to think of an edge case
 */

package edu.bhscs;

import edu.bhscs.items.*;

public class Baker {
  // -- PROPERTIES AND FIELDS --
  Player p;
  Flour f;
  Store placeOfWork;
  int cash;
  String name; // added because it didnt exist???
  int skill;

  // -- CONSTRUCTOR --
  Baker(Player p, String name) {
    this.p = p;
    this.name = name;
  }

  // -- METHODS --
  public void takeOrder(int price, Customer c) {
    cash += (int) c.pay(price); // ???
    c.takeCake(bakeCake());
  }

  public void learn(int amount) {
    this.skill += amount;
  }

  public Cake bakeCake() {
    String answer = this.p.giveAnswer("what cake do you you want?");
    return new Cake(answer, this.f, this.skill);
  }

  public void takeJob(Store bakery) {
    String doYouWantToWorkHere = this.p.giveAnswer("Do you want to work at " + bakery.getName());
    if (doYouWantToWorkHere.equals("y")) {
      this.placeOfWork = bakery;
      System.out.println(this.name + " now works at " + bakery.getName());
    }
  }
}
