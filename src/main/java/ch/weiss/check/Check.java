package ch.weiss.check;

/**
 * Staring point of the Check framework
 * Examples:
 * <code><pre>
 * Check.parameter("x").value(x).isPositive();
 * </pre></code>
 * <code><pre>
 * Check.field("name").value(name).isNotNull();
 * </pre></check>
 * @author Reto Weiss
 * @since 0.0.1
 */
public class Check
{
  public static final ValueCheck parameter(String parameterName)
  {
    return new ValueCheck(new IllegalArgumentThrower("Parameter", parameterName));
  }
  
  public static final ValueCheck field(String fieldName)
  {
    return new ValueCheck(new IllegalStateThrower("Field", fieldName));
  }  
  
  public static final ValueCheck state(String stateName)
  {
    return new ValueCheck(new IllegalStateThrower("State", stateName));
  }
  
  public static final ValueCheck thing(Thrower thrower)
  {
    return new ValueCheck(thrower);
  }
}
