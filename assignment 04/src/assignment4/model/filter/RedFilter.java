package assignment4.model.filter;

import assignment4.model.image.ImageModel;
import assignment4.model.pixel.Pixel;
import assignment4.model.pixel.SimplePixel;

public class RedFilter extends AbstractFilterOption {
  /**
   * constructor of the abstract filter option.
   *
   */
  public RedFilter() {
    super("red-component");
  }

  /**
   * return the name of the filter.
   * @return
   */
  @Override
  public String getName() {
    return super.getName();
  }

  @Override
  public void filtering(ImageModel layer, int row, int col) {
    Pixel pixel = new SimplePixel(layer.get(row, col).getR(), 0, 0);
    layer.set(row, col, pixel);
  }
}
