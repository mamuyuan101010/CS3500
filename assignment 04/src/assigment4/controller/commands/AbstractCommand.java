package assigment4.controller.commands;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import assigment4.model.coord.Coordinate;
import assigment4.model.filter.Filter;
import assigment4.model.image.ImageModel;
import assigment4.model.image.SimpleImageModel;
import assigment4.model.imageWithCoord.ImageWithCoordModel;
import assigment4.model.imageWithCoord.SimpleImageWithCoordModel;
import assigment4.model.layer.Layer;
import assigment4.model.layer.SimpleLayer;
import assigment4.model.pixel.Pixel;
import assigment4.model.pixel.SimplePixel;

/**
 * Abstract command that holds common command functions.
 */
public abstract class AbstractCommand implements ImageCommand {

  protected final Scanner sc;
  protected String helpMessage = "A command that may be applied to an ImageModel.";

  /**
   * Constructs an Abstract command.
   */
  protected AbstractCommand(Scanner sc) {
    if (sc == null) {
      throw new IllegalArgumentException("Command scanner is null");
    }
    this.sc = sc;
  }

  @Override
  public String help() {
    return this.helpMessage;
  }

  /**
   * Gets a String input.
   *
   * @return String input.
   */
  protected String getString() {
    if (this.sc.hasNext()) {
      return this.sc.next();
    } else {
      throw new IllegalStateException();
    }
  }

  /**
   * Gets an integer input.
   *
   * @return int input.
   */
  protected int getInt() {
    while (this.sc.hasNext() && !this.sc.hasNextInt()) {
      this.sc.next();
    }
    if (this.sc.hasNextInt()) {
      return this.sc.nextInt();
    } else {
      throw new IllegalStateException();
    }
  }

  /**
   * Gets a double input.
   *
   * @return double input.
   */
  protected double getDouble() {
    while (this.sc.hasNext() && !this.sc.hasNextDouble()) {
      this.sc.next();
    }
    if (this.sc.hasNextDouble()) {
      return this.sc.nextDouble();
    } else {
      throw new IllegalStateException();
    }
  }

  public Layer generateEmptyLayer(int height, int width) {
    Pixel pixel = new SimplePixel(255, 255, 255);
    ImageModel imageModel = new SimpleImageModel(255, height, width,
            new Pixel[height][width]);
    for (int i = 0; i < height; i++) {
      for (int j = 0; j < width; j++) {
        imageModel.set(i, j, pixel);
      }
    }
    ImageWithCoordModel imageModelCoord =
            new SimpleImageWithCoordModel(new Coordinate(0, 0), imageModel);
    List<ImageWithCoordModel> background = new ArrayList<ImageWithCoordModel>();
    background.add(imageModelCoord);
    return new SimpleLayer(Filter.Normal, background, "background", height, width);
  }
}

