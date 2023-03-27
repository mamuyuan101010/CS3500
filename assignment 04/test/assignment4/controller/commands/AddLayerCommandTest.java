package assignment4.controller.commands;

import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;

import java.util.Scanner;

import assignment4.model.pixel.Pixel;
import assignment4.model.pixel.SimplePixel;
import assignment4.model.project.ProjectModel;
import assignment4.model.project.SimpleProjectModel;

/**
 * addLayerCommnadTest class.
 */
public class AddLayerCommandTest extends TestCase {
  Scanner sc;
  ProjectModel pm;
  AddLayerCommand cmd;

  /**
   * initialize data.
   */
  @Before
  public void setUp() {
    this.sc = new Scanner("newLayer1");
    this.pm = new SimpleProjectModel(10, 10, 255);
    this.cmd = new AddLayerCommand(this.sc);
  }

  /**
   * test apply method.
   */
  @Test
  public void testApply() {
    this.cmd.apply(this.pm);
    assertEquals(this.pm.getProjectStructure().get("newLayer1").get(1, 1), new SimplePixel(255, 255, 255, 0));
  }
}