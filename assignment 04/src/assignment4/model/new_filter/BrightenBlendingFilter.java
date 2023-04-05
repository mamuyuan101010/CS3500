package assignment4.model.new_filter;

import assignment4.model.image.ImageModel;
import assignment4.model.pixel.HSLPixel;
import assignment4.model.pixel.Pixel;

public class BrightenBlendingFilter extends AbstractFilter{
  @Override
  public String getName() {
    return "brighten-blending-filter";
  }

  @Override
  public ImageModel filtering(ImageModel currentLayer, ImageModel layerBelow) {
    if (compareImageSize(currentLayer, layerBelow)) {
      ImageModel output = emptyImage(currentLayer.getHeight(), currentLayer.getWidth());
      HSLConvert(currentLayer);
      HSLConvert(layerBelow);
      for (int i = 0; i < currentLayer.getHeight(); i++) {
        for (int j = 0; j < currentLayer.getWidth(); j++) {
          HSLPixel currentHsl = (HSLPixel) currentLayer.get(i, j);
          HSLPixel HslBelow = (HSLPixel) layerBelow.get(i, j);
          Pixel newHsl = new HSLPixel(currentHsl.getH(), currentHsl.getS(),
                  (1 - ((1 - currentHsl.getL()) * (1 - HslBelow.getL()))));
          output.set(i, j, newHsl);
        }
      }
      RGBConvert(output);
      return output;
    }
    else {
      throw new IllegalArgumentException("size does not fit");
    }
  }
}
