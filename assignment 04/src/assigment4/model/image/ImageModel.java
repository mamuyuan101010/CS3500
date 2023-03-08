package assigment4.model.image;

import assigment4.model.Copyable;
import assigment4.model.pixel.Pixel;



/**
 * Represents an image made of pixels.
 */
public interface ImageModel extends Copyable<ImageModel> {

  /**
   * Gets the pixel at the specified row and col.
   * @param row pixel row.
   * @param col pixel col.
   * @return pixel at (row, col)
   */
  public Pixel get(int row, int col) throws IllegalArgumentException;

  /**
   * Gets height of the image.
   * @return image height.
   */
  public int getHeight();

  /**
   * Gets width of the image.
   * @return image width.
   */
  public int getWidth();

  /**
   * Gets the max channel value.
   * @return max channel value.
   */
  public int getMaxValue();

  /**
   * Sets the pixel at (row, col) to be Pixel p.
   * @param row row of pixel to set.
   * @param col col of pixel to set.
   * @param p pixel to set as new entry.
   */
  public void set(int row, int col, Pixel p) throws IllegalArgumentException;
}

