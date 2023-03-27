package assignment4.controller.commands;

import java.util.Map;
import java.util.Scanner;

import assignment4.model.image.ImageModel;
import assignment4.model.image.SimpleLayerModel;
import assignment4.model.project.ProjectModel;

/**
 * set filter command class, setting the filter to the layer that the client input
 */
public class SetFilterCommand extends AbstractCommand{
  /**
   * Constructor of set filter command class
   */
  public SetFilterCommand(Scanner sc) {
    super(sc);
  }

  /**
   * execute the command to the given project model
   * intake the type of filter and the layer the client input,
   * and set the filter on the specific layer to the one that the client want.
   * @param projectModel a models for the command to work on.
   * @throws IllegalStateException
   */
  @Override
  public void apply(ProjectModel projectModel) throws IllegalStateException {
    String layerName = this.getString();
    String filterOption = this.getString();
    ImageModel imageModel = null;
    for (Map.Entry<String, ImageModel> entry : projectModel.getProjectStructure().entrySet()) {
      if (entry.getKey().equals(layerName)) {
        imageModel = entry.getValue();

      }
    }
    if (imageModel == null) {
      throw new IllegalStateException("The layer you typed in does not exist");
    } else {
      imageModel.setFilter(filterOption);
    }
  }
}
