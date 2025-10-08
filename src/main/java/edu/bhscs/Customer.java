package edu.bhscs;

import edu.bhscs.items.*;

public class Customer extends Person {
  // fields
  private double happiness = 0;

  // constuctor
  public Customer(String name) {
    super(name);
  }

  // methods
  public void takeCake(Cake cake) {
    this.giveItem(cake);
    this.happiness += cake.quality;
  }

  public double getHappiness() {
    return this.happiness;
  }

  public double pay(double price) {
    // take away money
    Console c = Console.getInstance();
    c.allowOutput(false);
    this.giveItem(new Money(-price));

    c.allowOutput(true);

    return price;
  }
}
