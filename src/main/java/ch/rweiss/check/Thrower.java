package ch.rweiss.check;

/**
 * Implementors throw a runtime exception
 * @author Reto Weiss
 * @since 0.0.1
 */
public interface Thrower
{
  /**
   * Implementors must throw a runtime exception with the given message
   * @param message
   */
  public void throwNow(String message);
}
