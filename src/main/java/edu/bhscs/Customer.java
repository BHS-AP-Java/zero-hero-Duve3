package edu.bhscs;

import edu.bhscs.items.*;

public class Customer extends Person {
  // fields
  // we have no fields :(

  // constuctor
  public Customer(String name) {
    super(name);
  }

  // methods
  public void takeCake(Cake cake) {
    this.giveItem(cake);
  }

  public double pay(double price) {
    // take away money
    this.giveItem(new Money(-price));

    return price;
  }
}
