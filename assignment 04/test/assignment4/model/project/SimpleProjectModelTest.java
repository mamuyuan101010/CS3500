package assignment4.model.project;

import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import assignment4.model.image.ImageModel;
import assignment4.model.image.SimpleImageModel;
import assignment4.model.pixel.Pixel;
import assignment4.model.pixel.SimplePixel;

public class SimpleProjectModelTest extends TestCase {
  ProjectModel pm;
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
    this.pm = new SimpleProjectModel(10, 10, 255, "new project");
    this.im = new SimpleImageModel(255, 10, 10, this.whitePic, "C1");
  }

  /**
   * test for put method.
   */
  @Test
  public void testPut() {
    this.pm.put("image model 1", this.im);
    assertEquals(this.pm.getProjectStructure().get("image model 1"), this.im);
  }

  /**
   * test for getHeight method.
   */
  @Test
  public void testGetHeight() {
    assertEquals(this.pm.getHeight(), 10);
  }

  /**
   * test for getWidth method.
   */
  @Test
  public void testGetWidth() {
    assertEquals(this.pm.getWidth(), 10);
  }

  /**
   * test for getMaxValue method.
   */
  @Test
  public void testGetMaxValue() {
    assertEquals(this.pm.getMaxValue(), 255);
  }

  /**
   * test for getProjectStructure method.
   */
  @Test
  public void testGetProjectStructure() {
    this.pm.put("image model 1", this.im);
    assertEquals(this.pm.getProjectStructure().get("image model 1"), this.im);
  }

  /**
   * test for setHeight method.
   */
  @Test
  public void testSetHeight() {
    this.pm.setHeight(5);
    assertEquals(this.pm.getHeight(), 5);
  }

  /**
   * test for setWidth method.
   */
  @Test
  public void testSetWidth() {
    this.pm.setWidth(7);
    assertEquals(this.pm.getWidth(), 7);
  }

  /**
   * test for setMaxValue method.
   */
  @Test
  public void testSetMaxValue() {
    this.pm.setMaxValue(100);
    assertEquals(this.pm.getMaxValue(), 100);
  }

  /**
   * test for setProjectName method.
   */
  @Test
  public void testSetProjectName() {
    this.pm.setProjectName("pjm");
    assertEquals(this.pm.getProjectName(), "pjm");
  }

  /**
   * test for getProjectName method.
   */
  @Test
  public void testGetProjectName() {
    assertEquals(this.pm.getProjectName(), "new project");
  }

  /**
   * test for setProjectStructure method.
   */
  @Test
  public void testSetProjectStructure() {
    Map m = new HashMap<String, ImageModel>();
    m.put("new model", this.im);
    this.pm.setProjectStructure(m);
    assertEquals(this.pm.getProjectStructure().get("new model"), this.im);
  }
}