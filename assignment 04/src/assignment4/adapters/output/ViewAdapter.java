package assignment4.adapters.output;

import java.io.IOException;

/**
 * view adapter interface convert images or projects from java program
 * to text file.
 */
public interface ViewAdapter {

  /**
   * given the name of file, write text files.
   * @param filename
   * @throws IOException when cannot find the file.
   */
  void write(String filename) throws IOException;
}
