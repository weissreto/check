# check [![Build Status](https://travis-ci.org/weissreto/check.svg?branch=master)](https://travis-ci.org/weissreto/check)

Checks preconditions (e.g. method parameter values) and generates nice error messages. 

## Example

````
  public int divide(int dividend, int divisor)
  {
    Check.parameter("divisor").withValue(divisor).isNotZero();
    return dividend/divisor;
  }
````

This first line of the method will throw an `IllegalArgumentException` if the parameter `divisor` is zero. The message will be:

`Parameter divisor must not be zero`  
  
