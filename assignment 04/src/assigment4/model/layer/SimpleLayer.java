package assigment4.model.layer;
import java.util.Map;

import assigment4.model.filter.Filter;
import assigment4.model.image.ImageModel;
import assigment4.model.image.SimpleImageModel;

public class SimpleLayer implements Layer{

  private Filter filter;
  private Map<String, SimpleImageModel> images;
  private String name;
  SimpleLayer(Filter filter, Map<String, SimpleImageModel> images, String name) {
    this.filter = filter;
    this.images = images;
    this.name = name;
  }
}
