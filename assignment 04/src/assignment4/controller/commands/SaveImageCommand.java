package assignment4.controller.commands;

import java.io.IOException;
import java.util.Scanner;
import assignment4.adapters.output.PPMViewAdapter;
import assignment4.adapters.output.ViewAdapter;
import assignment4.model.project.ProjectModel;

/**
 * save-iamge-command class that save the project as an ppm file image.
 */
public class SaveImageCommand extends AbstractCommand{
  /**
   * Constructor of the saving-image-command
   * @param sc
   */
  public SaveImageCommand(Scanner sc) {
    super(sc);
  }

  /**
   * execute the command to save the project as an image file
   * @param projectModel a models for the command to work on.
   */
  @Override
  public void apply(ProjectModel projectModel) throws IllegalStateException {
    String fileName = this.getString();
    ViewAdapter viewAdapter = new PPMViewAdapter(projectModel);
    try {
      viewAdapter.write(fileName);
    } catch (IOException e) {

    }


  }
}
