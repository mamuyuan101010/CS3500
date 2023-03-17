package assigment4.controller;

import java.util.Scanner;
import java.util.function.Function;

import assigment4.controller.commands.AddImageToLayerCommand;
import assigment4.controller.commands.AddLayerCommand;
import assigment4.controller.commands.ImageCommand;
import assigment4.controller.commands.LoadProjectCommand;
import assigment4.controller.commands.NewProjectCommand;
import assigment4.controller.commands.SaveImageCommand;
import assigment4.controller.commands.SaveProjectCommand;
import assigment4.controller.commands.SetFilterCommand;
import assigment4.view.SimpleImageView;


/**
 * A simple controller to act on images.
 */
public class SimpleImageController extends AbstractImageController {

  /**
   * Constructs a new simple image model.
   *
   * @param out   where to output.
   * @param in where take input.
   */
  public SimpleImageController(Appendable out, Readable in) {
    super(new SimpleImageView(out), in);
    if (out == null || in == null) {
      throw new IllegalArgumentException("SimpleCont out is null");
    }

    this.commands.put("new-project", (Scanner s) -> new NewProjectCommand(s));
    /*this.commands.put("load-project", (Scanner s) -> new LoadProjectCommand(s));
    this.commands.put("save-project", (Scanner s) -> new SaveProjectCommand(s));
    this.commands.put("add-layer", (Scanner s) -> new AddLayerCommand(s));
    this.commands.put("add-image-to-layer", (Scanner s) -> new AddImageToLayerCommand(s));
    this.commands.put("set-filter", (Scanner s) -> new SetFilterCommand(s));
    this.commands.put("save-image", (Scanner s) -> new SaveImageCommand(this.out));
    this.commands.put("quit", (Scanner s) -> new QuitCommand(s));*/
  }

  @Override
  public void go() {

    Scanner sc = new Scanner(in);
    this.out.renderMessage("1.new-project canvas-height canvas-width: creates a new project with " +
            "the given name and given dimensions. Every project has a white background layer " +
            "by default.\n2.load-project path-to-project-file: loads a project into the program\n" +
            "3.save-project: save the project as one file as described above\n4.add-layer " +
            "layer-name: adds a new layer with the given name to the top of the whole project. " +
            "This layer always has a fully transparent white image and the Normal filter on " +
            "by default. Any attempt at creating another layer with the same name reports an " +
            "error to the user, but continues the program.\n5.add-image-to-layer layer-name " +
            "image-name x-pos y-pos: places an image on the layer such that the top left corner " +
            "of the image is at (x-pos, y-pos)\n6.set-filter layer-name filter-option: sets the " +
            "filter of the given layer where filter-option is one of the following at the " +
            "moment\n    normal : does nothing to the image\n    red-component: when applied, " +
            "only uses the red portion of the RGB. Similar for green-component and " +
            "blue-component\n    brighten-value: when applied, adds the brightness value pixel " +
            "by pixel according to value from the corresponding pixel on the current layer. " +
            "Similar for brighten-intensity and brighten-luma. Only affects the current " +
            "layer.\n    darken-value: when applied, removes the brightness value pixel by " +
            "pixel according to value from the correspondign pixel on the current layer. " +
            "Similar for darken-intensity and darken-luma. Only affects the current layer.\n");
    String command;
    this.out.renderMessage("-> ");
    while (sc.hasNext()) {
      command = sc.next().toLowerCase();
      if (command.equals("exit") || command.equals("quit") || command.equals("q")) {
        break;
      } else {
        this.runCommand(sc, command);
      }
      this.out.renderMessage("-> ");
    }
    this.out.renderMessage("Bye!\n");
  }

  /**
   * Runs a command.
   *
   * @param sc      Scanner to get args.
   * @param command Command to run.
   */
  private void runCommand(Scanner sc, String command) {
    Function<Scanner, ImageCommand> cmd = this.commands.getOrDefault(command, null);
    if (cmd == null) {
      this.out.renderMessage("Command '" + command + "' not found.\n");
    } else {
      ImageCommand c = null;
      try {
        c = cmd.apply(sc);
      } catch (IllegalArgumentException e) {
        this.out.renderMessage("Argument Error: " + e.getMessage() + "\n");
      }
      if (c != null) {
        try {
          c.apply(this.layers);
        } catch (IllegalStateException e) {
          this.out.renderMessage("Error: " + e.getMessage() + "\n");
        }
      }
    }
  }
}
