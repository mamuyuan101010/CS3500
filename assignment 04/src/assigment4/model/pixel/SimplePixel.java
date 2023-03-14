package assigment4.model.pixel;

import java.util.Objects;

/**
 * Represents a simple pixel of rgb values.
 */
public class SimplePixel implements Pixel {

  private int r;
  private int g;
  private int b;

  private int a;


  /**
   * Constructs a simple pixel given rgb values.
   *
   * @param r red channel.
   * @param g green channel.
   * @param b blue channel.
   */
  public SimplePixel(int r, int g, int b) {
    if (r < 0 || r > 255 || g < 0 || g > 255 || b < 0 || b > 255) {
      throw new IllegalStateException("No value of a pixel can be less than 0 or bigger than 255");
    }
    this.r = r;
    this.g = g;
    this.b = b;

  }

  /**
   * Constructs a simple pixel given rgba values.
   *
   * @param r red channel.
   * @param g green channel.
   * @param b blue channel.
   */
  public SimplePixel(int r, int g, int b, int a) {
    if (r < 0 || r > 255 || g < 0 || g > 255 || b < 0 || b > 255 || a < 0 || a > 255) {
      throw new IllegalStateException("No value of a pixel can be less than 0 or bigger than 255");
    }
    this.r = r;
    this.g = g;
    this.b = b;
    this.a = a;
  }

  @Override
  public int getR() {
    return this.r;
  }

  @Override
  public int getG() {
    return this.g;
  }

  @Override
  public int getB() {
    return this.b;
  }

  @Override
  public int getA() {
    return this.a;
  }

  @Override
  public Pixel copy() {
    return new SimplePixel(this.r, this.g, this.b, this.a);
  }

  @Override
  public Pixel convertTo3Component() {
    int r = (int) Math.round(this.r * this.a / 255.0);
    int g = (int) Math.round(this.g * this.a / 255.0);
    int b = (int) Math.round(this.b * this.a / 255.0);

    return new SimplePixel(r, g, b);
  }

  @Override
  public String toString() {
    return String.valueOf(this.getR())
            + " " + String.valueOf(this.getG())
            + " " + String.valueOf(this.getB())
            + " " + String.valueOf(this.getA());
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof SimplePixel)) {
      return false;
    }
    SimplePixel that = (SimplePixel) o;
    return getR() == that.getR() && getG() == that.getG() && getB() == that.getB() &&
            getA() == that.getA();
  }

  @Override
  public int hashCode() {
    return Objects.hash(getR(), getG(), getB(), getA());
  }
}

