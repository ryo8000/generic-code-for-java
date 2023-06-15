package com.generic.code.base;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import java.text.ParseException;
import org.junit.Test;

/**
 * Test class for {@link StringUtil}.
 */
public class StringUtilTest {
  @Test(expected = NullPointerException.class)
  public void testPadLeftNull() throws ParseException {
    StringUtil.padLeft(null, 10, 'x');
  }

  @Test
  public void testPadLeftEmpty() throws ParseException {
    assertThat("", is(StringUtil.padLeft("", 0, ' ')));
    assertThat(" ", is(StringUtil.padLeft("", 1, ' ')));
    assertThat("  ", is(StringUtil.padLeft("", 2, ' ')));
  }

  @Test
  public void testPadLeftString() throws ParseException {
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
  public void testPadLeftMinusLength() throws ParseException {
    assertThat("a", is(StringUtil.padLeft("a", -5, 'x')));
  }
}
