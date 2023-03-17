package assigment4.model.filter;

import org.junit.Test;

import static org.junit.Assert.*;

public class FilterTest {

  @Test
  public void testToString() {
    assertEquals(Filter.Normal.toString(), "normal");
  }
}