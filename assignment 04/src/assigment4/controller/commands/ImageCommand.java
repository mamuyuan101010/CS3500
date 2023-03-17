package assigment4.controller.commands;

import java.util.List;

import assigment4.model.collagerProject.CollagerProject;
import assigment4.model.layer.Layer;

/**
 * Represents a command that works on an image model.
 */
public interface ImageCommand {

  /**
   * Applies command given project.
   */
  public void apply(CollagerProject c) throws IllegalStateException;

  /**
   * Prints helpful information about a command.
   * @return String of information.
   */
  public String help();
}

