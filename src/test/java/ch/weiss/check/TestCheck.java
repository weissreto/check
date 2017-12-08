package ch.weiss.check;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.Test;

public class TestCheck
{
  @Test
  public void thing()
  {
    assertThatThrownBy(()->Check.thing(new NoSuchElementExceptionThrower("List", "persons")).withValue("Weiss").startsWith("Reto"))
      .isInstanceOf(NoSuchElementException.class)
      .hasMessage("List persons must start with Reto but is Weiss");
  }
  
  private static final class NoSuchElementExceptionThrower extends AbstractThrower
  {
    public NoSuchElementExceptionThrower(String what, String name)
    {
      super(what, name);
    }

    @Override
    public void throwNow(String message)
    {
      throw new NoSuchElementException(what()+" "+name()+" "+message);
    }
    
  }
}
