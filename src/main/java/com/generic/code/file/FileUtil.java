package com.generic.code.file;

/**
 * Utility class related to file.
 */
public class FileUtil {

  /**
   * constructor.
   */
  private FileUtil() {}

  /**
   * Extracts the file extension for the given file name. Returns the empty string if the file has
   * no extension.
   *
   * <p>
   * The result does not include the '{@code .}'.
   *
   * @param fileName the file name
   * @return the file extension, or the empty string
   */
  public static String extractExtension(String fileName) {
    int dotIndex = fileName.lastIndexOf('.');
    return (dotIndex == -1) ? "" : fileName.substring(dotIndex + 1);
  }

  /**
   * Returns the file name without its file extension. Returns the given file name if the file has
   * no extension.
   *
   * <p>
   * The result does not include the '{@code .}'.
   *
   * @param fileName the name of the file to trim the extension from.
   * @return the file name without extension.
   */
  public static String extractNameWithoutExtension(String fileName) {
    int dotIndex = fileName.lastIndexOf('.');
    return (dotIndex == -1) ? fileName : fileName.substring(0, dotIndex);
  }
}
