package assigment4.model.layer;
import java.util.HashMap;
import java.util.Map;

import assigment4.model.coord.Coordinate;
import assigment4.model.filter.Filter;
import assigment4.model.image.ImageModel;
import assigment4.model.imageWithCoord.ImageWithCoordModel;

public class SimpleLayer implements Layer{

  private Filter filter;
  private Map<String, ImageWithCoordModel> images;
  private String name;
  private int height;
  private int width;
  public SimpleLayer(Filter filter, Map<String, ImageWithCoordModel> images, String name) {
    this.filter = filter;
    this.images = images;
    this.name = name;
  }

  @Override
  public Filter getFilter() {
    return this.filter;
  }

  @Override
  public Map<String, ImageWithCoordModel> getImages() {
    Map<String, ImageWithCoordModel> output
            = new HashMap<String, ImageWithCoordModel>();
    for (Map.Entry<String, ImageWithCoordModel> entry: this.images.entrySet()) {
      output.put(entry.getKey(), entry.getValue());
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
