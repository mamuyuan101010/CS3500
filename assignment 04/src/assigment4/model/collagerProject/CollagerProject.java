package assigment4.model.collagerProject;

import java.util.List;

import assigment4.model.layer.Layer;

public interface CollagerProject {
  List<Layer> getLayers();
  int getHeight();
  int getWidth();
  void setHeight(int height);
  void setWidth(int width);
}
