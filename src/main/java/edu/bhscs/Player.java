package edu.bhscs;

public class Player extends Person {
  public Player(String name) {
    super(name);
  }

  public String giveAnswer(String question) {
    Console c = Console.getInstance();

    c.print(question + "\n> ");
    return c.readLine();
  }
}
