package assigment4.model.layer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import assigment4.model.coord.Coordinate;
import assigment4.model.filter.Filter;
import assigment4.model.image.ImageModel;
import assigment4.model.imageWithCoord.ImageWithCoordModel;

public class SimpleLayer implements Layer{

  private Filter filter;
  private List<ImageWithCoordModel> images;
  private String name;
  private int height;
  private int width;
  public SimpleLayer(Filter filter, List<ImageWithCoordModel> images, String name, int height, int width) {
    this.filter = filter;
    this.images = images;
    this.name = name;
    this.height = height;
    this.width = width;
  }

  @Override
  public Filter getFilter() {
    return this.filter;
  }

  @Override
  public void setFilter(Filter filter) {
    this.filter = filter;
  }


  @Override
  public List<ImageWithCoordModel> getImages() {
    List<ImageWithCoordModel> output = new ArrayList<ImageWithCoordModel>();
    for (ImageWithCoordModel img:this.images) {
      output.add(img);
    }
    return output;
  }

  @Override
  public String getLayerName() {
    return this.name;
  }

  public int getHeight() {
    return this.height;
  }

  public int getWidth() {
    return this.width;
  }
}
