package assignment4.model.filter;

import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;

/**
 * abstractFilterOptionTest class.
 */
public class AbstractFilterOptionTest extends TestCase {
  AbstractFilterOption afo1;
  AbstractFilterOption afo2;

  /**
   * initialize the value.
   */
  @Before
  public void setUp() {
    this.afo1 = new NormalFilter();
    this.afo2 = new BlueFilter();
  }

  /**
   * test getName method.
   */
  @Test
  public void testTestGetName() {
    assertEquals(this.afo1.getName(), "normal");
    assertEquals(this.afo2.getName(), "blue-component");
  }
}