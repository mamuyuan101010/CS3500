package assigment4.adapters.output;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import assigment4.model.collagerProject.CollagerProject;
import assigment4.model.layer.Layer;

public class CollageProjectAdapter implements ViewAdapter{

  private CollagerProject c;

  public CollageProjectAdapter(CollagerProject c) {
    if (c == null) {
      throw new IllegalArgumentException("PPMView constructed with a null argument.");
    }
    else {
      this.c = c;
    }
  }

  /**
   * write the project file to the correct format
   */
  @Override
  public void write(String filename) throws IOException {
    FileWriter out;
    try {
      out = new FileWriter(new File(filename));
    } catch (IOException e) {
      throw new IllegalStateException("Collaging project could not open file for writing");
    }
    out.write("C1\n");
    out.write("" + this.c.getWidth() + " " + this.c.getHeight() + "\n");
    out.write("255\n");
    for (Layer la: this.c.getLayers()) {
      out.write(la.getLayerName() + " " + la.getFilter().toString());
    }
  }
}
