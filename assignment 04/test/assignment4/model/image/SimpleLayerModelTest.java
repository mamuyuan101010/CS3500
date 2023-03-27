package assignment4.model.image;

import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;

import assignment4.model.pixel.Pixel;
import assignment4.model.pixel.SimplePixel;

/**
 * simple layer model test class.
 */
public class SimpleLayerModelTest extends TestCase {

  ImageModel im;
  Pixel[][] whitePic;

  /**
   * initialize the value.
   */
  @Before
  public void setUp() {
    this.whitePic = new Pixel[10][10];
    for (int i = 0; i < 10; i ++) {
      for (int j = 0; j < 10; j ++) {
        this.whitePic[i][j] = new SimplePixel(255, 255, 255);
      }
    }
    this.im = new SimpleImageModel(255, 10, 10, whitePic, "C1");
  }

  /**
   * test for set filter method.
   */
  @Test
  public void testSetFilter() {
    this.im.setFilter("blue-component");
    assertEquals(this.im.getFilter().getName(), "blue-component");
  }
}