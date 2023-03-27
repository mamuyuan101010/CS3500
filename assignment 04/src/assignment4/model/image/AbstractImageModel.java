package assignment4.model.image;

import java.util.HashMap;
import java.util.Map;

import assignment4.model.filter.BlueFilter;
import assignment4.model.filter.BrightenIntensity;
import assignment4.model.filter.BrightenLuma;
import assignment4.model.filter.BrightenValue;
import assignment4.model.filter.DarkenIntensity;
import assignment4.model.filter.DarkenLuma;
import assignment4.model.filter.DarkenValue;
import assignment4.model.filter.Filter;
import assignment4.model.filter.GreenFilter;
import assignment4.model.filter.NormalFilter;
import assignment4.model.filter.RedFilter;
import assignment4.model.pixel.Pixel;

/**
 * Packages shared image functionality together.
 */
public abstract class AbstractImageModel implements ImageModel {

  protected int maxValue;
  protected int height;
  protected int width;

  protected Pixel[][] image;

  protected String type;

  protected Filter filter;

  private Map<String, Filter> filterOptions;

  /**
   * Constructs a default abstract model that has yet to be loaded.
   */
  protected AbstractImageModel(String type) {
    this.maxValue = 0;
    this.height = 0;
    this.width = 0;
    this.type = type;
    this.filter = new NormalFilter();
    this.filterOptions = new HashMap<>();
    filterOptions.put("normal", new NormalFilter());
    filterOptions.put("blue-component", new BlueFilter());
    filterOptions.put("red-component", new RedFilter());
    filterOptions.put("green-component", new GreenFilter());
    filterOptions.put("brighten-value", new BrightenValue());
    filterOptions.put("brighten-intensity", new BrightenIntensity());
    filterOptions.put("brighten-luma", new BrightenLuma());
    filterOptions.put("darken-value", new DarkenValue());
    filterOptions.put("darken-intensity", new DarkenIntensity());
    filterOptions.put("darken-luma", new DarkenLuma());

  }

  /**
   * Constructs an abstract image model given values.
   *
   * @param maxValue max channel value.
   * @param height   image height.
   * @param width    image width.
   */
  protected AbstractImageModel(int maxValue, int height, int width, Pixel[][] image, String type) {
    this.maxValue = maxValue;
    this.height = height;
    this.width = width;
    this.image = image;
    this.type = type;
    this.filter = new NormalFilter();
    this.filterOptions = new HashMap<>();
    filterOptions.put("normal", new NormalFilter());
    filterOptions.put("blue-component", new BlueFilter());
    filterOptions.put("red-component", new RedFilter());
    filterOptions.put("green-component", new GreenFilter());
    filterOptions.put("brighten-value", new BrightenValue());
    filterOptions.put("brighten-intensity", new BrightenIntensity());
    filterOptions.put("brighten-luma", new BrightenLuma());
    filterOptions.put("darken-value", new DarkenValue());
    filterOptions.put("darken-intensity", new DarkenIntensity());
    filterOptions.put("darken-luma", new DarkenLuma());
  }

  /**
   * return the height of the model.
   */
  @Override
  public int getHeight() {
    return this.height;
  }

  /**
   * return the width of the model.
   */
  @Override
  public int getWidth() {
    return this.width;
  }

  /**
   * return the maxValue of the model.
   */
  @Override
  public int getMaxValue() {
    return this.maxValue;
  }

  /**
   * return the pixel of the given coordinate.
   * @param row pixel row.
   * @param col pixel col.
   * @return the pixel of the given coordinate.
   */
  @Override
  public Pixel get(int row, int col) {
    if (row >= this.height || row < 0 || col >= this.width || col < 0) {
      throw new IllegalArgumentException(String.format("Get (%d, %d) out of bounds for " +
              "size(%d, %d).", row, col, this.height, this.width));
    }

    return this.image[row][col];
  }

  /**
   * set the given pixel to the given coordinate.
   * @param row row of pixel to set.
   * @param col col of pixel to set.
   * @param p pixel to set as new entry.
   */
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

  /**
   * copy the current imageModel information to a new imageModel class.
   * this will avoid alias to the current class.
   */
  @Override
  public ImageModel copy() {
    Pixel[][] p = new Pixel[this.height][this.width];
    for (int i = 0; i < this.height; i++) {
      for (int j = 0; j < this.width; j++) {
        p[i][j] = this.image[i][j].copy();
      }
    }
    return new SimpleImageModel(this.maxValue, this.height, this.width, this.image, this.type);
  }

  /**
   * set the filter to the current image model using the given name of filter
   * @param filter
   */
  @Override
  public void setFilter(String filter) {
    this.filter = this.filterOptions.get(filter);
    if (this.filter == null) {
      throw new IllegalStateException();
    }

  }

  /**
   * return the filter of the current imageModel.
   * @return
   */
  @Override
  public Filter getFilter() {
    return this.filter;
  }

  /**
   * return the type of the current imageModel.
   * @return
   */
  @Override
  public String getType() {
    return type;
  }
}
