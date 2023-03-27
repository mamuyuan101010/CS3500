package assignment4.main;

import java.io.InputStreamReader;

import assignment4.controller.ImageController;
import assignment4.controller.SimpleImageController;
import assignment4.model.project.ProjectModel;
import assignment4.model.project.SimpleProjectModel;

/**
 * Represents the entrypoint of the program.
 */
public class ImageMain {

  /**
   * Main method. Runs the entrypoint. Allows client to interact with the program.
   * @param args program arguments
   */
  public static void main(String[] args) {

    ProjectModel projectModel = new SimpleProjectModel();
    ImageController controller = new SimpleImageController(projectModel, System.out,
            new InputStreamReader(System.in));
    controller.go();
  }
}
