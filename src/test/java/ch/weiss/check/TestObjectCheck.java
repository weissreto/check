package ch.weiss.check;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class TestObjectCheck
{
  @Test
  public void isNull()
  {
    Check.parameter("param").withValue(null).isNull();
    assertThatThrownBy(()->Check.parameter("param").withValue(new Object()).isNull())
      .isInstanceOf(IllegalArgumentException.class)
      .hasMessage("Parameter param must be null");
  }
  
  @Test
  public void isNotNull()
  {
    Check.parameter("param").withValue(new Object()).isNotNull();
    assertThatThrownBy(()->Check.parameter("param").withValue(null).isNotNull())
      .isInstanceOf(IllegalArgumentException.class)
      .hasMessage("Parameter param must not be null");
  }
  
  @Test
  public void isEqualTo()
  {
    Check.field("field").withValue(new Long(12)).isEqualTo(new Long(12));
    assertThatThrownBy(()->Check.field("field").withValue(new Long(12)).isEqualTo(new Long(0)))
      .isInstanceOf(IllegalStateException.class)
      .hasMessage("Field field must be equal to 0 but is 12");
  }
  
  @Test
  public void isNotEqualTo()
  {
    Check.field("field").withValue(new Long(12)).isNotEqualTo(new Long(0));
    assertThatThrownBy(()->Check.field("field").withValue(new Long(12)).isNotEqualTo(new Long(12)))
      .isInstanceOf(IllegalStateException.class)
      .hasMessage("Field field must not be equal to 12");
  }

}
