// Dhruv H
// P2
// Zero Hero
// 9/12/25

/*
 * DESCRIPTION: mr reiber zero hero + quite questionable wordle copy for fun
 * INPUT: No input unless you get to wordle, then you enter 5 letter words
 * OUTPUT: Stuff in Command line!!
 * EDGE CASE: machines with too little ram will fail due to memory limitations
 */

package edu.bhscs;

import java.util.Random;
import java.util.Scanner;

class Main {

  // reiber constants
  private static final char A = 'a';
  public static final float NAME_OF_THIS_FLOAT = 69.42f;

  // wordle constants
  private static final String[] WORDS = {"LEVEL", "CHART", "RIVER", "CONST", "FLOAT", "CLASS"};
  private static final int MAX_GUESSES = 5;

  public static void main(String[] args) {
    // mr reiber required stuff
    int someNumber = 67;

    String myCoolString = "Yippie!";

    System.out.println("67!" + A + someNumber);
    System.out.print(A + "?" + A + someNumber);
    System.out.print(A + A + someNumber);
    System.out.println("Look at my cool string: " + myCoolString);
    System.out.println("this is neet");
    System.out.println();
    System.out.println();
    System.out.println("ok im done");

    System.out.println("\n\n\nWORDLE TIME!!");
    QuestionableWordleCopy();
  }

  public static int awesome() {
    return 10;
  }

  private static void QuestionableWordleCopy() {
    // sets up user input and our random function
    Scanner User = new Scanner(System.in);
    Random Rand = new Random();

    // picks a random word
    String SOLUTION = WORDS[Rand.nextInt(WORDS.length)];

    System.out.println("Welcome to wordle!");

    // takes in input based on userinput, then upperCases it
    System.out.print("Enter a 5 letter word:\n> ");
    String ans = User.nextLine().toUpperCase();

    int guesses = 0;

    // game loop
    while (true) {
      // keeps looping until the user inputs an answer is less than 5
      while (ans.length() != 5) {
        System.out.print("not 5 characters!!!\nEnter new ans:\n> ");
        ans = User.nextLine().toUpperCase();
      }
      guesses += 1;

      // checks if the ans is equal to solution, if so we leave the loop with break
      if (ans.equals(SOLUTION)) {
        System.out.println("you got this right");
        break;
      }

      // show to the user what part of their guess was right
      String correct = "";

      // works by comparing each char and seeing if any of them are good
      for (var i = 0; i < SOLUTION.length(); i++) {
        char SolutionChar = SOLUTION.charAt(i);
        char AnswerChar = ans.charAt(i);

        if (SolutionChar == AnswerChar) {
          correct += "G"; // 🟩 <- emojis dont work in the terminal yo
        } else {
          correct += "R"; // 🟥
        }
      }

      System.out.println(correct);
      System.out.println("This is what you got correct (no yellows)\nG = Green/Good, R = Red/Wrong");

      // if the user runs out of guesses then we cleanup by closing the scanner and ending the function by returning
      // we use >= just incase it some how overflows beyond MAX_GUESSES
      if (guesses >= MAX_GUESSES) {
        User.close();
        System.out.println(
            "You took too many guesses!!!\nThe answer was: " + SOLUTION + "\n\nEnd game!");
        return;
      }

      // basic TUI
      System.out.print("Guesses Used: " + guesses + "/5\n\nEnter new ans:\n> ");
      ans = User.nextLine().toUpperCase();
    }

    System.out.println("wait you guessed it good job!");


    // scanner cleanup
    User.close();
  }
}
