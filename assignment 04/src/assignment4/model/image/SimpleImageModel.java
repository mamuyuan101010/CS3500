package assignment4.model.image;

import assignment4.model.pixel.Pixel;

/**
 * Simple model of an image represents an image as a 2d array of pixels.
 */
public class SimpleImageModel extends AbstractImageModel {

  private Pixel[][] image;


  /**
   * Constructs a new simple image model given its params.
   * @param image image to model.
   * @param maxValue max channel value.
   * @param height height of the image.
   * @param width width of the image.
   */
  public SimpleImageModel(int maxValue, int height, int width, Pixel[][] image, String type) {
    super(maxValue, height, width, image, type);


  }




}
