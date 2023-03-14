package assigment4.view;

/**
 * This the interface for the view of textUI.
 */
public interface ImageView {

  /**
   * Renders message to terminal.
   * @param message message to render.
   * @throws IllegalStateException If the method cannot render.
   */
  void renderMessage(String message) throws IllegalStateException;
}
