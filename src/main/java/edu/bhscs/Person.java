package edu.bhscs;

import edu.bhscs.items.*;

public class Person {
  private String name; // Person name
  private Item[] inventory; // Inventory array to hold items
  private int selectedSlot = 0; // Index of the currently selected inventory slot

  public Person(String name) {
    this.name = name;

    this.inventory =
        new Item[9]; // our array is fixed size of 9, representing our "hotbar/inventory"
  }

  /**
   * Gives an item to the person, placing it in the currently selected inventory slot
   *
   * @param item the item to give to the person
   * @param forced if true, will overwrite any existing item in the slot; if false, will only add if
   *     the slot is empty
   */
  public void giveItem(Item item, boolean increment, boolean forced) {
    if (forced || this.inventory[this.selectedSlot] == null) {
      // just putting the item in the slot
      if (item instanceof Money) {
        System.out.println(
            this.name + " recieved $" + ((Money) item).value + " and it was placed in their inventory.");
      }
      System.out.println(this.name + " got a " + item.getName() + "!");
      this.inventory[this.selectedSlot] = item;

    } else if (this.inventory[this.selectedSlot].stack(item)) {
      // stacking was successful
      if (item instanceof Money) {
        System.out.println(
            this.name + " recieved $" + ((Money) item).value + " and it was stacked. New total: $" + ((Money) this.inventory[this.selectedSlot]).value);
      }
      System.out.println(this.name + " recieved a" + item.getName() + " and it was stacked.");

    } else {
      // all attempts failed
      System.out.println(
          this.name + " tried to get a " + item.getName() + " but the slot is occupied.");
    }

    if (increment) {
      nextSlot();
    }
  }

  /**
   * Gives an item to the person, placing it in the currently selected inventory slot, without
   * overwriting existing items.
   *
   * @param item the item to give to the person
   */
  public void giveItem(Item item) {
    giveItem(item, false, false);
  }

  /**
   * Gives an item to the person, placing it in the currently selected inventory slot, and increments the selectedSlot value
   *
   * @param item
   * @param increment
   */
  public void giveItem(Item item, boolean increment) {
    giveItem(item, increment, false);
  }

  /**
   * Sets the current slot of the person's inventory.
   *
   * @param slot the slot to select (0-8)
   * @throws ArrayIndexOutOfBoundsException if the slot is invalid
   */
  public void selectSlot(int slot) throws ArrayIndexOutOfBoundsException {
    if (slot >= 0 && slot < inventory.length) {
      selectedSlot = slot;
    } else {
      throw new ArrayIndexOutOfBoundsException("Invalid slot selected.");
    }
  }

  /**
   * Selects the next slot in the inventory, wrapping around if necessary.
   */
  public void nextSlot() {
    selectSlot(this.selectedSlot + 1 > 8 ? 0 : this.selectedSlot + 1);
  }

  /**
   * Gets the name of the person.
   *
   * @return The name of the person
   */
  public String getName() {
    return this.name;
  }

  /**
   * Gets the item currently held by the person.
   *
   * @return The item in the currently selected inventory slot
   */
  public Item getHeldItem() {
    return this.inventory[this.selectedSlot];
  }

  /**
   * Gets the inventory of the person.
   *
   * @return
   */
  public Item[] getInventory() {
    return this.inventory;
  }
}
