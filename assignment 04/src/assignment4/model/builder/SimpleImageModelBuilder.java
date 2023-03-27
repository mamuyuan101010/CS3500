package assignment4.model.builder;

import assignment4.model.image.ImageModel;
import assignment4.model.image.SimpleImageModel;
import assignment4.model.pixel.Pixel;

/**
 * Builds a SimpleImageModel.
 */
public class SimpleImageModelBuilder {

  private Integer width;
  private Integer height;
  private Integer maxValue;

  private Pixel[][] image;

  private String name;

  /**
   * Gets a new instance of the builder.
   *
   * @return new instance.
   */
  public static SimpleImageModelBuilder newInstance() {
    return new SimpleImageModelBuilder();
  }

  /**
   * Sets the width of the model to build.
   *
   * @param width width to set.
   * @return returns the builder with the width set.
   */
  public SimpleImageModelBuilder setWidth(int width) {
    this.width = width;
    return this;
  }

  /**
   * Sets the height of the model to build.
   *
   * @param height height to set.
   * @return returns the builder with the height set.
   */
  public SimpleImageModelBuilder setHeight(int height) {
    this.height = height;
    return this;
  }

  /**
   * Sets the max value of the model to build.
   *
   * @param maxValue max value of the image.
   * @return returns a builder with the max value set.
   */
  public SimpleImageModelBuilder setMaxValue(int maxValue) {
    this.maxValue = maxValue;
    return this;
  }

  /**
   * Sets the image of the model to build.
   *
   * @param image image to set.
   * @return returns a builder with the image set.
   */
  public SimpleImageModelBuilder setImage(Pixel[][] image) {
    this.image = image;
    return this;
  }

  /**
   * Sets the name of the model to build.
   *
   * @param name name to set.
   * @return returns a builder with the image set.
   */
  public SimpleImageModelBuilder setName(String name) {
    this.name = name;
    return this;
  }

  /**
   * Builds the model.
   *
   * @return returns the model.
   */
  public ImageModel build() {
    if (this.height == null || this.width == null || this.maxValue == null) {
      throw new IllegalStateException("SimpleBuilder did not set all required fields.");
    }

    if (this.image == null) {
      this.image = new Pixel[this.height][this.width];
    }
    return new SimpleImageModel(this.maxValue, this.height, this.width, this.image, "image");
  }
}
