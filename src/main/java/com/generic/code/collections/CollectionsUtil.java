package com.generic.code.collections;

import java.util.Arrays;
import java.util.List;

/**
 * Utility class related to collections.
 */
public class CollectionsUtil {

  /**
   * constructor.
   */
  private CollectionsUtil() {}

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
