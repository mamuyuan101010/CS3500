package assigment4.model.image;

import assigment4.model.pixel.Pixel;

/**
 * Packages shared image functionality together.
 */
public abstract class AbstractImageModel implements ImageModel {

  protected int maxValue;
  protected int height;
  protected int width;

  protected Pixel[][] image;

  /**
   * Constructs a default abstract model that has yet to be loaded.
   */
  protected AbstractImageModel() {
    this.maxValue = 0;
    this.height = 0;
    this.width = 0;
  }

  /**
   * Constructs an abstract image model given values.
   *
   * @param maxValue max channel value.
   * @param height   image height.
   * @param width    image width.
   */
  protected AbstractImageModel(int maxValue, int height, int width, Pixel[][] image) {
    this.maxValue = maxValue;
    this.height = height;
    this.width = width;
    this.image = image;
  }

  @Override
  public int getHeight() {
    return this.height;
  }

  @Override
  public int getWidth() {
    return this.width;
  }

  @Override
  public int getMaxValue() {
    return this.maxValue;
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
    return new SimpleImageModel(this.maxValue, this.height, this.width, this.image);
  }
}
