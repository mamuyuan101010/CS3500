package assigment4.controller.commands;

import java.util.List;
import java.util.Scanner;
import assigment4.model.layer.Layer;

/**
 * Creates a new project with the given name and given dimensions. Every project has a white
 * background layer by default.
 */
public class AddImageToLayerCommand extends AbstractCommand {
  public AddImageToLayerCommand(Scanner sc) {
    super(sc);
  }

  @Override
  public void apply(List<Layer> layers) throws IllegalStateException {

  }

  @Override
  public String help() {
    return null;
  }
}
