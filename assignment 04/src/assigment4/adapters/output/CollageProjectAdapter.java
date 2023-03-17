package assigment4.adapters.output;

import java.awt.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import assigment4.model.collagerProject.CollagerProject;
import assigment4.model.imageWithCoord.SimpleImageWithCoordModel;
import assigment4.model.layer.Layer;
import assigment4.model.pixel.Pixel;
import assigment4.model.pixel.SimplePixel;

public class CollageProjectAdapter implements ViewAdapter{

  private CollagerProject c;

  public CollageProjectAdapter(CollagerProject c) {
    if (c == null) {
      throw new IllegalArgumentException("CollageProject constructed with a null argument.");
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
      int layerSize = la.getImages().size();
      Pixel[][] renderImage = new Pixel[la.getHeight()][la.getWidth()];
      for (int i = 0; i < la.getHeight(); i++) {
        for (int j = 0; j < la.getWidth(); j ++) {
          renderImage[i][j] = la.getImages().get(0).getImage().get(i, j);
        }
      }
      if (layerSize > 1) {
        for (int a = 1; a < layerSize; a ++) {
          for (int i = la.getImages().get(a).getCoord().getY(); i < la.getHeight(); i ++) {
            for (int j = la.getImages().get(a).getCoord().getX(); j < la.getWidth(); j ++) {
              int imageX = la.getImages().get(a).getCoord().getX();
              int imageY = la.getImages().get(a).getCoord().getY();
              Color background = new Color(renderImage[i][j].getR(),
                      renderImage[i][j].getG(), renderImage[i][j].getB(),
                      renderImage[i][j].getA()); // create a background color
              Color foreground = new Color(
                      la.getImages().get(a).getImage().get(i - imageY, j - imageX).getR(),
                      la.getImages().get(a).getImage().get(i - imageY, j - imageX).getG(),
                      la.getImages().get(a).getImage().get(i - imageY, j - imageX).getB(),
                      la.getImages().get(a).getImage().get(i - imageY, j - imageX).getA());
              // create an RGBA foreground color
              int red = (foreground.getRed() * foreground.getAlpha() + background.getRed() * (255 - foreground.getAlpha())) / 255;
              int green = (foreground.getGreen() * foreground.getAlpha() + background.getGreen() * (255 - foreground.getAlpha())) / 255;
              int blue = (foreground.getBlue() * foreground.getAlpha() + background.getBlue() * (255 - foreground.getAlpha())) / 255;
              int alpha = foreground.getAlpha() + background.getAlpha() * (255 - foreground.getAlpha()) / 255;
              renderImage[i][j] = new SimplePixel(red, green, blue, alpha);
            }
          }
        }
      }
      for (int i = 0; i < renderImage.length; i ++) {
        for (int j = 0; j < renderImage[0].length; j ++) {
          out.write("" + renderImage[i][j].getR() + " " +
                  renderImage[i][j].getG() + " " +
                  renderImage[i][j].getB() + " " +
                  renderImage[i][j].getA() + "\n");
        }
      }
    }
  }
}
