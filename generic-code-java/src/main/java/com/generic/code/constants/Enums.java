package com.generic.code.constants;

import java.util.Optional;

/**
 * Utility class for using {@link java.lang.Enum} object.
 */
public class Enums {

  /**
   * constructor.
   */
  private Enums() {}

  /**
   * This is an interface for enumeration constant with {@code int} value.
   */
  public interface IntEnum {

    /**
     * Returns an enumeration constant with the specified {@code int} value.
     *
     * @param <E> the enum type that implements {@code IntEnum}
     * @param enumType the {@code Class} object of the enum type from which to return a constant
     * @param i an {@code int} value
     * @return an enumeration constant
     */
    static <E extends Enum<E> & IntEnum> Optional<E> from(Class<E> enumType, int i) {
      for (E e : enumType.getEnumConstants()) {
        if (e.intValue() == i) {
          return Optional.of(e);
        }
      }
      return Optional.empty();
    }

    /**
     * Returns the {@code int} value defined for this enumeration constant.
     * 
     * @return the {@code int} value of this enumeration constant
     */
    int intValue();
  }
}
