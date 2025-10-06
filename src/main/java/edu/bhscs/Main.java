// Dhruv Hooda
// P2
// Zero Hero
// 9/19/25

/*
 * DESCRIPTION: Its a game where you can buy cakes from bakeries to help fund the PTSA!
 * INPUT: You can eat more cake!
 * OUTPUT: You can watch yourself eat cake!!
 * EDGE CASE: Shortage of cakes!
 */

package edu.bhscs;

import edu.bhscs.items.*;
import java.util.Arrays;

class Main {
  private static final PTSA PTSA = new PTSA();

  public static void main(String[] args) {
    // object definition since we have to use a static context
    Store[] stores = createBakeries();

    Console console = Console.getInstance();

    // ensures a clear console!
    console.clear();
    console.println("Welcome to the PTSA funding game!");
    console.println(
        "You will be helping the PTSA fundraise by buying ingredients, making cakes, and eating them!");

    // difficulty selection
    console.print(
        "What do you want the game difficulty to be? (1-3, 1 being hardest, 3 being easiest)\n> ");
    int difficulty = console.readInt();
    console.readLine(); // to throw out the "\n" that wasn't consumed in the readInt call
    // ^ odd way of doing it i think but it works..? (without it, it automatically skips the next
    // readLine call)

    if (difficulty < 1 || difficulty > 3) {
      console.println("Invalid difficulty, setting to 2 (medium)");
      difficulty = 2;
    }

    console.allowOutput(false);
    PTSA.giveMoney(new Money(67.41 * difficulty)); // gives the PTSA money based on difficulty
    console.allowOutput(true);

    console.println(
        "The PTSA currently has $"
            + PTSA.getMoney()
            + " to give you to start off with! (based off of difficulty!)");

    console.print("What is your name?\n> ");
    String name = console.readLine();
    Person person = new Person(name);

    console.println("Hello " + person.getName() + "!");
    console.println("(pssssst, you should go to the ptsa!)");

    // WARN: we should probably use a switch statement...
    while (true) {
      // actual game loop, our code loops through here and asks for "commands" that the user inputs
      // and these commands do stuff!
      console.print(
          "Where would you like to go? (type 'cmds' for commands) (type 'exit'/'e' to quit)\n> ");
      String input = console.readLine();
      String[] cmds = input.split(" ");

      if (cmds[0].equals("exit") || cmds[0].equals("e")) {
        console.println("Thanks for playing my game!");
        break;
      }

      if (cmds[0].equals("cmds")) {
        console.println("Commands:");
        console.println("- cmds: show this message");
        console.println("- exit/e: exit the program");
        console.println("- inv/i: show your inventory");
        console.println("- stores/s: show all available stores");
        console.println("- go [store name]: go to a store");
        console.println("- clear/c: clear the terminal");
        continue;
      }

      if (cmds[0].equals("inv") || cmds[0].equals("i")) {
        // lists all items in the inventory (lists empty for empty slots)
        console.println(person.getName() + "'s Inventory: (9 slots)");
        person.ListInventory();
        continue;
      }

      if (cmds[0].equals("stores") || cmds[0].equals("s")) {
        // lists all stores
        console.println("Available stores:");
        for (Store store : stores) {
          console.println("- " + store.getName() + ": " + store.getDescription());
        }
        continue;
      }

      if (cmds[0].equals("go")) {
        // we want to "enter" a store
        if (cmds.length < 2) {
          console.println("Please specify a store name.");
          continue;
        }

        String storeName =
            String.join(
                " ",
                Arrays.copyOfRange(
                    cmds, 1, cmds.length)); // combine all args after "go" into one string
        Store selectedStore = null;
        for (Store store : stores) {
          if (store.getName().equalsIgnoreCase(storeName)) {
            selectedStore = store;
            break;
          }
        }

        if (selectedStore == null) {
          console.println("Store not found.");
          continue;
        }

        // we have a valid store, "enter" it
        EnterStore(selectedStore, person);
        continue;
      }

      // just clears the terminal for convience
      if (cmds[0].equals("clear") || cmds[0].equals("c")) {
        console.clear();
        continue;
      }

      console.println("Unknown command. Type 'cmds' for a list of commands.");
    }

    console.close();
  }

