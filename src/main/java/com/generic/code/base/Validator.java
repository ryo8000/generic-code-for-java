package com.generic.code.base;

/**
 * Utility class for validating method arguments and object states.
 */
public final class Validator {

  /**
   * constructor.
   */
  private Validator() {}

  /**
   * Validates that the specified argument is not {@code null}; otherwise throwing an exception.
   *
   * @param <T> the object type
   * @param object the object to check
   * @param errorMessage the exception message to use if the check fails
   * @return the validated non-null object
   * @throws NullPointerException if the object is {@code null}
   */
  public static <T> T checkNotNull(T object, String errorMessage) {
    if (object == null) {
      throw new NullPointerException(errorMessage);
    }
    return object;
  }

  /**
   * Validates that the argument condition is {@code true}; otherwise throwing an exception.
   *
   * @param expression the boolean expression to check
   * @param errorMessage the exception message to use if the check fails
   * @throws IllegalArgumentException if the expression is {@code false}, indicating an invalid
   *         argument
   */
  public static void checkArgument(boolean expression, String errorMessage) {
    if (!expression) {
      throw new IllegalArgumentException(errorMessage);
    }
  }

  /**
   * Validates that the state condition is {@code true}; otherwise throwing an exception.
   *
   * @param expression the boolean expression to check
   * @param errorMessage the exception message to use if the check fails
   * @throws IllegalStateException if the expression is {@code false}, indicating an invalid state
   */
  public static void checkState(boolean expression, String errorMessage) {
    if (!expression) {
      throw new IllegalStateException(errorMessage);
    }
  }
}
