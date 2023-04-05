package assignment4.model.new_filter;

import assignment4.model.image.ImageModel;

/**
 * newFilter interface.
 */
public interface New_filter {
  /**
   * return the name of the filter
   */
  String getName();

  /**
   * filtering the two image.
   */
  ImageModel filtering(ImageModel currentLayer, ImageModel layerBelow);

}
