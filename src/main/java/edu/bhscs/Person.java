package edu.bhscs;

public class Person {
  private String name;
  private int age;
  public Person(String name, int age) {
    this.name = name;
    this.age = age;
  }

  public void setAge(int age) {
    if (age < 1 || age > 100) {
      System.err.println("Age cannot be less than one or greater than 100!");
      return;
    }

    this.age = age;
  }

  public int getAge() {
    return this.age;
  }

  public void setName(String name) {
    System.out.println("no i cant forget my name");
  }

  public String getName() {
    return this.name;
  }
}
