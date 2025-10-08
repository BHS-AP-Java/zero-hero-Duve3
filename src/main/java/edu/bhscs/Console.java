// Dhruv Hooda
// P2
// Zero Hero
// 9/29/25

/*
 * DESCRIPTION: A console that abstracts away the println and scanner
 * INPUT: any user input via scanner
 * OUTPUT: any console output via system.out
 * EDGE CASE: not really edge case but often the console can stop output (via allowOutput) then breaks without error
 */

package edu.bhscs;

import java.util.Scanner;

public class Console {
  // -- fields and props --
  private static final Scanner scanner = new Scanner(System.in);

  private static Console single_instance = null;
  private static boolean allow_output = true;

  // -- constructor -- but notice how its private, only can be initalized
  // by the class itself!
  private Console() {
    System.out.println("Console initialized");
  }

  // -- methods -- 
  /**
   * Get the singleton instance of the Console
   *
   * <p>The keyword synchronized here prevents it being called from other threads, this prevents a
   * situation where single_instance is written to multiple times
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
