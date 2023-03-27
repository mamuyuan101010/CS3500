package assignment4.model.filter;

import assignment4.model.image.ImageModel;
import assignment4.model.pixel.Pixel;
import assignment4.model.pixel.SimplePixel;

public class GreenFilter extends AbstractFilterOption {
  /**
   * constructor of the abstract filter option.
   *
   */
  public GreenFilter() {
    super("green-component");
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
    Pixel pixel = new SimplePixel(0, layer.get(row, col).getG(), 0);
    layer.set(row, col, pixel);
  }
}
