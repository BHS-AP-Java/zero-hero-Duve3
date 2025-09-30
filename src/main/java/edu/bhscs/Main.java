// Dhruv Hooda
// P2
// Zero Hero
// 9/19/25

/*
 * DESCRIPTION:
 *  for a baker to make cake,
 *  bake it at a bakery
 *  sell it to a customer
 *  and deliver the money to the PTSA!!!!!
 *
 * INPUT: You can eat more cake!
 * OUTPUT: You can watch yourself eat cake!!
 * EDGE CASE: You can eat infinite cake which isn't possible in real life
 */

// idea:
//  - while loop that allows person go to into different stores that sell different items and cakes
//  - turn it into a game
package edu.bhscs;

import edu.bhscs.items.*;
import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    // object definition since we have to use a static context
    PTSA PTSA = new PTSA();
    Store[] bakerys =
      new Store[] {new Store("Cool Bakery", "A place that sells *cool* cakes goods"),
      new Store("Cake Shop", "A place that sells less cool cakes")
    };


    Scanner scanner = new Scanner(System.in);

    System.out.print("What is your name?\n> ");
    String name = scanner.nextLine();
    Person person = new Person(name, 29);


    System.out.println("Hello " + person.getName() + "!");
    // questionable cast to money but i SWEAR its always money!!
    System.out.println("The PTSA has: " + ((Money) PTSA.getHeldItem()).getValue() + " dollars!!");

    // just print all the stores
    System.out.println("All available stores:");
    for (Store bakery : bakerys) {
      System.out.println("- " + bakery.getName() + ": " + bakery.getDescription());
    }

    scanner.close();
  }
}
