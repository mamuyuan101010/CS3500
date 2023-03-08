package assigment4.model.image;

/**
 * Packages shared image functionality together.
 */
public abstract class AbstractImageModel implements ImageModel {

  protected int maxValue;
  protected int height;
  protected int width;

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
  protected AbstractImageModel(int maxValue, int height, int width) {
    this.maxValue = maxValue;
    this.height = height;
    this.width = width;
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
}
