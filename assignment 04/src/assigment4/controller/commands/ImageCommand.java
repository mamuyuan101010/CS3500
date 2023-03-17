package assigment4.controller.commands;

import java.util.List;
import assigment4.model.layer.Layer;

/**
 * Represents a command that works on an image model.
 */
public interface ImageCommand {

  /**
   * Applies command given a list of images.
   * @param layers list of layer for the command to work on.
   */
  public void apply(Project ) throws IllegalStateException;

  /**
   * Prints helpful information about a command.
   * @return String of information.
   */
  public String help();
}

