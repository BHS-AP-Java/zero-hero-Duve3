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

import java.util.Scanner;
import edu.bhscs.items.*;

class Main {

  private Scanner scanner;

  private Store bakery;
  private Person person;
  private Person PTSA;

  public void main(String[] args) {
    this.scanner = new Scanner(System.in);

    System.out.print("What is your name?\n>");
    String name = this.scanner.nextLine();
    this.person = new Person(name, 29);

    this.PTSA = new PTSA();

    System.out.println("Welcome to my Cake Shop, " + person.getName() + "!");
    System.out.println("Lets make a cake!");
    Cake cake = MakeCake();
    person.giveItem(cake);

    System.out.println("Would you like to eat your cake now?");
    String response = this.scanner.nextLine();

    if (response.equalsIgnoreCase("yes")) {
      Item heldItem = person.getHeldItem();
      if (heldItem instanceof Cake) {
        ((Cake) heldItem).eat();
      } else {
        System.out.println("You are not holding a cake!");
      }
    } else {
      System.out.println("You can eat your cake later!");
    }

    System.out.println("Pretty cool cake!");
    System.out.println("Goodbye!");

    this.scanner.close();
  }

  private Cake MakeCake() {
    // makes a cake for the user
    System.out.println("What flavor of cake would you like?");
    String flavor = this.scanner.nextLine();

    System.out.println("Give another flavor!");
    String secondFlavor = this.scanner.nextLine();

    System.out.println("How many slices would you like of this cake?");
    int slices = this.scanner.nextInt();

    return new Cake(new String[] {flavor, secondFlavor}, slices);
  }
}
