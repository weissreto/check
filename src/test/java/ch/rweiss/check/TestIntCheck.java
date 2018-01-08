package ch.rweiss.check;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

import ch.rweiss.check.Check;

public class TestIntCheck
{
  @Test
  public void isPositive()
  {
    Check.parameter("param").withValue(0).isPositive();
    Check.parameter("param").withValue(Integer.MAX_VALUE).isPositive();
    assertThatThrownBy(()->Check.parameter("param").withValue(-1).isPositive())
      .isInstanceOf(IllegalArgumentException.class)
      .hasMessage("Parameter param must be positive but is -1");
  }
  
  @Test
  public void isNegative()
  {
    Check.parameter("param").withValue(-1).isNegative();
    Check.parameter("param").withValue(Integer.MIN_VALUE).isNegative();
    assertThatThrownBy(()->Check.parameter("param").withValue(0).isNegative())
      .isInstanceOf(IllegalArgumentException.class)
      .hasMessage("Parameter param must be negative but is 0");
  }

  @Test
  public void isNotZero()
  {
    Check.parameter("param").withValue(-1).isNotZero();
    Check.parameter("param").withValue(1).isNotZero();
    assertThatThrownBy(()->Check.parameter("param").withValue(0).isNotZero())
      .isInstanceOf(IllegalArgumentException.class)
      .hasMessage("Parameter param must not be zero");
  }

  @Test
  public void isInRange()
  {
    Check.field("field").withValue(5).isInRange(2, 8);
    Check.field("field").withValue(2).isInRange(2, 8);
    Check.field("field").withValue(8).isInRange(2, 8);
    assertThatThrownBy(()->Check.field("field").withValue(1).isInRange(2, 8))
      .isInstanceOf(IllegalStateException.class)
      .hasMessage("Field field must be between 2 and 8 inclusive but is 1");
    assertThatThrownBy(()->Check.field("field").withValue(9).isInRange(2, 8))
      .isInstanceOf(IllegalStateException.class)
      .hasMessage("Field field must be between 2 and 8 inclusive but is 9");
  }
  
  @Test
  public void isLessOrEqualTo()
  {
    Check.state("state").withValue(5).isLessOrEqualTo(5);
    Check.state("state").withValue(Integer.MIN_VALUE).isLessOrEqualTo(5);
    assertThatThrownBy(()->Check.state("state").withValue(6).isLessOrEqualTo(5))
      .isInstanceOf(IllegalStateException.class)
      .hasMessage("State state must be less or equal to 5 but is 6");
  }

  @Test
  public void isLessThan()
  {
    Check.state("state").withValue(4).isLessThan(5);
    Check.state("state").withValue(Integer.MIN_VALUE).isLessThan(5);
    assertThatThrownBy(()->Check.state("state").withValue(5).isLessThan(5))
      .isInstanceOf(IllegalStateException.class)
      .hasMessage("State state must be less than 5 but is 5");
  }

  @Test
  public void isGreaterOrEqualTo()
  {
    Check.state("state").withValue(5).isGreaterOrEqualTo(5);
    Check.state("state").withValue(Integer.MAX_VALUE).isGreaterOrEqualTo(5);
    assertThatThrownBy(()->Check.state("state").withValue(4).isGreaterOrEqualTo(5))
      .isInstanceOf(IllegalStateException.class)
      .hasMessage("State state must be greater than or equal to 5 but is 4");
  }

  @Test
  public void isGreaterThan()
  {
    Check.state("state").withValue(6).isGreaterThan(5);
    Check.state("state").withValue(Integer.MAX_VALUE).isGreaterThan(5);
    assertThatThrownBy(()->Check.state("state").withValue(5).isGreaterThan(5))
      .isInstanceOf(IllegalStateException.class)
      .hasMessage("State state must be greater than 5 but is 5");
  }
  
  @Test
  public void isEqualTo()
  {
    Check.state("state").withValue(6).isEqualTo(6);
    assertThatThrownBy(()->Check.state("state").withValue(6).isEqualTo(5))
      .isInstanceOf(IllegalStateException.class)
      .hasMessage("State state must be equal to 5 but is 6");
  }

  @Test
  public void isNotEqualTo()
  {
    Check.state("state").withValue(6).isNotEqualTo(5);
    Check.state("state").withValue(4).isNotEqualTo(5);
    Check.state("state").withValue(Integer.MAX_VALUE).isNotEqualTo(5);
    Check.state("state").withValue(Integer.MIN_VALUE).isNotEqualTo(5);
    assertThatThrownBy(()->Check.state("state").withValue(5).isNotEqualTo(5))
      .isInstanceOf(IllegalStateException.class)
      .hasMessage("State state must not be equal to 5");
  }

}
