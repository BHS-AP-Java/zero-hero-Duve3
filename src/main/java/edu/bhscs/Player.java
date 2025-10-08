package edu.bhscs;

public class Player extends Person {
  // -- properities and fields --
  int accomplishments;

  // -- constructor --
  public Player(String name) {
    super(name);
  }

  // -- methods --
  public String giveAnswer(String question) {
    Console c = Console.getInstance();

    c.print(question + "\n> ");
    return c.readLine();
  }

  public void accomplish(int amount) {
    this.accomplishments += amount;
  }
}
