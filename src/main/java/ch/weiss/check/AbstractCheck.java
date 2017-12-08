package ch.weiss.check;

import java.text.MessageFormat;

/**
 * Abstract check implementation
 * @author Reto Weiss
 * @since 0.0.1
 */
public abstract class AbstractCheck
{
  private final Thrower thrower;

  public AbstractCheck(Thrower thrower)
  {
    this.thrower = thrower;
  }
  
  public void fail(String message, Object... arguments)
  {
    String msg = MessageFormat.format(message, arguments);
    thrower.throwNow(msg);
  }
}
