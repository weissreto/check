package ch.weiss.check;

/**
 * Abstract thrower implemention
 * @author Reto Weiss
 * @since 0.0.1
 */
public abstract class AbstractThrower implements Thrower
{
  private final String what;
  private final String name;

  public AbstractThrower(String what, String name)
  {
    this.what = what;
    this.name = name;
  }
  
  public String what()
  {
    return what;
  }
  
  public String name()
  {
    return name;
  }
}
