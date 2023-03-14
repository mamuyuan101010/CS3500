package assigment4.controller.commands;

import java.util.Map;
import java.util.Scanner;

import assigment4.model.image.ImageModel;

public class AddLayerCommand extends AbstractCommand{
  /**
   * Constructs an Abstract command.
   *
   * @param sc
   */
  public AddLayerCommand(Scanner sc) {
    super(sc);
  }

  @Override
  public void apply(Map<String, ImageModel> images) throws IllegalStateException {

  }
}
