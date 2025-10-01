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

import java.util.Scanner;

public class Console {
  private static final Scanner scanner = new Scanner(System.in);

  private static Console single_instance = null;
  private static boolean allow_output = true;

  private Console() {
    System.out.println("Console initialized");
  }

  /**
   * Get the singleton instance of the Console
   *
   * @return Console
   */
  public static synchronized Console getInstance() {
    if (single_instance == null) single_instance = new Console();

    return single_instance;
  }

  /**
   * Prints a message to the console.
   *
   * @param message the message to print
   */
  public void println(String message) {
    if (!allow_output) return;
    System.out.println(message);
  }

  /**
   * Prints a message to the console without a newline.
   *
   * @param message the message to print
   */
  public void print(String message) {
    if (!allow_output) return;
    System.out.print(message);
  }

  /**
   * Reads a line of input from the console.
   *
   * @return String the line of input
   */
  public String readLine() {
    return scanner.nextLine();
  }

  /**
   * Reads an integer input from the console.
   *
   * @return int the integer input
   */
  public int readInt() {
    return scanner.nextInt();
  }

  /**
   * Reads a double input from the console.
   *
   * @return double the double input
   */
  public double readDouble() {
    return scanner.nextDouble();
  }

  /** Clears the console screen. */
  public void clear() {
    System.out.print("\033[H\033[2J");
    System.out.flush();
  }

  /**
   * Sets whether the console should allow output (disables or enables printing).
   *
   * @param allow true to allow output, false to disable output
   */
  public void allowOutput(boolean allow) {
    allow_output = allow;
  }

  /** Closes the console scanner. */
  public void close() {
    scanner.close();
  }
}
