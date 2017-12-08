package ch.weiss.check;

/**
 * Checks for int
 * @author Reto Weiss
 * @since 0.0.1
 */
public class IntCheck extends AbstractCheck
{
  private final int value;
  
  IntCheck(int value, Thrower thrower)
  {
    super(thrower);
    this.value = value;
  }
  
  public IntCheck isPositive()
  {
    if (value < 0)
    {
      fail("must be positive but is {0}", value);
    }
    return this;
  }
  
  public IntCheck isNegative()
  {
    if (value >= 0)
    {
      fail("must be negative but is {0}", value);
    }
    return this;
  }


  public IntCheck isInRange(int lowerBoundInclusive, int upperBoundInclusive)
  {
    if (value < lowerBoundInclusive || value > upperBoundInclusive)
    {
      fail("must be between {0} and {1} inclusive but is {2}", lowerBoundInclusive, upperBoundInclusive, value);
    }
    return this;
  }
  
  public IntCheck isNotZero()
  {
    if (value == 0)
    {
      fail("must not be zero");
    }
    return this;
  }

  public IntCheck isLessOrEqualTo(int greaterOrEqual)
  {
    if (value > greaterOrEqual)
    {
      fail("must be less or equal to {0} but is {1}", greaterOrEqual, value);
    }
    return this;
  }

  public IntCheck isLessThan(int greater)
  {
    if (value >= greater)
    {
      fail("must be less than {0} but is {1}", greater, value);
    }
    return this;
  }
  
  public IntCheck isGreaterOrEqualTo(int lessOrEqual)
  {
    if (value < lessOrEqual)
    {
      fail("must be greater than or equal to {0} but is {1}", lessOrEqual, value);
    }
    return this;
  }

  public IntCheck isGreaterThan(int less)
  {
    if (value <= less)
    {
      fail("must be greater than {0} but is {1}", less, value);
    }
    return this;
  }
  
  public IntCheck isEqualTo(int other)
  {
    if (value != other)
    {
      fail("must be equal to {0} but is {1}", other, value);
    }
    return this;
  }

  public IntCheck isNotEqualTo(int other)
  {
    if (value == other)
    {
      fail("must not be equal to {0}", other);
    }
    return this;
  }

}
