package edu.bhscs;

import edu.bhscs.items.*;

public class PTSA extends Person {

  public PTSA() {
    super("PTSA", 50);

    // we are broke!
    this.giveItem(new Money(0d));
  }
}
