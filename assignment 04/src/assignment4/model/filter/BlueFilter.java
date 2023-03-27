package assignment4.model.filter;

import assignment4.model.image.ImageModel;

import assignment4.model.pixel.Pixel;
import assignment4.model.pixel.SimplePixel;

/**
 * blue filter class that extends the abstract filter class
 * this filter will only let blue pixel left.
 */
public class BlueFilter extends AbstractFilterOption{

  /**
   * constructor of blue filter.
   */
  public BlueFilter() {
    super("blue-component");
  }

  /**
   * return the name of the filter.
   * @return
   */
  @Override
  public String getName() {
    return super.getName();
  }

  /**
   * filter the pixel of the given coordinate of the given layer
   * only left blue pixel in this case.
   * @param layer
   * @param row
   * @param col
   */
  @Override
  public void filtering(ImageModel layer, int row, int col) {
    Pixel pixel = new SimplePixel(0, 0, layer.get(row, col).getB());
    layer.set(row, col, pixel);

  }
}
