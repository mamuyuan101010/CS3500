package assignment4.model.pixel;

public class HSLPixel implements Pixel {
  private double H;
  private double S;
  private double L;

  /**
   * constructor f HSL Pixel, throw exception if not valid.
   */
  public HSLPixel(double H, double S, double L) {
    if (validHSL(H, S, L)) {
      this.H = H;
      this.S = S;
      this.L = L;
    } else {
      throw new IllegalArgumentException("invalid HSL value");
    }
  }

  /**
   * identify whether the HSL value is valid.
   */
  public boolean validHSL(double H, double S, double L) {
    return H >= 0 && H <= 360 && S >= 0 && S <= 1 && L >= 0 && L <= 1;
  }

  @Override
  public int getR() {
    throw new IllegalStateException("not a RGB value");
  }

  @Override
  public int getG() {
    throw new IllegalStateException("not a RGB value");
  }

  @Override
  public int getB() {
    throw new IllegalStateException("not a RGB value");
  }

  @Override
  public int getA() {
    throw new IllegalStateException("not a RGB value");
  }

  public double getH() {
    return this.H;
  }

  public double getS() {
    return this.S;
  }

  public double getL() {
    return this.L;
  }
  /**
   * return a new HSLPixel which has the same HSL number but a totally different new
   * pixel.
   * This is for avoid alias.
   */
  @Override
  public Pixel copy() {
    double newH = this.H;
    double newS = this.S;
    double newL = this.L;
    return new HSLPixel(newH, newS, newL);
  }

  @Override
  public Pixel convertTo3Component() {
    throw new IllegalStateException("not a RGB value");
  }

  /**
   * convert the current HSL to RGB
   * @return
   */
  public Pixel convertToRGB() {
    double hue = this.H;
    double saturation = this.S;
    double lightness = this.L;
    double r=  convertFn(hue, saturation, lightness, 0) * 255;
    double g = convertFn(hue, saturation, lightness, 8) * 255;
    double b = convertFn(hue, saturation, lightness, 4) * 255;
    int R = (int) r;
    int G = (int) g;
    int B = (int) b;
    return new SimplePixel(R, G, B);
  }

  /**
   * Helper method that performs the translation from the HSL polygonal
   * model to the more familiar RGB model
   */
  private double convertFn(double hue, double saturation, double lightness, int n) {
    double k = (n + (hue/30)) % 12;
    double a  = saturation * Math.min(lightness, 1 - lightness);

    return lightness - a * Math.max(-1, Math.min(k - 3, Math.min(9 - k, 1)));
  }
}
