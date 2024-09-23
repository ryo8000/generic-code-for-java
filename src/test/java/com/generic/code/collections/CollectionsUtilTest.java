package com.generic.code.collections;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import java.util.Arrays;
import java.util.List;
import org.junit.Test;

/**
 * Test class for {@link CollectionsUtil}.
 */
public class CollectionsUtilTest {
  @Test(expected = NullPointerException.class)
  public void testSplitWithNull() {
    CollectionsUtil.split(null, ",");
  }

  @Test
  public void testSplitWithEmptyString() {
    List<String> expected = Arrays.asList();
    List<String> actual = CollectionsUtil.split("", ",");
    assertThat(actual, is(expected));
  }

  @Test
  public void testSplitWithoutLimit() {
    List<String> expected = Arrays.asList("a", "b", "", "c", "", "");
    List<String> actual = CollectionsUtil.split("a,b,,c,,", ",");
    assertThat(actual, is(expected));
  }

  @Test
  public void testSplitWithLimit() {
    List<String> expected = Arrays.asList("a", "b", "", "c,,");
    List<String> actual = CollectionsUtil.split("a,b,,c,,", ",", 4);
    assertThat(actual, is(expected));
  }

  @Test
  public void testSplitWithNoMatchDelimiter() {
    List<String> expected = Arrays.asList("a,b,c");
    List<String> actual = CollectionsUtil.split("a,b,c", ";");
    assertThat(actual, is(expected));
  }
}
