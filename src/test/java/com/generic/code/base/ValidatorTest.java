package com.generic.code.base;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * Test class for {@link Validator}.
 */
public class ValidatorTest {

  @Test
  public void testCheckNotNullWithNonNullObject() {
    String input = "test";
    assertThat(input, is(Validator.checkNotNull(input, "Object must not be null")));
  }

  @Test(expected = NullPointerException.class)
  public void testCheckNotNullWithNullObject() {
    Validator.checkNotNull(null, "Object must not be null");
  }

  @Test
  public void testCheckArgumentWithTrueExpression() {
    Validator.checkArgument(true, "Expression must be true");
  }

  @Test(expected = IllegalArgumentException.class)
  public void testCheckArgumentWithFalseExpression() {
    Validator.checkArgument(false, "Expression must be true");
  }

  @Test
  public void testCheckStateWithValidState() {
    Validator.checkState(true, "State must be valid");
  }

  @Test(expected = IllegalStateException.class)
  public void testCheckStateWithInvalidState() {
    Validator.checkState(false, "State must be valid");
  }
}
