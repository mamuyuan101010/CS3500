package assignment4.model.filter;

import assignment4.model.image.ImageModel;
import assignment4.model.pixel.Pixel;
import assignment4.model.pixel.SimplePixel;

public class DarkenLuma extends AbstractFilterOption {
  /**
   * constructor of the abstract filter option.
   *
   */
  public DarkenLuma() {
    super("darken-luma");
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
    double luma = 0.2126 * red + 0.7152 * green + 0.0722 * blue;
    int lumaInt = (int) Math.round(luma);
    this.decreasing(red, green, blue, lumaInt);
    Pixel pixel = new SimplePixel(red, green, blue);
    layer.set(row, col, pixel);
  }
}
