// Dhruv Hooda
// P2
// Zero Hero
// 9/19/25

/*
 * DESCRIPTION: The PTSA that is necessary for winning the game!
 * INPUT: Whether or not you want to recieve money!
 * OUTPUT: The PTSA gets money and you get money!
 * EDGE CASE: Shortage of money!
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
    return this.person.getMoney().value;
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
