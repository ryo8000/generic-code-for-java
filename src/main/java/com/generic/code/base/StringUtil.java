package com.generic.code.base;

/**
 * Utility class related to string.
 */
public class StringUtil {

  /**
   * constructor.
   */
  private StringUtil() {}

  /**
   * Left pad a string with a specified character.
   *
   * <p>Pad to a size of {@code length}.</p>
   *
   * @param target the string to pad out
   * @param length the length to pad to
   * @param padChar the character to pad
   * @return the left padded string or original string if no padding is necessary
   */
  public static String padLeft(String target, int length, char padChar) {
    int targetLength = target.length();
    if (targetLength >= length) {
      return target;
    }
    StringBuilder sb = new StringBuilder(length);
    for (int i = targetLength; i < length; i++) {
      sb.append(padChar);
    }
    sb.append(target);
    return sb.toString();
  }
}
