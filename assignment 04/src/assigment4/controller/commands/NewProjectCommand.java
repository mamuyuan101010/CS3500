package assigment4.controller.commands;

import java.util.Map;
import java.util.Scanner;

import assigment4.model.image.ImageModel;
import assigment4.model.image.SimpleImageModel;

public class NewProjectCommand extends AbstractCommand{

  /**
   * Constructs an Abstract command.
   *
   * @param sc
   */
  public NewProjectCommand(Scanner sc) {
    super(sc);
  }

  @Override
  public void apply(Map<String, ImageModel> images) throws IllegalStateException {
    SimpleImageModel output;
    String widthString = sc.next();
    try {
      int width = Integer.parseInt(widthString);
    } catch (Exception e) {
      throw new IllegalArgumentException("not an integer");
    }

    String heightString = sc.next();
    try {
      int height = Integer.parseInt(heightString);
    } catch (Exception e) {
      throw new IllegalArgumentException("not an integer");
    }


  }
}
