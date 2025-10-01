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

public class PTSA extends Store {

  private Person person;

  public PTSA() {
    super("PTSA", "The Objective.");
    this.person = new Person("PTSA");

    // we are broke!
    giveMoney(new Money(0d));
  }

  /**
   * To give money to the PTSA
   *
   * @param money Money item
   */
  public void giveMoney(Money money) {
    this.person.giveItem(money);
  }

  /**
   * Gives the "honored one" (the player) all the PTSA money
   *
   * @param person the player
   */
  public void giveHonoredOne(Person person) {
    person.giveItem(new Money(getMoney()), true);
    setMoney(0d, true);
  }

  /**
   * Gets the money
   *
   * @return
   */
  public double getMoney() {
    for (Item item : this.person.getInventory()) {
      if (item == null) {
        continue;
      }
      if (item instanceof Money) {
        return ((Money) item).value;
      }
    }
    return 0;
  }

  /**
   * Sets the money of the PTSA by calculating the difference between two objects and using negative
   * money
   *
   * @param value the double value of money
   */
  public void setMoney(double value) {
    double money = getMoney();

    double diff = value - money;

    giveMoney(new Money(diff));
  }

  /**
   * setMoney but allows disabling output!
   *
   * @param value the value
   * @param disableOutput whether to disable output (true disables)
   */
  public void setMoney(double value, boolean disableOutput) {
    Console console = Console.getInstance();

    console.allowOutput(!disableOutput);
    setMoney(value);
    console.allowOutput(disableOutput);
  }
}
