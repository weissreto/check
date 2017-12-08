package ch.weiss.check;

/**
 * Checks for {@link String}
 * @author Reto Weiss
 * @since 0.0.1
 */
public class StringCheck extends AbstractObjectCheck<StringCheck, String>
{
  StringCheck(String value, Thrower thrower)
  {
    super(value, thrower);
  }
  
  public StringCheck isEmpty()
  {
    if (value != null && !value.isEmpty())
    {
      fail("must be empty but is {0}", value);
    }
    return me();
  }
  
  public StringCheck isNotEmpty()
  {
    if (value == null || value.isEmpty())
    {
      fail("must not be empty");
    }
    return me();
  }
  
  public StringCheck isBlank()
  {
    if (value != null && !value.trim().isEmpty())
    {
      fail("must be blank but is {0}", value);
    }
    return me();
  }
  
  public StringCheck isNotBlank()
  {
    if (value == null || value.trim().isEmpty())
    {
      fail("must not be blank");
    }
    return me();
  }
  
  public StringCheck startsWith(String suffix)
  {
    isNotNull();
    if (!value.startsWith(suffix))
    {
      fail("must start with {0} but is {1}", suffix, value);
    }
    return me();
  }
  
  public StringCheck endsWith(String postfix)
  {
    isNotNull();
    if (!value.endsWith(postfix))
    {
      fail("must end with {0} but is {1}", postfix, value);
    }
    return me();
  }

}
