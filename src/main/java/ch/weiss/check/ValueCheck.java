package ch.weiss.check;

/**
 * Checks values of different types. Splits to type specific checks.
 * @author Reto Weiss
 * @since 0.0.1
 */
public class ValueCheck
{
  private final Thrower thrower;
  
  ValueCheck(Thrower thrower)
  {
    this.thrower = thrower;
  }
  
  public ObjectCheck withValue(Object value)
  {
    return new ObjectCheck(value, thrower);
  }
  
  public IntCheck withValue(int value)
  {
    return new IntCheck(value, thrower);
  }
  
  public StringCheck withValue(String value)
  {
    return new StringCheck(value, thrower);
  }
}