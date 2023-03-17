package assigment4.controller.commands;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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

public class AddLayerCommand extends AbstractCommand{

  public AddLayerCommand(Scanner s) {
    super(s);
  }

  @Override
  public void apply(CollagerProject c) throws IllegalStateException {
    String layerName = this.getString();
    List<String> nameSort = new ArrayList<String>();
    for (Layer l:c.getLayers()) {
      nameSort.add(l.getLayerName());
    }
    boolean sameName = false;
    for (int i = 0; i < nameSort.size(); i ++) {
      sameName = sameName || (nameSort.get(i) == layerName);
    }
    if (sameName) {
      throw new IllegalArgumentException("duplicate names for layers");
    }
    Pixel pixel = new SimplePixel(255, 255, 255, 0);
    Pixel[][] pixels = new Pixel[c.getHeight()][c.getWidth()];
    for (int i = 0; i < c.getHeight(); i++) {
      for (int j = 0; j < c.getWidth(); j++) {
        pixels[i][j] = pixel;
      }
    }
    ImageModel img = new SimpleImageModel(255, c.getHeight(), c.getWidth(), pixels);
    ImageWithCoordModel imgCoord = new SimpleImageWithCoordModel(new Coordinate(0,0), img);
    List m = new ArrayList<ImageWithCoordModel>();
    m.add(imgCoord);
    c.getLayers().add(new SimpleLayer(Filter.Normal, m, layerName, c.getHeight(), c.getWidth()));
  }
}
