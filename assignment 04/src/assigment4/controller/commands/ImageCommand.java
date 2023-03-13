package assigment4.controller.commands;

import java.util.Map;

import assigment4.model.image.ImageModel;

/**
 * Represents a command that works on an image model.
 */
public interface ImageCommand {

  /**
   * Applies command given a list of images.
   * @param images list of models for the command to work on.
   */
  public void apply(Map<String, ImageModel> images) throws IllegalStateException;

  /**
   * Prints helpful information about a command.
   * @return String of information.
   */
  public String help();
}

