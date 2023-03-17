package assigment4.controller.commands;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import assigment4.model.collagerProject.CollagerProject;
import assigment4.model.collagerProject.SimpleCollagerProject;
import assigment4.model.coord.Coordinate;
import assigment4.model.filter.Filter;
import assigment4.model.image.ImageModel;
import assigment4.model.image.SimpleImageModel;
import assigment4.model.imageWithCoord.ImageWithCoordModel;
import assigment4.model.imageWithCoord.SimpleImageWithCoordModel;
import assigment4.model.layer.Layer;
import assigment4.model.layer.SimpleLayer;
import assigment4.model.pixel.Pixel;
import assigment4.model.pixel.SimplePixel;

public class LoadProjectCommand extends AbstractCommand{
  public LoadProjectCommand(Scanner sc) {
    super(sc);
  }

  @Override
  public void apply(CollagerProject c) throws IllegalStateException {
    Scanner sc;
    String projectName = this.getString();
    try {
      sc = new Scanner(new FileInputStream(projectName));
    } catch (FileNotFoundException e) {
      throw new IllegalStateException("Project " + projectName + " not found!");
    }
    StringBuilder builder = new StringBuilder();
    while (sc.hasNextLine()) {
      String s = sc.nextLine();
      if (s.charAt(0)!='#') {
        builder.append(s+System.lineSeparator());
      }
    }
    sc = new Scanner(builder.toString());
    String token;
    token = sc.next();
    if (!token.equals("C1")) {
      throw new IllegalStateException("Invalid project file: plain RAW file should begin with C1");
    }
    int width = sc.nextInt();
    int height = sc.nextInt();
    int maxValue = sc.nextInt();
    List<Layer> listOfLayer = new ArrayList<>();

    List<Pixel[][]> listOfImage = new ArrayList<Pixel[][]>();
    while (sc.hasNext()) {
      String layerName = sc.next();
      String filterName = sc.next();
      Pixel[][] image = new Pixel[height][width];
      for (int i = 0; i < height; i++) {
        for (int j = 0; j < width; j++) {
          int r = sc.nextInt();
          int g = sc.nextInt();
          int b = sc.nextInt();
          int a = sc.nextInt();
          image[i][j] = new SimplePixel(r, g, b, a);
        }
      }
      listOfImage.add(image);
    }
    c = new SimpleCollagerProject(listOfLayer, width, height);
  }

}


