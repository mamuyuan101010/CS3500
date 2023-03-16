package assigment4.controller.commands;

import java.util.Map;
import java.util.Scanner;
import assigment4.model.image.ImageModel;

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
  public void apply(Map<String, ImageModel> images) throws IllegalStateException {

  }
}
