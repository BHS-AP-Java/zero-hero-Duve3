package edu.bhscs;

import edu.bhscs.items.*;

public class PTSA extends Store {

  private Person person;

  public PTSA() {
    super("PTSA", "The Objective.");
    this.person = new Person("PTSA");

    // we are broke!
    this.person.giveItem(new Money(0d));
  }

  public void giveMoney(Money money) {
    this.person.giveItem(money);
  }

  public void giveHonoredOne(Person person) {
    person.giveItem(this.person.getHeldItem(), true);
    ((Money) this.person.getHeldItem()).value = 0;
  }

  public double getMoney() {
    for (Item item : this.person.getInventory()) {
      if (item instanceof Money) {
        return ((Money) item).value;
      }
    }
    return 0;
  }
}
