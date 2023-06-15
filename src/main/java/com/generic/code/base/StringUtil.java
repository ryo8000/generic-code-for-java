package com.generic.code.base;

import java.util.Arrays;
import java.util.List;

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

  /**
   * Splits this string around matches of the given regular expression.
   *
   * <p>Returns an empty list if the string to be split is an empty string.
   *
   * @param str the string to be split
   * @param delimiter the delimiting regular expression
   * @return the list of strings computed by splitting this string around matches of the given
   *         regular expression
   */
  public static List<String> split(String str, String delimiter) {
    return split(str, delimiter, -1);
  }

  /**
   * Splits this string around matches of the given regular expression.
   *
   * <p>Returns an empty list if the string to be split is an empty string.
   *
   * @param str the string to be split
   * @param delimiter the delimiting regular expression
   * @param limit the result threshold, as described above
   * @return the list of strings computed by splitting this string around matches of the given
   *         regular expression
   */
  public static List<String> split(String str, String delimiter, int limit) {
    if (str.isEmpty()) {
      return Arrays.asList();
    }
    return Arrays.asList(str.split(delimiter, limit));
  }
}
