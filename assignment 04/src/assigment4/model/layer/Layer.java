package assigment4.model.layer;

import java.util.Map;

import assigment4.model.coord.Coordinate;
import assigment4.model.filter.Filter;
import assigment4.model.image.ImageModel;
import assigment4.model.imageWithCoord.ImageWithCoordModel;

public interface Layer {
  Filter getFilter();
  Map<String, ImageWithCoordModel> getImages();
  String getLayerName();
  int getHeight();
  int getWidth();
}
