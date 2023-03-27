package assignment4.model;

/**
 * Represents that this object can be deep copied.
 * @param <R> type of object to copy.
 */
public interface Copyable<R> {

  /**
   * Returns a deep copy.
   * @return Returned copy.
   */
  public R copy();
}
