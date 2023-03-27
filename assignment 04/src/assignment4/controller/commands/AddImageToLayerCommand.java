package assignment4.controller.commands;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

import assignment4.model.image.ImageModel;
import assignment4.model.image.SimpleImageModel;
import assignment4.model.pixel.Pixel;
import assignment4.model.pixel.SimplePixel;
import assignment4.model.project.ProjectModel;

/**
 * Creates a new project with the given name and given dimensions. Every project has a white
 * background layer by default.
 * It uses an image model as an instance variable
 */
public class AddImageToLayerCommand extends AbstractCommand {

  private ImageModel imageModel;

  /**
   * constructor of AddImageToLayerCommand
   * @param sc
   */
  public AddImageToLayerCommand(Scanner sc) {
    super(sc);
  }


  /**
   * read the ppmFile that named in the given String.
   * @param filename is the name of the file.
   */
  private void readPPM(String filename) {
    Scanner sc;

    try {
      sc = new Scanner(new FileInputStream(filename));
    }
    catch (FileNotFoundException e) {
      throw new IllegalStateException("File "+filename+ " not found!");

    }
    StringBuilder builder = new StringBuilder();
    //read the file line by line, and populate a string. This will throw away any comment lines
    while (sc.hasNextLine()) {
      String s = sc.nextLine();
      if (s.charAt(0)!='#') {
        builder.append(s+System.lineSeparator());
      }
    }

    //now set up the scanner to read from the string we just built
    sc = new Scanner(builder.toString());

    String token;

    token = sc.next();
    if (!token.equals("P3")) {
      throw new IllegalStateException("Invalid PPM file: plain RAW file should begin with P3");
    }
    int width = sc.nextInt();
    int height = sc.nextInt();
    int maxValue = sc.nextInt();

    imageModel = new SimpleImageModel(maxValue, height, width, new Pixel[height][width],
            "image");
    for (int i=0;i<height;i++) {
      for (int j=0;j<width;j++) {
        int r = sc.nextInt();
        int g = sc.nextInt();
        int b = sc.nextInt();
        imageModel.set(i, j, new SimplePixel(r, g, b));
      }
    }
  }


  /**
   * apply method execute the command, add the given image to the project.
   * @param projectModel
   * @throws IllegalStateException
   */
  @Override
  public void apply(ProjectModel projectModel) throws IllegalStateException {
    String layerName = this.getString();
    String fileName = this.getString();
    int x = this.getInt();
    int y = this.getInt();
    this.readPPM(fileName);
    ImageModel layer = projectModel.getProjectStructure().get(layerName);
    if (layer == null) {
      throw new IllegalStateException("The layer that you are aiming does not exist.");
    } else {
      for (int i = y; i < this.imageModel.getHeight() + y; i++) {
        for (int j = x; j < this.imageModel.getWidth() + x; j++) {
          layer.getFilter().filtering(imageModel, i - y, j - x);
          layer.set(i, j, imageModel.get(i - y, j - x));
        }
      }
    }
  }
}
