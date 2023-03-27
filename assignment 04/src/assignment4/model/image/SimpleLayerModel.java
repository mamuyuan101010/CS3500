package assignment4.model.image;

import assignment4.model.filter.Filter;
import assignment4.model.pixel.Pixel;

/**
 * simple Layer model class extends the abstract image model
 * this class make an imageModel with filter and its layer name
 */
public class SimpleLayerModel extends AbstractImageModel{

  private Filter filter;


  private String layerName;

  /**
   * consturctor of the simple layer model.
   * @param maxValue the max value of the simple layer model.
   * @param height the height of the simple layer model.
   * @param width the width of the simple layer model.
   * @param image the image of the simple layer model, using 2D array of pixel.
   * @param type the type of the simple layer model.
   * @param layerName the layer name of the simple layer model.
   * @param filter the filter of the simple layer model.
   */
  public SimpleLayerModel(int maxValue, int height, int width, Pixel[][] image, String type,
                          String layerName, Filter filter) {
    super(maxValue, height, width, image, type);
    this.layerName = layerName;
    this.filter = filter;
  }

  /**
   * set the filter of the layer using the given filter.
   * @param filter
   */
  @Override
  public void setFilter(String filter) {
    super.setFilter(filter);
  }


}
