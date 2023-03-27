package assignment4.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;

import assignment4.controller.commands.ImageCommand;
import assignment4.model.image.ImageModel;
import assignment4.model.project.ProjectModel;
import assignment4.view.ImageView;

/**
 * Represents collection of common utilities of controllers.
 */
public abstract class AbstractImageController implements ImageController {

  protected Map<String, Function<Scanner, ImageCommand>> commands;

  protected Map<String, ImageModel> images;

  protected final Readable in;
  protected final ImageView out;

  protected ProjectModel projectModel;

  /**
   * Creates an abstract image controller.
   * @param out output that the program will produce
   * @param in input that the clients will type
   */
  protected AbstractImageController(ProjectModel projectModel, ImageView out, Readable in) {
    if (out == null || in == null) {
      throw new IllegalArgumentException("No parameters of controllers can be null.");
    }
    this.commands = new HashMap<>();
    this.images = new HashMap<>();
    this.projectModel = projectModel;
    this.in = in;
    this.out = out;
  }
}

