package assignment4.model.filter;

import assignment4.model.image.ImageModel;

/**
 * Normal filter class that extends the abstract filter.
 * this filter doing nothing to the layer.
 */
public class NormalFilter extends AbstractFilterOption{

  /**
   * the constructor of the Normal filer class.
   */
  public NormalFilter() {
    super("normal");
  }

  /**
   * return the name of the filter.
   * @return
   */
  @Override
  public String getName() {
    return super.getName();
  }


  /** doing nothing to the given layer.
   * @param layer the given layer that we are editing.
   * @param row the given y coordinate.
   * @param col the given x coordinate.
   */
  @Override
  public void filtering(ImageModel layer, int row, int col) {
    // do nothing for normal filter
  }
}
