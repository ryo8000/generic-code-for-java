package com.generic.code.base;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import org.junit.Test;

/**
 * Test class for {@link StringUtil}.
 */
public class StringUtilTest {
  @Test(expected = NullPointerException.class)
  public void testPadLeftNull() {
    StringUtil.padLeft(null, 10, 'x');
  }

  @Test
  public void testPadLeftEmpty() {
    assertThat("", is(StringUtil.padLeft("", 0, ' ')));
    assertThat(" ", is(StringUtil.padLeft("", 1, ' ')));
    assertThat("  ", is(StringUtil.padLeft("", 2, ' ')));
  }

  @Test
  public void testPadLeftString() {
    assertThat("1", is(StringUtil.padLeft("1", 0, '0')));
    assertThat("1", is(StringUtil.padLeft("1", 1, '0')));
    assertThat("01", is(StringUtil.padLeft("1", 2, '0')));
    assertThat("001", is(StringUtil.padLeft("1", 3, '0')));
    assertThat("12", is(StringUtil.padLeft("12", 0, '0')));
    assertThat("12", is(StringUtil.padLeft("12", 1, '0')));
    assertThat("12", is(StringUtil.padLeft("12", 2, '0')));
    assertThat("012", is(StringUtil.padLeft("12", 3, '0')));
  }

  @Test
  public void testPadLeftMinusLength() {
    assertThat("a", is(StringUtil.padLeft("a", -5, 'x')));
  }
}
