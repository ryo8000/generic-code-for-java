package com.generic.code.file;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import java.util.Arrays;
import java.util.List;
import org.junit.Test;

/**
 * Test class for {@link FileUtil}.
 */
public class FileUtilTest {

  @Test
  public void testSplitNameByExtensionForFileWithoutFileExtension() {
    List<String> expected = Arrays.asList("myFile", "");
    List<String> actual = FileUtil.splitNameByExtension("myFile");
    assertThat(actual, is(expected));
  }

  @Test
  public void testSplitNameByExtensionForFileWithFileExtension() {
    List<String> expected = Arrays.asList("myFile.txt", "csv");
    List<String> actual = FileUtil.splitNameByExtension("myFile.txt.csv");
    assertThat(actual, is(expected));
  }

  @Test
  public void testExtractExtensionForFileWithoutFileExtension() {
    String expected = "";
    String actual = FileUtil.extractExtension("myFile");
    assertThat(actual, is(expected));
  }

  @Test
  public void testExtractExtensionForFileWithFileExtension() {
    String expected = "csv";
    String actual = FileUtil.extractExtension("myFile.txt.csv");
    assertThat(actual, is(expected));
  }

  @Test
  public void testExtractNameWithoutExtensionForFileWithoutFileExtension() {
    String expected = "myFile";
    String actual = FileUtil.extractNameWithoutExtension("myFile");
    assertThat(actual, is(expected));
  }

  @Test
  public void testExtractNameWithoutExtensionForFileWithFileExtension() {
    String expected = "myFile.txt";
    String actual = FileUtil.extractNameWithoutExtension("myFile.txt.csv");
    assertThat(actual, is(expected));
  }
}