  /**
   * "Enters" a store by printing its inventory and allowing purchasing items. Automatically goes to
   * other enter functions if the store is a bakery or the PTSA.
   *
   * @param store the store to enter
   */
  public static void EnterStore(Store store, Person person) {
    if (store instanceof Bakery) {
      EnterBakery((Bakery) store, person);
      return;
    } else if (store instanceof PTSA) {
      EnterPTSA(person);
      return;
    }

    Console console = Console.getInstance();

    console.println("You have entered " + store.getName() + ": " + store.getDescription());
    console.println("Store Inventory:");
    Item[] storeInventory = store.getInventory();
    ListInventory(storeInventory);

    // ANOTHER input loop, yes you heard that right!!
    while (true) {
      console.print(
          "What would you like to do? (type 'cmds' for commands, 'exit'/'e' to leave the store)\n> ");
      String input = console.readLine();
      String[] cmds = input.split(" ");

      if (cmds[0].equals("exit") || cmds[0].equals("e")) {
        console.println("You have exited `" + store.getName() + "`.");
        break;
      }

      if (cmds[0].equals("cmds")) {
        console.println("Store Commands:");
        console.println("- cmds: show this message");
        console.println("- exit/e: exit the store");
        console.println("- inv/i: show your inventory");
        console.println("- buy [item name]: buy an item from the store");
        console.println("- store/s: show the store's inventory");
        console.println("- clear/c: clear the terminal");
        continue;
      }

      if (cmds[0].equals("inv") || cmds[0].equals("i")) {
        // lists all items in the inventory (lists empty for empty slots)
        console.println("Your Inventory: (9 slots)");
        person.ListInventory();
        continue;
      }

      if (cmds[0].equals("store") || cmds[0].equals("s")) {
        // lists all items in the store
        console.println(store.getName() + "'s Inventory:");
        Item[] inventory = store.getInventory();
        ListInventory(inventory);
        continue;
      }

      if (cmds[0].equals("buy")) {
        // we want to buy an item
        if (cmds.length < 2) {
          console.println("Please specify an item name.");
          continue;
        }

        // searches for the item in the store inventory
        String itemName =
            String.join(
                " ",
                Arrays.copyOfRange(
                    cmds, 1, cmds.length)); // combine all args after "buy" into one string
        Item selectedItem = null;
        for (Item item : storeInventory) {
          if (item != null && item.getName().equalsIgnoreCase(itemName)) {
            selectedItem = item;
            break;
          }
        }

        if (selectedItem == null) {
          console.println("Item not found.");
          continue;
        }

        // searches for money
        Money money = person.getMoney();

        // checks if either we have no money, or if we don't have enough money
        if (money == null || money.value < ((Sellable) selectedItem).price) {
          console.println(
              "You do not have enough money to buy a "
                  + selectedItem.getName()
                  + " (Cost: $"
                  + ((Sellable) selectedItem).price
                  + ", Your money: $"
                  + (money != null ? money.value : 0)
                  + ")");
          continue;
        }

        money.value -= ((Sellable) selectedItem).price;
        // we have a valid item, "buy" it WARN: questionable purchase method... (gotta do some crazy
        // init stuff to make ts work well)
        selectedItem.amount -= 1;

        Sellable clone = ((Sellable) selectedItem).deepClone((Sellable) selectedItem);
        clone.amount = 1;
        person.giveItem(clone, true);

        console.println(
            "You have bought a " + selectedItem.getName() + " from " + store.getName() + "!");

        console.allowOutput(false);
        PTSA.giveMoney(new Money(((Sellable) selectedItem).price));
        console.allowOutput(true);

        console.println(
            "The PTSA has received $"
                + ((Sellable) selectedItem).price
                + " from your purchase to help fund school activities!");
        console.println("The PTSA now has $" + PTSA.getMoney() + "!");
        continue;
      }

      // just clears the terminal for convience
      if (cmds[0].equals("clear") || cmds[0].equals("c")) {
        console.clear();
        continue;
      }

      console.println("Unknown command. Type 'cmds' for a list of commands.");
    }
  }

