package assignment4.controller.commands;

import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;

import java.util.Scanner;

import assignment4.model.pixel.SimplePixel;
import assignment4.model.project.ProjectModel;
import assignment4.model.project.SimpleProjectModel;

/**
 * new project command test class.
 */
public class NewProjectCommandTest extends TestCase {
  Scanner sc;
  ProjectModel pm;
  NewProjectCommand cmd;

  /**
   * initialize the value.
   */
  @Before
  public void setUp() {
    this.sc = new Scanner("10 10");
    this.pm = new SimpleProjectModel(10, 10, 255);
    this.cmd = new NewProjectCommand(this.sc);
  }

  /**
   * test apply.
   */
  @Test
  public void testApply() {
    this.cmd.apply(this.pm);
    assertEquals(this.pm.getProjectStructure().get("canvas").get(5, 5), new SimplePixel(255, 255, 255, 255));
  }
}