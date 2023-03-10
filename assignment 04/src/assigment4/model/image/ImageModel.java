package assigment4.model.image;

import assigment4.model.Copyable;
import assigment4.model.filter.Filter;
import assigment4.model.layer.Layer;
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

  /**
   * Creates a new project with the given name and given dimensions. Every project has a white
   * background layer by default.
   * @param height the height of the canvas
   * @param width the width of the canvas
   */
  public void newProject(int height, int width);

  /**
   * Loads a project into the program.
   * @param fileName the name of the path
   * @param imageModel the program that the users will be working on
   */
  public void loadProject(String fileName, ImageModel imageModel);

  /**
   * Saves the project as one file.
   * @param imageModel the project the users are working on
   * @param fileName the name of the path
   */
  public void saveProject(ImageModel imageModel, String fileName);

  /**
   * Adds a new layer with the given name to the top of the whole project.
   * @param layer the layer that the users want to add
   */
  public void addLayer(Layer layer);

  /**
   * Places an image on the layer such that the top left corner of the image is at (x-pos, y-pos).
   * @param layer the layer that the users want
   * @param imageModel the image that the users want to add on
   * @param row the row position of the image on the layer of the image beneath
   * @param col the column position of the image on the layer of the image beneath
   */
  public void addImageToLayer(Layer layer, ImageModel imageModel, int row, int col);

  /**
   * Sets the filter of the given layer with filter-option.
   * @param layer the layer existed
   * @param filter the filter option
   */
  public void setFilter(Layer layer, Filter filter);

  /**
   * Saves the result of applying all filters on the image.
   * @param imageModel the image or final project that the users want to save
   * @param fileName the name of the path
   */
  public void saveImage(ImageModel imageModel, String fileName);

  /**
   * Quits the project and loses all unsaved work.
   */
  public void quit();

}

