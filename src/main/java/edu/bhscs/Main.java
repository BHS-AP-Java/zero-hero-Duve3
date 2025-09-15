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

import java.util.Scanner;
import java.util.Random;

class Main {

  private static final char A = 'a';

  private static final String[] WORDS = {"LEVEL", "ABCDE", "RIVER"};

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

  private static void QuestionableWordleCopy() {
    Scanner User = new Scanner(System.in);
    Random Rand = new Random();

    String SOLUTION = WORDS[Rand.nextInt(WORDS.length)];

    System.out.println("Welcome to wordle!");

    System.out.print("Enter a 5 letter word:\n> ");
    String ans = User.nextLine().toUpperCase();

    int guesses = 0;

    while (true) {
      while (ans.length() != 5) {
        System.out.print("not 5 characters!!!\nEnter new ans:\n> ");
        ans = User.nextLine().toUpperCase();
      }
      guesses += 1;

      if (ans.equals(SOLUTION)) {
        System.out.println("you got this right");
        break;
      };
      System.out.println("Nah bro yr wrong, good luck!");

      if (guesses >= 5) {
        User.close();
        System.out.println("You took too many guesses!!!\nThe answer was: " + SOLUTION + "\n\nEnd game!");
        return;
      }

      System.out.print("Guesses Used: " + guesses + "/5\n\nEnter new ans:\n> ");
      ans = User.nextLine().toUpperCase();
    }

    System.out.println("wait you guessed it good job!");

    User.close();
  }
}
