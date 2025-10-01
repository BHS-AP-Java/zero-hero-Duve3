package edu.bhscs;

import edu.bhscs.items.*;

public class Store {
  private String name;
  private String description;
  private Item[] inventory;

  /**
   * A store that can sell items, with a limit of two
   *
   * @param name The name of the store
   * @param description A short description of the store (visually/could be anything)
   */
  public Store(String name, String description) {
    this.name = name;
    this.description = description;

    this.inventory = new Item[2]; // stores can only hold 2 items!
  }

  /**
   * Adds an item to the store's inventory.
   *
   * @param item the item to add, of type Item
   * @param slot the slot to add the item to, or -1 for first available
   * @throws ArrayIndexOutOfBoundsException if the slot is invalid or no available slots
   */
  public void AddItem(Item item, int slot) throws ArrayIndexOutOfBoundsException {
    if (slot == -1) {
      for (int i = 0; i < inventory.length; i++) {
        if (inventory[i] == null) {
          inventory[i] = item;
          return;
        }
      }

      throw new ArrayIndexOutOfBoundsException("No available slots!");
    } else if (slot >= 0 && slot < inventory.length) {
      inventory[slot] = item;
      System.out.println("Added " + item.getName() + " to slot " + slot);

    } else {
      throw new ArrayIndexOutOfBoundsException("Invalid slot. Item not added.");
    }
  }

  /**
   * Gets the name of the store.
   *
   * @return Name of the store
   */
  public String getName() {
    return name;
  }

  /**
   * Gets the description of the store.
   *
   * @return A short description of the store
   */
  public String getDescription() {
    return description;
  }

  /**
   * Returns the inventory of the store.
   *
   * @return Item[] the inventory array
   */
  public Item[] getInventory() {
    return inventory;
  }
}
