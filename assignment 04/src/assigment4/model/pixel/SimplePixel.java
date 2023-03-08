package assigment4.model.pixel;

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
  public SimplePixel(int r, int g, int b, int a) {
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
  public String toString() {
    return String.valueOf(this.getR())
            + " " + String.valueOf(this.getG())
            + " " + String.valueOf(this.getB());
  }
}

