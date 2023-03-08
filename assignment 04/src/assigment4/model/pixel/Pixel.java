package assigment4.model.pixel;

import assigment4.model.Copyable;

/**
 * Represents a pixel with RGBA values.
 */
public interface Pixel extends Copyable<Pixel> {

  /**
   * Get the red channel of the pixel.
   * @return red channel of the pixel.
   */
  public int getR();

  /**
   * Get the green channel of the pixel.
   * @return green channel of the pixel.
   */
  public int getG();

  /**
   * Get the blue channel of the pixel.
   * @return blue channel of the pixel.
   */
  public int getB();

  /**
   * Get the transparency channel of the pixel.
   * @return transparency channel of the pixel.
   */
  public int getA();

}
