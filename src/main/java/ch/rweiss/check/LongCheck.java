package ch.rweiss.check;

/**
 * Checks for long
 * @author Reto Weiss
 * @since 0.3.0
 */
public class LongCheck extends AbstractCheck
{
  private final long value;
  
  LongCheck(long value, Thrower thrower)
  {
    super(thrower);
    this.value = value;
  }
  
  public LongCheck isPositive()
  {
    if (value < 0)
    {
      fail("must be positive but is {0}", value);
    }
    return this;
  }
  
  public LongCheck isNegative()
  {
    if (value >= 0)
    {
      fail("must be negative but is {0}", value);
    }
    return this;
  }


  public LongCheck isInRange(long lowerBoundInclusive, long upperBoundInclusive)
  {
    if (value < lowerBoundInclusive || value > upperBoundInclusive)
    {
      fail("must be between {0} and {1} inclusive but is {2}", lowerBoundInclusive, upperBoundInclusive, value);
    }
    return this;
  }
  
  public LongCheck isNotZero()
  {
    if (value == 0)
    {
      fail("must not be zero");
    }
    return this;
  }

  public LongCheck isLessOrEqualTo(long greaterOrEqual)
  {
    if (value > greaterOrEqual)
    {
      fail("must be less or equal to {0} but is {1}", greaterOrEqual, value);
    }
    return this;
  }

  public LongCheck isLessThan(long greater)
  {
    if (value >= greater)
    {
      fail("must be less than {0} but is {1}", greater, value);
    }
    return this;
  }
  
  public LongCheck isGreaterOrEqualTo(long lessOrEqual)
  {
    if (value < lessOrEqual)
    {
      fail("must be greater than or equal to {0} but is {1}", lessOrEqual, value);
    }
    return this;
  }

  public LongCheck isGreaterThan(long less)
  {
    if (value <= less)
    {
      fail("must be greater than {0} but is {1}", less, value);
    }
    return this;
  }
  
  public LongCheck isEqualTo(long other)
  {
    if (value != other)
    {
      fail("must be equal to {0} but is {1}", other, value);
    }
    return this;
  }

  public LongCheck isNotEqualTo(long other)
  {
    if (value == other)
    {
      fail("must not be equal to {0}", other);
    }
    return this;
  }

}
