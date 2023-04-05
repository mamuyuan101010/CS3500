package assignment4.model.new_filter;

import assignment4.model.image.ImageModel;

public interface New_filter {
  String getName();
  ImageModel filtering(ImageModel currentLayer, ImageModel layerBelow);

}
