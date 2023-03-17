package assigment4.controller.commands;

import java.util.List;
import java.util.Scanner;

import assigment4.model.collagerProject.CollagerProject;
import assigment4.model.layer.Layer;

public class AddLayerCommand extends AbstractCommand{

  public AddLayerCommand(Scanner s) {
    super(s);
  }

  @Override
  public void apply(CollagerProject c) throws IllegalStateException {
    String layerName = this.getString();
  }
}
