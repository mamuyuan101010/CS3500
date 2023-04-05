package assignment4.model.new_filter;

import assignment4.model.image.ImageModel;
import assignment4.model.image.SimpleImageModel;
import assignment4.model.pixel.Pixel;
import assignment4.model.pixel.SimplePixel;

public class InversionBlendingFilter extends AbstractFilter {

  /**
   * return the name of the filter.
   */
  @Override
  public String getName() {
    return "inversion-blending-filter";
  }


  /**
   * filter the two layer.
   */
  @Override
  public ImageModel filtering(ImageModel currentLayer, ImageModel layerBelow) {
    if (compareImageSize(currentLayer, layerBelow)) {
      Pixel[][] outputPixel = new Pixel[currentLayer.getHeight()][currentLayer.getWidth()];
      for (int i = 0; i < currentLayer.getHeight(); i ++) {
        for (int j = 0; j < currentLayer.getWidth(); j ++) {
          outputPixel[i][j] = new SimplePixel(0,0,0);
        }
      }
      ImageModel output = new SimpleImageModel(255, currentLayer.getHeight(),
              currentLayer.getWidth(), outputPixel, "image");
      for (int i = 0; i < currentLayer.getHeight(); i ++) {
        for (int j = 0; j < currentLayer.getWidth(); j ++) {
          outputPixel[i][j] = new SimplePixel(Math.abs(currentLayer.get(i,j).getR() -
                  layerBelow.get(i,j).getR()),
                  Math.abs(currentLayer.get(i,j).getG() -
                          layerBelow.get(i,j).getG()),
                  Math.abs(currentLayer.get(i,j).getB() -
                          layerBelow.get(i,j).getB()));
        }
      }
      return output;
    }
    else {
      throw new IllegalArgumentException("size does not fit");
    }
  }
}
