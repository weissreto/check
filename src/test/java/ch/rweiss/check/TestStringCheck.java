package ch.rweiss.check;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

import ch.rweiss.check.Check;

public class TestStringCheck
{
  @Test
  public void isEmpty()
  {
    Check.parameter("param").withValue(null).isEmpty();
    Check.parameter("param").withValue("").isEmpty();
    assertThatThrownBy(()->Check.parameter("param").withValue(" ").isEmpty())
      .isInstanceOf(IllegalArgumentException.class)
      .hasMessage("Parameter param must be empty but is  ");
    assertThatThrownBy(()->Check.parameter("param").withValue("hi").isEmpty())
      .isInstanceOf(IllegalArgumentException.class)
      .hasMessage("Parameter param must be empty but is hi");
  }
  
  @Test
  public void isNotEmpty()
  {
    Check.parameter("param").withValue(" ").isNotEmpty();
    Check.parameter("param").withValue("hi").isNotEmpty();
    assertThatThrownBy(()->Check.parameter("param").withValue(null).isNotEmpty())
      .isInstanceOf(IllegalArgumentException.class)
      .hasMessage("Parameter param must not be empty");
    assertThatThrownBy(()->Check.parameter("param").withValue("").isNotEmpty())
      .isInstanceOf(IllegalArgumentException.class)
      .hasMessage("Parameter param must not be empty");
  }

  @Test
  public void isBlank()
  {
    Check.parameter("param").withValue(null).isBlank();
    Check.parameter("param").withValue("").isBlank();
    Check.parameter("param").withValue(" ").isBlank();
    Check.parameter("param").withValue("   ").isBlank();
    Check.parameter("param").withValue("\t\r\n").isBlank();
    assertThatThrownBy(()->Check.parameter("param").withValue("   h   ").isBlank())
      .isInstanceOf(IllegalArgumentException.class)
      .hasMessage("Parameter param must be blank but is    h   ");
  }

  @Test
  public void isNotBlank()
  {
    Check.parameter("param").withValue("hi").isNotBlank();
    Check.parameter("param").withValue("   h   ").isNotBlank();
    assertThatThrownBy(()->Check.parameter("param").withValue(null).isNotBlank())
      .isInstanceOf(IllegalArgumentException.class)
      .hasMessage("Parameter param must not be blank");
    assertThatThrownBy(()->Check.parameter("param").withValue("").isNotBlank())
      .isInstanceOf(IllegalArgumentException.class)
      .hasMessage("Parameter param must not be blank");
    assertThatThrownBy(()->Check.parameter("param").withValue(" ").isNotBlank())
      .isInstanceOf(IllegalArgumentException.class)
      .hasMessage("Parameter param must not be blank");
    assertThatThrownBy(()->Check.parameter("param").withValue("\t\r\n").isNotBlank())
      .isInstanceOf(IllegalArgumentException.class)
      .hasMessage("Parameter param must not be blank");
  }
  
  @Test
  public void startsWith()
  {
    Check.field("field").withValue("Hello World").startsWith("");
    Check.field("field").withValue("Hello World").startsWith("H");
    Check.field("field").withValue("Hello World").startsWith("Hello");
    Check.field("field").withValue("Hello World").startsWith("Hello World");
    assertThatThrownBy(()->Check.field("field").withValue("Hello World").startsWith("World"))
      .isInstanceOf(IllegalStateException.class)
      .hasMessage("Field field must start with World but is Hello World");
  }

  @Test
  public void endsWith()
  {
    Check.field("field").withValue("Hello World").endsWith("");
    Check.field("field").withValue("Hello World").endsWith("d");
    Check.field("field").withValue("Hello World").endsWith("World");
    Check.field("field").withValue("Hello World").endsWith("Hello World");
    assertThatThrownBy(()->Check.field("field").withValue("Hello World").endsWith("Hello"))
      .isInstanceOf(IllegalStateException.class)
      .hasMessage("Field field must end with Hello but is Hello World");
  }

}
