package assignment4.model.filter;

import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;

import assignment4.model.image.ImageModel;
import assignment4.model.image.SimpleImageModel;
import assignment4.model.pixel.Pixel;
import assignment4.model.pixel.SimplePixel;

/**
 * test for normal filter class.
 */
public class NormalFilterTest extends TestCase {
  NormalFilter nf;
  ImageModel layer1;
  Pixel[][] whitePic;

  /**
   * initialize the value.
   */
  @Before
  public void setUp() {
    this.nf = new NormalFilter();
    this.whitePic = new Pixel[10][10];
    for (int i = 0; i < 10; i ++) {
      for (int j = 0; j < 10; j ++) {
        this.whitePic[i][j] = new SimplePixel(255, 255, 255);
      }
    }
    this.layer1 = new SimpleImageModel(255, 10, 10, this.whitePic, "C1");
  }


  /**
   * test for getname method.
   */
  @Test
  public void testTestGetName() {
    assertEquals(this.nf.getName(), "normal");

  }

  /**
   * test for filtering method.
   */
  @Test
  public void testFiltering() {
    this.nf.filtering(this.layer1, 5, 5);
    assertEquals(this.layer1.get(5, 5), new SimplePixel(255, 255, 255));
  }

}