package com.generic.code.base;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
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
    String errorMessage = "Object must not be null";
    try {
      Validator.checkNotNull(null, errorMessage);
    } catch (NullPointerException e) {
      assertThat(errorMessage, is(e.getMessage()));
      throw e;
    }
  }

  @Test
  public void testCheckArgumentWithTrueExpression() {
    Validator.checkArgument(true, "Expression must be true");
  }

  @Test(expected = IllegalArgumentException.class)
  public void testCheckArgumentWithFalseExpression() {
    String errorMessage = "Expression must be true";
    try {
      Validator.checkArgument(false, errorMessage);
    } catch (IllegalArgumentException e) {
      assertThat(errorMessage, is(e.getMessage()));
      throw e;
    }
  }

  @Test
  public void testCheckStateWithValidState() {
    Validator.checkState(true, "State must be valid");
  }

  @Test(expected = IllegalStateException.class)
  public void testCheckStateWithInvalidState() {
    String errorMessage = "State must be valid";
    try {
      Validator.checkState(false, errorMessage);
    } catch (IllegalStateException e) {
      assertThat(errorMessage, is(e.getMessage()));
      throw e;
    }
  }
}
