package ch.weiss.check;

import java.util.Objects;

/**
 * Abstract base implementation for all reference typed checks.  
 * @author Reto Weiss
 * @since 0.0.1
 */
@SuppressWarnings("unchecked")
public abstract class AbstractObjectCheck<C extends AbstractObjectCheck<C, T>, T> extends AbstractCheck
{
  protected final T value;

  public AbstractObjectCheck(T value, Thrower thrower)
  {
    super(thrower);
    this.value = value;
  }
  
  public C isNotNull()
  {
    if (value == null)
    {
      fail("must not be null");
    }
    return me();
  }
  
  public C isNull()
  {
    if (value != null)
    {
      fail("must be null");
    }
    return me();
  }
  
  public C isEqualTo(T otherValue)
  {
    if (!Objects.equals(value, otherValue))
    {
      fail("must be equal to {0} but is {1}", otherValue, value);
    }
    return me();
  }
  
  public C isNotEqualTo(T otherValue)
  {
    if (Objects.equals(value, otherValue))
    {
      fail("must not be equal to {0}", otherValue);
    }
    return me();
  }
  
  protected C me()
  {
    return (C)this;
  }
}
