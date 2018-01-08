package ch.rweiss.check;

/**
 * Checks for {@link Object}
 * @author Reto Weiss
 * @since 0.0.1
 */
public class ObjectCheck extends AbstractObjectCheck<ObjectCheck, Object>
{
  ObjectCheck(Object value, Thrower thrower)
  {
    super(value, thrower);
  }
}
