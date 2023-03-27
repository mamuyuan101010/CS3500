package assignment4.adapters.output;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

import assignment4.model.image.ImageModel;
import assignment4.model.pixel.Pixel;
import assignment4.model.project.ProjectModel;

/**
 * Adapter to write any imageModel to a .ppm file.
 */
public class PPMViewAdapter implements ViewAdapter {

  private final ProjectModel model;

  /**
   * Constructs a ppm adapter.
   *
   * @param model model to save as a ppm.
   */
  public PPMViewAdapter(ProjectModel model) {
    if (model == null) {
      throw new IllegalArgumentException("PPMView constructed with a null argument.");
    }

    this.model = model;
  }

  /**
   * write method that write files in ppm format.
   * @param filename
   * @throws IOException if the program cannot find the file using file name.
   */
  @Override
  public void write(String filename) throws IOException {
    FileWriter out;
    try {
      out = new FileWriter(new File(filename));
    } catch (IOException e) {
      throw new IllegalStateException("PPM could not open file for writing");
    }

    out.write("P3\n");
    out.write(String.valueOf(this.model.getWidth())
            + " "
            + String.valueOf(this.model.getHeight())
            + "\n");
    out.write(this.model.getMaxValue() + "\n");
    for (Map.Entry<String, ImageModel> entry : model.getProjectStructure().entrySet()) {
      if (entry.getValue().getType().equals("layer")) {
        for (int i = 0; i < entry.getValue().getHeight(); i++) {
          for (int j = 0; j < entry.getValue().getWidth(); j++) {
            Pixel p = entry.getValue().get(i, j).convertTo3Component();
            out.write(String.valueOf(p.getR()) + "\n");
            out.write(String.valueOf(p.getG()) + "\n");
            out.write(String.valueOf(p.getB()) + "\n");
          }
        }
      }

    }

    out.close();
  }
}
