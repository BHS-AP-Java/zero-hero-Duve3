// Dhruv Hooda
// P2
// Zero Hero
// 9/19/25

/*
 * DESCRIPTION: Its a game where you can buy cakes from bakeries to help fund the PTSA! ~ Hyper refactored.
 * INPUT: You can eat more cake!
 * OUTPUT: You can watch yourself eat cake!!
 * EDGE CASE: Shortage of cakes!
 */

package edu.bhscs;

import edu.bhscs.items.*;
import java.util.Arrays;

class Main {
  // fields and properities
  private static final PTSA PTSA = new PTSA();

  // constructor
  public static void main(String[] args) {
    // questionably made, rewritten for our new objective
    // ^ rewritten from "you are the customer and baker" to just "you are baker"
    Console console = Console.getInstance();


    console.print("What is your name?\n> ");
    Player player = new Player(console.readLine());

    console.println("Welcome " + player.getName() + "!");

    // gameloop
    while (true) {
      console.print("Where would you like to go? (type 'cmds' for commands)\n> ");
      String[] cmds = console.readLine().split(" ");

      if (cmds[0].equals("cmds")) {
        console.println("Commands:");
        console.println("- cmds: show this message");
        console.println("- quit/q: quit the program");
        console.println("- work: work for the Bakery");
        continue;
      }

      if (cmds[0].equals("quit") || cmds[0].equals("q")) {
        break;
      }

      if (cmds[0].equals("work")) {
        console.println("You now work for mr reibers bakery");
      }
    }

    console.close();
  }
}