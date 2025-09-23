package edu.bhscs;

public class Person {
  private String name; // Person name
  private int age; // Person age
  private Item[] inventory; // Inventory array to hold items
  private int selectedSlot = 0; // Index of the currently selected inventory slot

  public Person(String name, int age) {
    this.name = name;
    this.age = age;
    this.inventory = new Item[9]; // our array is fixed size of 9, representing our "hotbar"
  }

  public String getName() {
    return name;
  }

  public void recieveItem(Item item) {
    System.out.println(this.name + " got a " + item.getName() + "!");
    inventory[selectedSlot] = item;
  }

  public void selectSlot(int slot) {
    if (slot >= 0 && slot < inventory.length) {
      selectedSlot = slot;
      System.out.println(this.name + " selected slot " + selectedSlot);
    } else {
      System.out.println("Invalid slot selected.");
    }
  }

  public Item getHeldItem() {
    return inventory[selectedSlot];
  }

  public int getAge() {
    return age;
  }
}
