package assigment4.controller.commands;

import java.util.List;
import java.util.Scanner;

import assigment4.model.layer.Layer;

public class AddLayerCommand extends AbstractCommand{

  public AddLayerCommand(Scanner s) {
    super(s);
  }

  @Override
  public void apply(List<Layer> layers) throws IllegalStateException {
    String layerName = this.getString();
  }
}
