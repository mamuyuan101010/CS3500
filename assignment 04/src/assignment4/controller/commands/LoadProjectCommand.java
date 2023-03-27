package assignment4.controller.commands;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Scanner;

import assignment4.model.filter.NormalFilter;
import assignment4.model.image.ImageModel;
import assignment4.model.image.SimpleLayerModel;
import assignment4.model.pixel.Pixel;
import assignment4.model.pixel.SimplePixel;
import assignment4.model.project.ProjectModel;
import assignment4.model.project.SimpleProjectModel;

public class LoadProjectCommand extends AbstractCommand {

  /**
   * load the project text file to the current java program
   *
   * @param sc is the scanner that scan the input
   */
  public LoadProjectCommand(Scanner sc) {
    super(sc);
  }


  /**
   * read the ppmFile that named in the given String.
   *
   * @param filename is the name of the file.
   */
  private ProjectModel readProject(String filename) {
    Scanner sc;

    try {
      sc = new Scanner(new FileInputStream(filename));
    } catch (FileNotFoundException e) {
      throw new IllegalStateException("File " + filename + " not found!");

    }
    StringBuilder builder = new StringBuilder();
    //read the file line by line, and populate a string. This will throw away any comment lines
    while (sc.hasNextLine()) {
      String s = sc.nextLine();
      if (s.charAt(0) != '#') {
        builder.append(s + System.lineSeparator());
      }
    }

    //now set up the scanner to read from the string we just built
    sc = new Scanner(builder.toString());

    String token;

    token = sc.next();
    if (!token.equals("C1")) {
      throw new IllegalStateException("Invalid project file: plain RAW file should begin with C1");
    }
    int width = sc.nextInt();
    int height = sc.nextInt();
    int maxValue = sc.nextInt();

    ProjectModel output =
            new SimpleProjectModel(height, width, maxValue, "new project");
    while (sc.hasNext()) {
      String layerName = sc.next();
      String filterName = sc.next();
      ImageModel layer = new SimpleLayerModel(maxValue, height, width,
              new Pixel[height][width], "layer", layerName, new NormalFilter());
      layer.setFilter(filterName);
      for (int i = 0; i < height; i++) {
        for (int j = 0; j < width; j++) {
          int r = sc.nextInt();
          int g = sc.nextInt();
          int b = sc.nextInt();
          int a = sc.nextInt();
          layer.set(i, j, new SimplePixel(r, g, b, a));
        }
      }
      output.put(layerName, layer);
    }
    return output;
  }

  /**
   * execute the command, read the project file.
   *
   * @param projectModel a models for the command to work on.
   * @throws IllegalStateException when the file is not found
   */
  @Override
  public void apply(ProjectModel projectModel) throws IllegalStateException {
    String projectName = this.getString();
    ProjectModel out = this.readProject(projectName);
    projectModel.setHeight(out.getHeight());
    projectModel.setWidth(out.getWidth());
    projectModel.setMaxValue(out.getMaxValue());
    for (Map.Entry<String, ImageModel> entry : out.getProjectStructure().entrySet()) {
      projectModel.put(entry.getKey(), entry.getValue());
    }
  }
}