  /**
   * Like {EnterStore} but for bakeries!
   *
   * @param bakery The bakery to enter
   * @param person The player
   */
  public static void EnterBakery(Bakery bakery, Person person) {
    Console console = Console.getInstance();

    console.println("You have entered " + bakery.getName() + ": " + bakery.getDescription());
    console.println("bakery Inventory:");
    Item[] storeInventory = bakery.getInventory();
    ListInventory(storeInventory);

    // ANOTHER input loop, yes you heard that right!!
    while (true) {
      console.print(
          "What would you like to do? (type 'cmds' for commands, 'exit'/'e' to leave the bakery)\n> ");
      String input = console.readLine();
      String[] cmds = input.split(" ");

      if (cmds[0].equals("exit") || cmds[0].equals("e")) {
        console.println("You have exited `" + bakery.getName() + "`.");
        break;
      }

      if (cmds[0].equals("cmds")) {
        console.println("Bakery Commands:");
        console.println("- cmds: show this message");
        console.println("- exit/e: exit the bakery");
        console.println("- inv/i: show your inventory");
        console.println("- bake [ingredients]: bake a cake (if you have the ingredients)");
        continue;
      }

      if (cmds[0].equals("inv") || cmds[0].equals("i")) {
        // lists all items in the inventory (lists empty for empty slots)
        console.println("Your Inventory: (9 slots)");
        person.ListInventory();
        continue;
      }

      if (cmds[0].equals("bake")) {
        // bakes a cake
        if (cmds.length < 2) {
          console.println("Please specify a cake name.");
          continue;
        }

        // gets the ingredients that are asked for in the command (QUITE INEFFICIENT!!)
        Sellable[] ingredients = new Sellable[cmds.length - 1];
        for (int i = 1; i < cmds.length; i++) {
          String ingredientName = cmds[i];
          Sellable ingredient = null;
          for (Item item : person.getInventory()) {
            if (item != null
                && item.getName().equalsIgnoreCase(ingredientName)
                && item instanceof Sellable) {
              // we have found our ingredient, leave the list!
              ingredient = (Sellable) item;
              break;
            }
          }

          // sets it to our array
          ingredients[i - 1] = ingredient;
        }

        // Check if we have all the ingredients
        boolean hasAllIngredients = true;
        // iterates backwards for efficiency since the missing ingredients would be at the end of
        // the array!!
        for (int i = ingredients.length - 1; i >= 0; i--) {
          if (ingredients[i] == null) {
            hasAllIngredients = false;
            break;
          }
        }

        if (!hasAllIngredients) {
          console.println("You do not have all the ingredients you tried using!");
          continue;
        }

        // we have all the ingredients, remove them from the inventory
        for (Sellable ingredient : ingredients) {
          for (int i = 0; i < person.getInventory().length; i++) {
            if (person.getInventory()[i] == ingredient) {
              person.getInventory()[i] = null; // remove the ingredient
              break;
            }
          }
        }

        // create the cake
        Cake cake = bakery.bake(ingredients);
        console.println(
            "You have created a " + cake.getName() + " (Quality: " + cake.quality + ")!");

        person.giveItem(cake);
        continue;
      }

      if (cmds[0].equals("buy")) {
        // we want to buy an item
        if (cmds.length < 2) {
          console.println("Please specify an item name.");
          continue;
        }

        // searches for the item in the store inventory
        String itemName =
            String.join(
                " ",
                Arrays.copyOfRange(
                    cmds, 1, cmds.length)); // combine all args after "buy" into one string
        Item selectedItem = null;
        for (Item item : storeInventory) {
          if (item != null && item.getName().equalsIgnoreCase(itemName)) {
            selectedItem = item;
            break;
          }
        }

        if (selectedItem == null) {
          console.println("Item not found.");
          continue;
        }

        // searches for money
        Money money = person.getMoney();

        // checks if either we have no money, or if we don't have enough money
        if (money == null || money.value < ((Sellable) selectedItem).price) {
          console.println(
              "You do not have enough money to buy a "
                  + selectedItem.getName()
                  + " (Cost: $"
                  + ((Sellable) selectedItem).price
                  + ", Your money: $"
                  + (money != null ? money.value : 0)
                  + ")");
          continue;
        }

        money.value -= ((Sellable) selectedItem).price;
        int prevAmt = selectedItem.amount;
        // we have a valid item, "buy" it WARN: questionable purchase method... (gotta do some crazy
        // init stuff to make ts work well)
        selectedItem.amount = 1;
        person.giveItem(selectedItem);
        selectedItem.amount = prevAmt;

        console.println(
            "You have bought a " + selectedItem.getName() + " from " + bakery.getName() + "!");

        console.allowOutput(false);
        PTSA.giveMoney(new Money(((Sellable) selectedItem).price));
        console.allowOutput(true);

        console.println(
            "The PTSA has received $"
                + ((Sellable) selectedItem).price
                + " from your purchase to help fund school activities!");
        console.println("The PTSA now has $" + PTSA.getMoney() + "!");
        continue;
      }

      console.println("Unknown command. Type 'cmds' for a list of commands.");
    }
  }

