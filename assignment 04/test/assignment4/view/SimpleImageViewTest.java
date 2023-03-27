package assignment4.view;

import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;

/**
 * test for simpleImageView class.
 */
public class SimpleImageViewTest extends TestCase {

  Appendable out;
  ImageView iv;

  /**
   * initialiize teh value.
   */

  @Before
  public void setUp() {
    this.out = new StringBuilder();
    this.iv = new SimpleImageView(out);
  }

  /**
   * test for renderMessage mehtod.
   */
  @Test
  public void testRenderMessage() {
    iv.renderMessage("ha");
    assertEquals(out.toString(), "ha");
  }

  /**
   * test for renderMessage method exceptions.
   */
  @Test
  public void testRenderMessageException() {
    try {
      ImageView niv = new SimpleImageView(null);
    } catch (IllegalArgumentException e) {
      assertEquals(e.getMessage(),"The out is null.");
    }
  }
}