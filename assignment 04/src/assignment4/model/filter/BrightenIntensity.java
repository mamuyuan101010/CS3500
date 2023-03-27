package assignment4.model.filter;

import assignment4.model.image.ImageModel;
import assignment4.model.pixel.Pixel;
import assignment4.model.pixel.SimplePixel;

public class BrightenIntensity extends AbstractFilterOption {
  /**
   * constructor of the abstract filter option.
   *
   */
  public BrightenIntensity() {
    super("brighten-intensity");
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
    int intensity = (red + green + blue)/3;
    this.increment(red, green, blue, intensity);
    Pixel pixel = new SimplePixel(red, green, blue);
    layer.set(row, col, pixel);
  }
}
