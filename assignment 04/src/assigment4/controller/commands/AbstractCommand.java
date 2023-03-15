package assigment4.controller.commands;

import java.util.Scanner;

/**
 * Abstract command that holds common command functions.
 */
public abstract class AbstractCommand implements ImageCommand {

  protected final Scanner sc;
  protected String helpMessage = "A command that may be applied to an ImageModel.";

  /**
   * Constructs an Abstract command.
   */
  protected AbstractCommand(Scanner sc) {
    if (sc == null) {
      throw new IllegalArgumentException("Command scanner is null");
    }
    this.sc = sc;
  }

  @Override
  public String help() {
    return this.helpMessage;
  }

  /**
   * Gets a String input.
   *
   * @return String input.
   */
  protected String getString() {
    if (this.sc.hasNext()) {
      return this.sc.next();
    } else {
      throw new IllegalStateException();
    }
  }

  /**
   * Gets an integer input.
   *
   * @return int input.
   */
  protected int getInt() {
    while (this.sc.hasNext() && !this.sc.hasNextInt()) {
      this.sc.next();
    }
    if (this.sc.hasNextInt()) {
      return this.sc.nextInt();
    } else {
      throw new IllegalStateException();
    }
  }

  /**
   * Gets a double input.
   *
   * @return double input.
   */
  protected double getDouble() {
    while (this.sc.hasNext() && !this.sc.hasNextDouble()) {
      this.sc.next();
    }
    if (this.sc.hasNextDouble()) {
      return this.sc.nextDouble();
    } else {
      throw new IllegalStateException();
    }
  }
}

