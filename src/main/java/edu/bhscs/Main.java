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
import java.util.Random;

class Main {
  // fields and properities
  private static final PTSA PTSA = new PTSA();

  // constructor
  public static void main(String[] args) {
    // questionably made, rewritten for our new objective
    // ^ rewritten from "you are the customer and baker" to just "you are baker"
    Console console = Console.getInstance();

    console.clear();

    console.print("What is your name?\n> ");
    Player player = new Player(console.readLine());

    Customer[] customers =
        new Customer[] {new Customer("Alice"), new Customer("Bob"), new Customer("Charlie")};

    Baker baker = new Baker(player, "gurt");
    Store bakery = new Store("mr reibers bakery", "pretty cool bakery");

    console.println("Welcome " + player.getName() + "!");

    // gameloop
    while (true) {
      console.print("What would you like to do? (type 'cmds' for commands)\n> ");
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
        baker.takeJob(bakery);



        // customer loop
        while (true) {
          console.print("A customer walks in! Do you want to take their order? (y/n)\n> ");
          String answer = console.readLine();

          if (answer.equals("y")) {
            baker.f = new Flour();
            Random random = new Random();

            int price = random.nextInt(5);

            System.out.println(price);

            Customer c = customers[(int) (random.nextDouble(customers.length))];
            baker.takeOrder(price, c);

            double happiness = c.getHappiness();

            console.println("The customer named " + c.getName() + " has a happiness of " + happiness);

            baker.learn(price);
            console.println("Your baker's skill is now: " + baker.skill + "!");
          } else {
            console.println("You let the customer walk away...");
            console.println("Because the customer left you got fired from " + bakery.getName() + "!");
            break;
          }
        }

        continue;
      }

      console.println("Unknown command, type 'cmds' for commands.");
    }

    console.close();
  }
}
