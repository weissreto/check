package ch.rweiss.check;

/**
 * Throws {@link IllegalStateException}
 * @author Reto Weiss
 * @since 0.0.1
 */
public class IllegalStateThrower extends AbstractThrower
{
  public IllegalStateThrower(String what, String name)
  {
    super(what, name);
  }

  @Override
  public void throwNow(String message)
  {
    throw new IllegalStateException(what()+" "+name()+" "+message);
  }

}
