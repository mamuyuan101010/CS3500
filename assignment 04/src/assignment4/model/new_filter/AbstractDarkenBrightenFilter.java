package assignment4.model.new_filter;

import assignment4.model.image.ImageModel;
import assignment4.model.pixel.HSLPixel;
import assignment4.model.pixel.SimplePixel;

public abstract class AbstractDarkenBrightenFilter implements New_filter{
  void HSLConvert(ImageModel img) {
    for (int i = 0; i < img.getHeight(); i ++) {
      for (int j = 0; j < img.getWidth(); j ++) {
        SimplePixel smp = (SimplePixel) img.get(i,j);
        img.set(i,j,smp.convertToHSL());
      }
    }
  }

  void RGBConvert(ImageModel img) {
    for (int i = 0; i < img.getHeight(); i ++) {
      for (int j = 0; j < img.getWidth(); j++) {
        HSLPixel hsl = (HSLPixel) img.get(i,j);
        img.set(i,j,hsl.convertToRGB());
      }
    }
  }


}
