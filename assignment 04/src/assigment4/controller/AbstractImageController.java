package assigment4.controller;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;
import assigment4.controller.commands.ImageCommand;
import assigment4.model.collagerProject.CollagerProject;
import assigment4.model.collagerProject.SimpleCollagerProject;
import assigment4.model.layer.Layer;
import assigment4.view.ImageView;

/**
 * Represents collection of common utilities of controllers.
 */
public abstract class AbstractImageController implements ImageController {

  protected Map<String, Function<Scanner, ImageCommand>> commands;

  protected CollagerProject c;

  protected final Readable in;
  protected final ImageView out;

  /**
   * Creates an abstract image controller.
   * @param out output that the program will produce
   * @param in input that the clients will type
   */
  protected AbstractImageController(ImageView out, Readable in) {
    if (out == null || in == null) {
      throw new IllegalArgumentException("No parameters of controllers can be null.");
    }
    this.commands = new HashMap<>();
    this.c = new SimpleCollagerProject(new ArrayList<Layer>(), 0, 0);
    this.in = in;
    this.out = out;
  }
}

