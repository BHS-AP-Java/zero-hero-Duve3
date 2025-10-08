package edu.bhscs;

public class Player extends Person {

  int accomplishments;

  public Player(String name) {
    super(name);
  }

  public String giveAnswer(String question) {
    Console c = Console.getInstance();

    c.print(question + "\n> ");
    return c.readLine();
  }

  public void accomplish(int amount) {
    this.accomplishments += amount;
  }
}
