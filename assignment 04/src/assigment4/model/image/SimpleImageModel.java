package assigment4.model.image;

import assigment4.model.pixel.Pixel;

/**
 * Simple model of an image represents an image as a 2d array of pixels.
 */
public class SimpleImageModel extends AbstractImageModel {

  private Pixel[][] image;

  /**
   * Constructs a new default Simple image model.
   */
  public SimpleImageModel() {
    super();
    this.image = new Pixel[0][0];
  }

  /**
   * Constructs a new simple image model given its params.
   * @param image image to model.
   * @param maxValue max channel value.
   * @param height height of the image.
   * @param width width of the image.
   */
  public SimpleImageModel(Pixel[][] image, int maxValue, int height, int width) {
    super(maxValue, height, width);
    this.image = image;
  }

  @Override
  public Pixel get(int row, int col) {
    if (row >= this.height || row < 0 || col >= this.width || col < 0) {
      throw new IllegalArgumentException(String.format("Get (%d, %d) out of bounds for " +
              "size(%d, %d).", row, col, this.height, this.width));
    }

    return this.image[row][col];
  }

  @Override
  public void set(int row, int col, Pixel p) {
    if (p == null) {
      throw new IllegalArgumentException("Set pixel is null");
    }
    if (row >= this.height || row < 0 || col >= this.width || col < 0) {
      throw new IllegalArgumentException(String.format("Set (%d, %d) out of bounds for " +
              "size(%d, %d).", row, col, this.height, this.width));
    }

    if (p == null) {
      throw new IllegalArgumentException(String.format("Set (%d, %d) pixel is null", row, col));
    }

    this.image[row][col] = p;
  }

  @Override
  public ImageModel copy() {
    Pixel[][] p = new Pixel[this.height][this.width];
    for (int i = 0; i < this.height; i++) {
      for (int j = 0; j < this.width; j++) {
        p[i][j] = this.image[i][j].copy();
      }
    }
    return new SimpleImageModel(p, this.maxValue, this.height, this.width);
  }
}
