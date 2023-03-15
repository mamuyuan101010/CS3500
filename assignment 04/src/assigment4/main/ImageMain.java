package assigment4.main;

import java.io.InputStreamReader;

import assigment4.controller.ImageController;
import assigment4.controller.SimpleImageController;

/**
 * Represents the entrypoint of the program.
 */
public class ImageMain {

  /**
   * Main method. Runs the entrypoint. Allows client to interact with the program.
   * @param args program arguments
   */
  public static void main(String[] args) {
    ImageController controller = new SimpleImageController(System.out,
            new InputStreamReader(System.in));
    controller.go();
  }
}
