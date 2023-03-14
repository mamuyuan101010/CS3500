package assigment4.adapters.output;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import assigment4.model.image.ImageModel;
import assigment4.model.pixel.Pixel;

/**
 * Adapter to write any imageModel to a .ppm file.
 */
public class PPMViewAdapter implements ViewAdapter {

  private final ImageModel model;

  /**
   * Constructs a ppm adapter.
   *
   * @param model model to save as a ppm.
   */
  public PPMViewAdapter(ImageModel model) {
    if (model == null) {
      throw new IllegalArgumentException("PPMView constructed with a null argument.");
    }

    this.model = model;
  }


  @Override
  public void write(String filename) throws IOException {
    FileWriter out;
    try {
      out = new FileWriter(new File(filename));
    } catch (IOException e) {
      throw new IllegalStateException("PPM could not open file for writing");
    }

    out.write("C1\n");
    out.write(String.valueOf(this.model.getWidth())
            + " "
            + String.valueOf(this.model.getHeight())
            + "\n");
    out.write(this.model.getMaxValue() + "\n");
    for (int i = 0; i < this.model.getHeight(); i++) {
      for (int j = 0; j < this.model.getWidth(); j++) {
        Pixel p = this.model.get(i, j);
        out.write(String.valueOf(p.getR()) + "\n");
        out.write(String.valueOf(p.getG()) + "\n");
        out.write(String.valueOf(p.getB()) + "\n");
        out.write(String.valueOf(p.getA()) + "\n");
      }
    }
    out.close();
  }
}
