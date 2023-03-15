package assigment4.controller.commands;

import java.util.Map;
import java.util.Scanner;

import assigment4.model.image.ImageModel;

public class AddLayerCommand extends AbstractCommand{

  public AddLayerCommand(Scanner s) {
    super(s);
  }

  @Override
  public void apply(Map<String, ImageModel> images) throws IllegalStateException {
    String layerName = this.getString();


  }
}
