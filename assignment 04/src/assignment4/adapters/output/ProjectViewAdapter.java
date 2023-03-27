package assignment4.adapters.output;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

import assignment4.model.image.ImageModel;
import assignment4.model.pixel.Pixel;
import assignment4.model.project.ProjectModel;

public class ProjectViewAdapter implements ViewAdapter {
  private final ProjectModel model;

  public ProjectViewAdapter(ProjectModel model) {
    if (model == null) {
      throw new IllegalArgumentException("ProjectView constructed with a null argument.");
    }
    this.model = model;
  }

  @Override
  public void write(String filename) throws IOException {
    FileWriter out;
    try {
      out = new FileWriter(new File(filename));
    } catch (IOException e) {
      throw new IllegalStateException("Project could not open file for writing");
    }
    out.write("C1\n");
    out.write("" + this.model.getWidth() + " " + this.model.getHeight() + "\n");
    out.write(this.model.getMaxValue() + "\n");
    for (Map.Entry<String, ImageModel> entry : model.getProjectStructure().entrySet()) {
        out.write(entry.getKey() + " " + entry.getValue().getFilter().getName() + "\n");
        for (int i = 0; i < entry.getValue().getHeight(); i++) {
          for (int j = 0; j < entry.getValue().getWidth(); j++) {
            Pixel p = entry.getValue().get(i, j);
            out.write(String.valueOf(p.getR()) + "\n");
            out.write(String.valueOf(p.getG()) + "\n");
            out.write(String.valueOf(p.getB()) + "\n");
            out.write(String.valueOf(p.getA()) + "\n");
          }
        }
    }
    out.close();
  }
}
