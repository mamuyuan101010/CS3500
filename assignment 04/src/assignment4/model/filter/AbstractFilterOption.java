package assignment4.model.filter;

/**
 * abstract filter class that implements the filter and will let
 * other filter classes extend it.
 */
public abstract class AbstractFilterOption implements Filter{

  private String filterName;

  /**
   * constructor of the abstract filter option.
   * @param filterName
   */
  public AbstractFilterOption(String filterName) {
    this.filterName = filterName;
  }

  /**
   * return the name of the filter.
   */
  @Override
  public String getName() {
    return this.filterName;
  }

  /**
   * RGB values increase.
   * increase each value by certain integer.
   */
  public void increment(int r, int g, int b, int value) {
    r += value;
    g += value;
    b += value;
    r = Math.min(r, 255);
    g = Math.min(g, 255);
    b = Math.min(b, 255);
  }

  /**
   * RGB values decrease.
   * decrease each value by certain integer.
   */
  public void decreasing(int r, int g, int b, int value) {
    r -= value;
    g -= value;
    b -= value;
    r = Math.min(r, 0);
    g = Math.min(g, 0);
    b = Math.min(b, 0);
  }

}
