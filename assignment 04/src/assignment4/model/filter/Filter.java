package assignment4.model.filter;

import assignment4.model.image.ImageModel;

/**
 * the filter interface that represent the overall filters.
 */
public interface Filter {

  /**
   * getname method that return the name of the filter.
   * @return
   */
  public String getName();

  /**
   * filter the pixel of the given layer in the given coordination.
   * @param layer
   * @param row
   * @param col
   */
  void filtering(ImageModel layer, int row, int col);
}
