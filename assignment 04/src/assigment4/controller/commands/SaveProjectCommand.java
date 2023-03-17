package assigment4.controller.commands;

import java.util.List;
import java.util.Scanner;

import assigment4.model.collagerProject.CollagerProject;
import assigment4.model.layer.Layer;

public class SaveProjectCommand extends AbstractCommand{
  /**
   * Constructs an Abstract command.
   *
   * @param sc
   */
  public SaveProjectCommand(Scanner sc) {
    super(sc);
  }

  @Override
  public void apply(CollagerProject c) throws IllegalStateException {

  }
}
