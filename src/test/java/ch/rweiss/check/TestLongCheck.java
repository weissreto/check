package ch.rweiss.check;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class TestLongCheck
{
  @Test
  public void isPositive()
  {
    Check.parameter("param").withValue(0L).isPositive();
    Check.parameter("param").withValue(Long.MAX_VALUE).isPositive();
    assertThatThrownBy(()->Check.parameter("param").withValue(-1L).isPositive())
      .isInstanceOf(IllegalArgumentException.class)
      .hasMessage("Parameter param must be positive but is -1");
  }
  
  @Test
  public void isNegative()
  {
    Check.parameter("param").withValue(-1L).isNegative();
    Check.parameter("param").withValue(Long.MIN_VALUE).isNegative();
    assertThatThrownBy(()->Check.parameter("param").withValue(0L).isNegative())
      .isInstanceOf(IllegalArgumentException.class)
      .hasMessage("Parameter param must be negative but is 0");
  }

  @Test
  public void isNotZero()
  {
    Check.parameter("param").withValue(-1L).isNotZero();
    Check.parameter("param").withValue(1L).isNotZero();
    assertThatThrownBy(()->Check.parameter("param").withValue(0L).isNotZero())
      .isInstanceOf(IllegalArgumentException.class)
      .hasMessage("Parameter param must not be zero");
  }

  @Test
  public void isInRange()
  {
    Check.field("field").withValue(5L).isInRange(2l, 8L);
    Check.field("field").withValue(2L).isInRange(2l, 8L);
    Check.field("field").withValue(8L).isInRange(2l, 8L);
    assertThatThrownBy(()->Check.field("field").withValue(1L).isInRange(2L, 8L))
      .isInstanceOf(IllegalStateException.class)
      .hasMessage("Field field must be between 2 and 8 inclusive but is 1");
    assertThatThrownBy(()->Check.field("field").withValue(9L).isInRange(2L, 8L))
      .isInstanceOf(IllegalStateException.class)
      .hasMessage("Field field must be between 2 and 8 inclusive but is 9");
  }
  
  @Test
  public void isLessOrEqualTo()
  {
    Check.state("state").withValue(5L).isLessOrEqualTo(5L);
    Check.state("state").withValue(Long.MIN_VALUE).isLessOrEqualTo(5L);
    assertThatThrownBy(()->Check.state("state").withValue(6L).isLessOrEqualTo(5L))
      .isInstanceOf(IllegalStateException.class)
      .hasMessage("State state must be less or equal to 5 but is 6");
  }

  @Test
  public void isLessThan()
  {
    Check.state("state").withValue(4L).isLessThan(5L);
    Check.state("state").withValue(Long.MIN_VALUE).isLessThan(5L);
    assertThatThrownBy(()->Check.state("state").withValue(5L).isLessThan(5L))
      .isInstanceOf(IllegalStateException.class)
      .hasMessage("State state must be less than 5 but is 5");
  }

  @Test
  public void isGreaterOrEqualTo()
  {
    Check.state("state").withValue(5L).isGreaterOrEqualTo(5L);
    Check.state("state").withValue(Long.MAX_VALUE).isGreaterOrEqualTo(5L);
    assertThatThrownBy(()->Check.state("state").withValue(4L).isGreaterOrEqualTo(5L))
      .isInstanceOf(IllegalStateException.class)
      .hasMessage("State state must be greater than or equal to 5 but is 4");
  }

  @Test
  public void isGreaterThan()
  {
    Check.state("state").withValue(6L).isGreaterThan(5L);
    Check.state("state").withValue(Long.MAX_VALUE).isGreaterThan(5L);
    assertThatThrownBy(()->Check.state("state").withValue(5L).isGreaterThan(5L))
      .isInstanceOf(IllegalStateException.class)
      .hasMessage("State state must be greater than 5 but is 5");
  }
  
  @Test
  public void isEqualTo()
  {
    Check.state("state").withValue(6L).isEqualTo(6L);
    assertThatThrownBy(()->Check.state("state").withValue(6L).isEqualTo(5L))
      .isInstanceOf(IllegalStateException.class)
      .hasMessage("State state must be equal to 5 but is 6");
  }

  @Test
  public void isNotEqualTo()
  {
    Check.state("state").withValue(6L).isNotEqualTo(5L);
    Check.state("state").withValue(4L).isNotEqualTo(5L);
    Check.state("state").withValue(Long.MAX_VALUE).isNotEqualTo(5L);
    Check.state("state").withValue(Long.MIN_VALUE).isNotEqualTo(5L);
    assertThatThrownBy(()->Check.state("state").withValue(5L).isNotEqualTo(5L))
      .isInstanceOf(IllegalStateException.class)
      .hasMessage("State state must not be equal to 5");
  }
}
