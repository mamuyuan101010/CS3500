package assigment4.controller.commands;

import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

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
  public void apply(List<Layer> layers) throws IllegalStateException {
    int height = this.getInt();
    int width = this.getInt();
    Pixel pixel = new SimplePixel(255, 255, 255);
    ImageModel imageModel = new SimpleImageModel(255, height, width,
            new Pixel[height][width]);
    for (int i = 0; i < height; i++) {
      for (int j = 0; j < width; j++) {
        imageModel.set(i, j, pixel);
      }
    }
    ImageWithCoordModel imageModelCoord =
            new SimpleImageWithCoordModel(new Coordinate(0,0), imageModel);
    HashMap<String, ImageWithCoordModel> background = new HashMap();
    background.put("background", imageModelCoord);
    Layer outPutLayer = new SimpleLayer(Filter.Normal, background, "background");
    layers.add(outPutLayer);
  }
}
