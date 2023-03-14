package assigment4.controller.commands;

import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;

import assigment4.model.image.ImageModel;

/**
 * Command to print info about commands.
 */
public class HelpCommand extends AbstractCommand {

  private final Map<String, Function<Scanner, ImageCommand>> commands;
  private final TerminalPrinter term;
  private final String help = "(None) Prints registered commands and their descriptors.";

  /**
   * Constructs a new help command.
   *
   * @param commands list of commands.
   * @param term     terminal to output the information on.
   */
  public HelpCommand(Map<String, Function<Scanner, ImageCommand>> commands, TerminalPrinter term) {
    super(new Scanner(""));
    if (commands == null || term == null) {
      throw new IllegalArgumentException("Help param is null.");
    }
    this.commands = commands;
    this.term = term;
    this.helpMessage = help;
  }

  @Override
  public void go(Map<String, ImageModel> images) throws IllegalStateException {
    for (String name : this.commands.keySet()) {
      this.term.renderMessage(String.format("'%s': ", name));
      Function<Scanner, ImageCommand> cmd = this.commands.get(name);
      ImageCommand c = cmd.apply(new Scanner(""));
      this.term.renderAsState(c.help());
      this.term.renderAsState("\n");
    }
  }
}
