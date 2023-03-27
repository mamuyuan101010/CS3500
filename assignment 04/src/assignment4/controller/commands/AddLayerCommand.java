package assignment4.controller.commands;

import java.util.Scanner;

import assignment4.model.filter.NormalFilter;
import assignment4.model.image.ImageModel;
import assignment4.model.image.SimpleLayerModel;
import assignment4.model.pixel.Pixel;
import assignment4.model.pixel.SimplePixel;
import assignment4.model.project.ProjectModel;

/**
 * addLayerCommand class represent the addLayerCommand,
 * adding a layer to the current project
 */
public class AddLayerCommand extends AbstractCommand{

  /**
   * constructor of addlayer command
   * @param s is a Scanner that scan the input.
   */
  public AddLayerCommand(Scanner s) {
    super(s);
  }

  /**
   * execute the command, add a new layer into the current project.
   * @param projectModel is the given project that is currently edited.
   */
  @Override
  public void apply(ProjectModel projectModel) throws IllegalStateException {
    String layerName = this.getString();
    Pixel pixel = new SimplePixel(255, 255, 255, 0);

    ImageModel layerModel = new SimpleLayerModel(projectModel.getMaxValue(),
            projectModel.getHeight(), projectModel.getWidth(),
            new Pixel[projectModel.getHeight()][projectModel.getWidth()], "layer",
            layerName, new NormalFilter());
    for (int i = 0; i < projectModel.getHeight(); i++) {
      for (int j = 0; j < projectModel.getWidth(); j++) {
        layerModel.set(i, j, pixel);
      }
    }

    projectModel.put(layerName, layerModel);
  }
}