  /**
   * Enter the PTSA
   *
   * @param person the player
   */
  public static void EnterPTSA(Person person) {
    Console console = Console.getInstance();

    console.println("Welcome to the PTSA.");
    console.println("We have money and want to give it to you.");
    console.println("But you gotta make us rich afterwards okay?");

    console.print("Do you accept the PTSA's offer? (y/n)\n> ");
    String input = console.readLine();

    if (input.equalsIgnoreCase("y")) {
      console.println("You have accepted the PTSA's offer.");
      console.println("You will now receive all the money the PTSA has currently.");

      PTSA.giveHonoredOne(person);
    } else {
      console.println("You have declined the PTSA's offer.");
      console.println(
          "You cannot play the game without accepting the PTSA's offer (you supa broke man, you NEED the PTSA).");
      console.println("Exiting...");
      System.exit(0);
    }
  }

  /**
   * prints the inventory of the provided inventory[]
   *
   * @param inventory the inventory array to print
   */
  public static void ListInventory(Item[] inventory) {
    Console console = Console.getInstance();
    for (Item item : inventory) {
      if (item != null) {
        // if its cake, lets do a different print that allows more features
        if (item instanceof Cake) {
          console.println(
              "- "
                  + item.amount
                  + "x of "
                  + item.getName()
                  + " (Quality: "
                  + ((Cake) item).quality
                  + ")");
          continue;
        }
        // otherwise just print it normally!
        console.println("- " + item.amount + "x of " + item.getName());
      } else {
        // otherwise we print nun (you got nun!)!
      }
    }
  }

  /**
   * Creates all the bakeries with bakers and returns them as an array.
   *
   * @return Store[] the array of bakeries
   */
  public static Store[] createBakeries() {
    // create a bakery
    Bakery bakery1 = new Bakery("Cool Bakery", "A place that sells *cool* cakes", new Baker("Bob"));

    Store store =
        new Store("Ingredients store", "A place that sells ingredients (eggs, and flour)");
    Store store2 =
        new Store(
            "Another Ingredients store", "A place that sells ingredients (sugar, and butter)");

    // items
    Flour flour = new Flour();
    Egg egg = new Egg();
    Sugar sugar = new Sugar();
    Butter butter = new Butter();

    // setting amounts to "infinite"
    egg.amount = Integer.MAX_VALUE;
    flour.amount = Integer.MAX_VALUE;
    sugar.amount = Integer.MAX_VALUE;
    butter.amount = Integer.MAX_VALUE;

    store.AddItem(flour, 0);
    store.AddItem(egg, 1);
    store2.AddItem(sugar, 0);
    store2.AddItem(butter, 1);

    return new Store[] {bakery1, store, store2, PTSA};
  }
}
