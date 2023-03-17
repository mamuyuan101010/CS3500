package assigment4.model.collagerProject;

import java.util.List;
import assigment4.model.layer.Layer;

public class SimpleCollagerProject implements CollagerProject {
  List<Layer> layers;
  int height;
  int width;
  public SimpleCollagerProject(List<Layer> layers, int height, int width) {
    this.layers = layers;
    this.height = height;
    this.width = width;
  }

  @Override
  public List<Layer> getLayers() {
    return this.layers;
  }

  @Override
  public int getHeight() {
    return this.height;
  }

  @Override
  public int getWidth() {
    return this.width;
  }

  @Override
  public void setHeight(int height) {
    this.height = height;
  }

  @Override
  public void setWidth(int width) {
    this.width = width;
  }
}
