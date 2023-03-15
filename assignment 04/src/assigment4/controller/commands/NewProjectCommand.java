package assigment4.controller.commands;

import java.util.Map;
import java.util.Scanner;

import assigment4.model.image.ImageModel;
import assigment4.model.image.SimpleImageModel;
import assigment4.model.pixel.Pixel;
import assigment4.model.pixel.SimplePixel;

public class NewProjectCommand extends AbstractCommand{

  public NewProjectCommand(Scanner s) {
    super(s);
  }

  @Override
  public void apply(Map<String, ImageModel> images) throws IllegalStateException {
    int height = this.getInt();
    int width = this.getInt();
    Pixel pixel = new SimplePixel(255, 255, 255, 255);
    ImageModel imageModel = new SimpleImageModel(255, height, width,
            new Pixel[height][width]);
    for (int i = 0; i < height; i++) {
      for (int j = 0; j < width; j++) {
        imageModel.set(i, j, pixel);
      }
    }
    images.put("canvas", imageModel);

  }
}
