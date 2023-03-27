package assignment4.controller.commands;

import java.util.Scanner;

import assignment4.model.image.ImageModel;
import assignment4.model.image.SimpleImageModel;
import assignment4.model.pixel.Pixel;
import assignment4.model.pixel.SimplePixel;
import assignment4.model.project.ProjectModel;

/**
 * new project command class that start a new project with one default layer.
 */
public class NewProjectCommand extends AbstractCommand{

  /**
   * new-project-command constructor
   * @param s is the scanner that scan the input
   */
  public NewProjectCommand(Scanner s) {
    super(s);
  }

  @Override
  public void apply(ProjectModel projectModel) throws IllegalStateException {
    int height = this.getInt();
    int width = this.getInt();
    Pixel pixel = new SimplePixel(255, 255, 255);
    ImageModel canvas = new SimpleImageModel(255, height, width,
            new Pixel[height][width], "image");
    for (int i = 0; i < height; i++) {
      for (int j = 0; j < width; j++) {
        canvas.set(i, j, pixel);
      }
    }
    projectModel.setHeight(height);
    projectModel.setWidth(width);
    projectModel.setMaxValue(255);
    projectModel.put("canvas", canvas);

  }
}
