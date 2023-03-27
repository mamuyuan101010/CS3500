package assignment4.controller.commands;

import junit.framework.TestCase;

import org.junit.Before;

import java.util.Scanner;

import assignment4.model.pixel.SimplePixel;
import assignment4.model.project.ProjectModel;
import assignment4.model.project.SimpleProjectModel;

/**
 * setFilterCommand class test.
 */
public class SetFilterCommandTest extends TestCase {
  Scanner sc;
  Scanner sc2;
  ProjectModel pm;
  SetFilterCommand cmd;
  AddLayerCommand cmd2;

  /**
   * initialize the value.
   */
  @Before
  public void setUp() {
    this.sc = new Scanner("newLayer1 blue-component");
    this.sc2 = new Scanner("newLayer1");
    this.pm = new SimpleProjectModel(10, 10, 255);
    this.cmd = new SetFilterCommand(this.sc);
    this.cmd2 = new AddLayerCommand(this.sc2);
  }

  /**
   * test apply.
   */
  public void testApply() {
    this.cmd2.apply(this.pm);
    this.cmd.apply(this.pm);
    assertEquals(this.pm.getProjectStructure().get("newLayer1").getFilter().getName(),"blue-component");
  }
}