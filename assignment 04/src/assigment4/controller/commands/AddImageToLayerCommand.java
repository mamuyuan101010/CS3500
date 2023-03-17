package assigment4.controller.commands;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

import assigment4.model.collagerProject.CollagerProject;
import assigment4.model.coord.Coordinate;
import assigment4.model.image.SimpleImageModel;
import assigment4.model.imageWithCoord.SimpleImageWithCoordModel;
import assigment4.model.layer.Layer;
import assigment4.model.pixel.Pixel;
import assigment4.model.pixel.SimplePixel;

/**
 * Creates a new project with the given name and given dimensions. Every project has a white
 * background layer by default.
 */
public class AddImageToLayerCommand extends AbstractCommand {
  public AddImageToLayerCommand(Scanner sc) {
    super(sc);
  }

  @Override
  public void apply(CollagerProject c) throws IllegalStateException {
    Scanner sc;
    String layername = this.getString();
    String filename;
    int imageX;
    int imageY;
    int locationOfLayer = -1;
    int index = 0;
    for (Layer l : c.getLayers()) {
      if (l.getLayerName().equals(layername)) {
        locationOfLayer = index;
        break;
      } else {
        index++;
      }
    }
    if (locationOfLayer == -1) {
      throw new IllegalStateException("Layer not found");
    } else {
      filename = this.getString();
      imageX = this.getInt();
      imageY = this.getInt();
      try {
        sc = new Scanner(new FileInputStream(filename));
      } catch (FileNotFoundException e) {
        throw new IllegalStateException("File " + filename + " not found!");
      }
      StringBuilder builder = new StringBuilder();
      //read the file line by line, and populate a string. This will throw away any comment lines
      while (sc.hasNextLine()) {
        String s = sc.nextLine();
        if (s.charAt(0)!='#') {
          builder.append(s+System.lineSeparator());
        }
      }
      sc = new Scanner(builder.toString());
      String token;
      token = sc.next();
      if (!token.equals("P3")) {
        System.out.println("Invalid PPM file: plain RAW file should begin with P3");
      }
      int width = sc.nextInt();
      int height = sc.nextInt();
      int maxValue = sc.nextInt();
      Pixel[][] image = new Pixel[height][width];
      for (int i=0;i<height;i++) {
        for (int j=0;j<width;j++) {
          int r = sc.nextInt();
          int g = sc.nextInt();
          int b = sc.nextInt();
          image[i][j] = new SimplePixel(r, g, b, 255);
        }
      }
      c.getLayers().get(locationOfLayer).getImages()
              .add(new SimpleImageWithCoordModel(new Coordinate(imageX, imageY),
                      new SimpleImageModel(maxValue, height, width, image)));
    }
  }
}
