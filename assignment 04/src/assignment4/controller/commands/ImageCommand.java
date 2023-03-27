package assignment4.controller.commands;

import java.util.Map;

import assignment4.model.image.ImageModel;
import assignment4.model.project.ProjectModel;

/**
 * Represents a command that works on an image model.
 */
public interface ImageCommand {

  /**
   * Applies command given a list of images.
   * @param projectModel a models for the command to work on.
   */
  public void apply(ProjectModel projectModel) throws IllegalStateException;

}

