package assigment4.controller.commands;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import assigment4.model.collagerProject.CollagerProject;
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

public class NewProjectCommand extends AbstractCommand{

  public NewProjectCommand(Scanner s) {
    super(s);
  }

  /**
   * apply the new-project command to the given layers, make an empty white canvas
   */
  @Override
  public void apply(CollagerProject c) throws IllegalStateException {
    int height = this.getInt();
    int width = this.getInt();
    c.getLayers().add(this.generateEmptyLayer(height, width));
    c.setHeight(height);
    c.setWidth(width);
  }
}
