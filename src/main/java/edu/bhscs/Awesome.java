package edu.bhscs;

public class Awesome {
    // we need to construct something awesome

    // fields / properities - this the stuff that awesome has
    String name;

    // the constructor of our class
    public Awesome(String name) {
      System.out.println("im am the most awesome " + name);
      this.name = name;
    }

    String getName() {
      return this.name;
    }
}
