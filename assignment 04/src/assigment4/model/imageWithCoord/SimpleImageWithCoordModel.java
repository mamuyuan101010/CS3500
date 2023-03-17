package assigment4.model.imageWithCoord;

import assigment4.model.coord.Coordinate;
import assigment4.model.image.ImageModel;
import assigment4.model.image.SimpleImageModel;

public class SimpleImageWithCoordModel implements ImageWithCoordModel {
  private Coordinate coord;
  private ImageModel image;
  public SimpleImageWithCoordModel(Coordinate coord, ImageModel image) {
    this.coord = coord;
    this.image = image;
  }

  /**
   * return the coordinate value
   */
  public Coordinate getCoord() {
    Coordinate output = new Coordinate(0,0);
    output = this.coord;
    return output;
  }

  /**
   * return the image value
   */
  public ImageModel getImage() {
    ImageModel output = new SimpleImageModel();
    output = this.image;
    return output;
  }
}
