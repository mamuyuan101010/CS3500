package assigment4.model.layer;

import java.util.List;
import java.util.Map;

import assigment4.model.filter.Filter;
import assigment4.model.imageWithCoord.ImageWithCoordModel;

public interface Layer {
  Filter getFilter();
  void setFilter(Filter filter);
  List<ImageWithCoordModel> getImages();
  String getLayerName();
  int getHeight();
  int getWidth();
}
