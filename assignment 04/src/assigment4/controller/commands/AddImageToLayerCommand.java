package assigment4.controller.commands;

import java.util.Map;
import java.util.Scanner;

import assigment4.model.image.ImageModel;

/**
 * Creates a new project with the given name and given dimensions. Every project has a white
 * background layer by default.
 */
public class AddImageToLayerCommand extends AbstractCommand {
  public AddImageToLayerCommand(Scanner sc) {
    super(sc);
  }

  @Override
  public void apply(Map<String, ImageModel> images) throws IllegalStateException {

  }

  @Override
  public String help() {
    return null;
  }
}
