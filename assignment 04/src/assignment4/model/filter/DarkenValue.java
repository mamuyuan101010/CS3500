package assignment4.model.filter;

import assignment4.model.image.ImageModel;
import assignment4.model.pixel.Pixel;
import assignment4.model.pixel.SimplePixel;

public class DarkenValue extends AbstractFilterOption {
  /**
   * constructor of the abstract filter option.
   *
   */
  public DarkenValue() {
    super("darken-value");
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
    int red = layer.get(row, col).getR();
    int green = layer.get(row, col).getG();
    int blue = layer.get(row, col).getB();
    int intensity = Math.max(Math.max(red, green), blue);
    this.decreasing(red, green, blue, intensity);
    Pixel pixel = new SimplePixel(red, green, blue);
    layer.set(row, col, pixel);
  }
}
