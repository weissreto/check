package ch.weiss.check;

/**
 * Throws {@link IllegalArgumentException}
 * @author Reto Weiss
 * @since 0.0.1
 */
public class IllegalArgumentThrower extends AbstractThrower
{
  public IllegalArgumentThrower(String what, String name)
  {
    super(what, name);
  }

  @Override
  public void throwNow(String message)
  {
    throw new IllegalArgumentException(what()+" "+name()+" "+message);
  }
}
