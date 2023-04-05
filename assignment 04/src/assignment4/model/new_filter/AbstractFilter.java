package assignment4.model.new_filter;

import assignment4.model.image.ImageModel;
import assignment4.model.image.SimpleImageModel;
import assignment4.model.pixel.HSLPixel;
import assignment4.model.pixel.Pixel;
import assignment4.model.pixel.SimplePixel;

public abstract class AbstractFilter implements New_filter{
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

  ImageModel emptyImage(int height, int width) {
    Pixel[][] outputPixel = new Pixel[height][width];
    for (int i = 0; i < height; i ++) {
      for (int j = 0; j < width; j ++) {
        outputPixel[i][j] = new SimplePixel(0,0,0);
      }
    }
    ImageModel output = new SimpleImageModel(255, height,
            width, outputPixel,"image");
    return output;
  }

  boolean compareImageSize(ImageModel currentLayer, ImageModel layerBelow) {
    return currentLayer.getHeight() == layerBelow.getHeight()
            && currentLayer.getWidth() == layerBelow.getWidth();
  }

}
