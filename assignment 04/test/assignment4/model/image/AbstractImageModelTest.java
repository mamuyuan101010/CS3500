package assignment4.model.image;

import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;

import assignment4.model.filter.BlueFilter;
import assignment4.model.pixel.Pixel;
import assignment4.model.pixel.SimplePixel;

/**
 * test for abstract image model class.
 */
public class AbstractImageModelTest extends TestCase {
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
   * test for getHeight method.
   */
  @Test
  public void testGetHeight() {
    assertEquals(im.getHeight(), 10);
  }

  /**
   * test for getWidth method.
   */
  @Test
  public void testGetWidth() {
    assertEquals(im.getWidth(), 10);
  }

  /**
   * test for getMaxValue method.
   */
  @Test
  public void testGetMaxValue() {
    assertEquals(im.getMaxValue(), 255);
  }

  /**
   * test for get method.
   */
  @Test
  public void testGet() {
    assertEquals(im.get(5, 5), new SimplePixel(255, 255, 255));
  }

  /**
   * test for set method.
   */
  @Test
  public void testSet() {
    im.set(5, 5, new SimplePixel(100, 100, 100));
    assertEquals(im.get(5, 5), new SimplePixel(100, 100, 100));
  }

  /**
   * test for copy method.
   */
  @Test
  public void testCopy() {
    ImageModel sm = im.copy();
    assertEquals(sm.get(7, 7), new SimplePixel(255, 255, 255));

  }

  /**
   * test for setfilter method.
   */
  @Test
  public void testSetFilter() {
    im.setFilter("blue-component");
    assertEquals(im.getFilter().getName(), "blue-component");
  }

  /**
   * test for getFilter method.
   */
  @Test
  public void testGetFilter() {
    assertEquals(im.getFilter().getName(), "normal");
  }

  /**
   * test for getType method.
   */
  @Test
  public void testGetType() {
    assertEquals(im.getType(), "C1");
  }
}