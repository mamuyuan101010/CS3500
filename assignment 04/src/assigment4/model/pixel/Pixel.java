package assigment4.model.pixel;

import assigment4.model.Copyable;

/**
 * Represents a pixel with RGBA values.
 */
public interface Pixel extends Copyable<Pixel> {

  /**
   * Get the red channel of the pixel.
   * @return red channel of the pixel
   */
  public int getR();

  /**
   * Get the green channel of the pixel.
   * @return green channel of the pixel
   */
  public int getG();

  /**
   * Get the blue channel of the pixel.
   * @return blue channel of the pixel
   */
  public int getB();

  /**
   * Get the transparency channel of the pixel.
   * @return transparency channel of the pixel
   */
  public int getA();

  /**
   * Get the copy of the pixel. This method helps users to edit the image without modifying the
   * previous one.
   * @return a copy of the pixel
   */
  public Pixel copy();

  /**
   * Get the view of the pixel. This method is related to the view of the entire structure of
   * collager.
   * @return the text view of the pixel
   */
  public String toString();
}
