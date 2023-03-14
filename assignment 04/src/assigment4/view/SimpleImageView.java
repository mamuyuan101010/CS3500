package assigment4.view;

import java.io.IOException;

/**
 * This class renders the message that the program will produce according to the client input.
 */
public class SimpleImageView implements ImageView {

  private final Appendable out;

  /**
   * Creates a terminal printer.
   * @param out the output of the program.
   */
  public SimpleImageView(Appendable out) {
    if (out == null) {
      throw new IllegalArgumentException("The out is null.");
    }
    this.out = out;
  }

  @Override
  public void renderMessage(String message) throws IllegalStateException {
    try {
      this.out.append(message);
    } catch (IOException e) {
      throw new IllegalStateException("View could not render message");
    }
  }
}

