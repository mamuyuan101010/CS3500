package assignment4.model.pixel;
import org.junit.Before;
import org.junit.Test;

import assigment4.model.pixel.Pixel;
import assigment4.model.pixel.SimplePixel;

import static org.junit.Assert.*;

/**
 * This is a JUnit test for pixel.
 */
public class SimplePixelTest {

  private Pixel pixel;

  @Before
  public void setUp() throws Exception {
    pixel = new SimplePixel(12, 13, 14, 15);
  }

  @Test
  public void testPixelException() {
    try {
      Pixel pixel = new SimplePixel(-1, 0, 0, 0);
      Pixel pixel1 = new SimplePixel(256, 0, 0, 0);
      Pixel pixel2 = new SimplePixel(0, -1, 0, 0);
      Pixel pixel3 = new SimplePixel(0, 256, 0, 0);
      Pixel pixel4 = new SimplePixel(0, 0, -1, 0);
      Pixel pixel5 = new SimplePixel(0, 0, 256, 0);
      Pixel pixel6 = new SimplePixel(0, 0, 0, -1);
      Pixel pixel7 = new SimplePixel(0, 0, 0, 256);
    } catch (IllegalStateException e) {
      assertEquals("No value of a pixel can be less than 0 or bigger than 255",
              e.getMessage());
    }
  }

  @Test
  public void testGetValue() {
    assertEquals(12, pixel.getR());
    assertEquals(13, pixel.getG());
    assertEquals(14, pixel.getB());
    assertEquals(15, pixel.getA());

  }

  @Test
  public void testCopy() {
    Pixel pixel1 = new SimplePixel(12, 13, 14, 15);
    Pixel pixel2 = new SimplePixel(12, 12, 12, 12);
    assertEquals(pixel1, pixel.copy());
    assertNotEquals(pixel2, pixel.copy());
  }

  @Test
  public void testToString() {
    assertEquals("12 13 14 15", pixel.toString());
  }
}
