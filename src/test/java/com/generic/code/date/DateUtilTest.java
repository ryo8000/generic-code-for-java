package com.generic.code.date;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import org.junit.Test;

/**
 * Test class for {@link DateUtil}.
 */
public class DateUtilTest {
  @Test
  public void testCreateDateFromYearMonthDay() throws ParseException {
    Date expected = createDate("2020-02-26", "yyyy-MM-dd");
    Date actual = DateUtil.createDate(2020, 2, 26);
    assertThat(actual, is(expected));
  }

  @Test
  public void testCreateDateFromYearMonthDayHourMinuteSecond() throws ParseException {
    Date expected = createDate("2020-02-26 23:59:59", "yyyy-MM-dd HH:mm:ss");
    Date actual = DateUtil.createDate(2020, 2, 26, 23, 59, 59);
    assertThat(actual, is(expected));
  }

  @Test
  public void testCreateDateFromYearMonthDayHourMinuteSecondMillisecond() throws ParseException {
    Date expected = createDate("2020-02-26 23:59:59.999", "yyyy-MM-dd HH:mm:ss.SSS");
    Date actual = DateUtil.createDate(2020, 2, 26, 23, 59, 59, 999);
    assertThat(actual, is(expected));
  }

  @Test
  public void testCreateCalendarFromYearMonthDay() throws ParseException {
    Calendar expected = toCalendar(createDate("2020-02-26", "yyyy-MM-dd"));
    Calendar actual = DateUtil.createCalendar(2020, 2, 26);
    assertThat(actual, is(expected));
  }

  @Test
  public void testCreateCalendarFromYearMonthDayHourMinuteSecond() throws ParseException {
    Calendar expected = toCalendar(createDate("2020-02-26 23:59:59", "yyyy-MM-dd HH:mm:ss"));
    Calendar actual = DateUtil.createCalendar(2020, 2, 26, 23, 59, 59);
    assertThat(actual, is(expected));
  }

  @Test
  public void testCreateCalendarFromYearMonthDayHourMinuteSecondMillisecond()
      throws ParseException {
    Calendar expected =
        toCalendar(createDate("2020-02-26 23:59:59.999", "yyyy-MM-dd HH:mm:ss.SSS"));
    Calendar actual = DateUtil.createCalendar(2020, 2, 26, 23, 59, 59, 999);
    assertThat(actual, is(expected));
  }

  @Test
  public void testParseDateIntoStringWithoutUsingFormatter() throws ParseException {
    String expected = "2020-02-26T23:59:59.999";
    Date datetime = createDate("2020-02-26 23:59:59.999", "yyyy-MM-dd HH:mm:ss.SSS");
    String actual = DateUtil.parseString(datetime);
    assertThat(actual, is(expected));
  }

  @Test
  public void testParseDateIntoStringUsingFormatter() throws ParseException {
    String expected = "2020/02/26 23:59:59.999";
    Date datetime = createDate("2020-02-26 23:59:59.999", "yyyy-MM-dd HH:mm:ss.SSS");
    String actual = DateUtil.parseString(datetime, "yyyy/MM/dd HH:mm:ss.SSS");
    assertThat(actual, is(expected));
  }

  @Test
  public void testParseCalendarIntoStringWithoutUsingFormatter() throws ParseException {
    String expected = "2020-02-26T23:59:59.999";
    Calendar datetime =
        toCalendar(createDate("2020-02-26 23:59:59.999", "yyyy-MM-dd HH:mm:ss.SSS"));
    String actual = DateUtil.parseString(datetime);
    assertThat(actual, is(expected));
  }

  @Test
  public void testParseCalendarIntoStringUsingFormatter() throws ParseException {
    String expected = "2020/02/26 23:59:59.999";
    Calendar datetime =
        toCalendar(createDate("2020-02-26 23:59:59.999", "yyyy-MM-dd HH:mm:ss.SSS"));
    String actual = DateUtil.parseString(datetime, "yyyy/MM/dd HH:mm:ss.SSS");
    assertThat(actual, is(expected));
  }

  @Test
  public void testParseCalendar() throws ParseException {
    Calendar expected =
        toCalendar(createDate("2020-02-26 23:59:59.999", "yyyy-MM-dd HH:mm:ss.SSS"));
    Date datetime = createDate("2020-02-26 23:59:59.999", "yyyy-MM-dd HH:mm:ss.SSS");
    Calendar actual = DateUtil.parseCalendar(datetime);
    assertThat(actual, is(expected));
  }

  @Test
  public void testTruncateDateTime() throws ParseException {
    Date expected = createDate("2020-02-26 00:00:00.000", "yyyy-MM-dd HH:mm:ss.SSS");
    Date datetime = createDate("2020-02-26 23:59:59.999", "yyyy-MM-dd HH:mm:ss.SSS");
    Date actual = DateUtil.truncateTime(datetime);
    assertThat(actual, is(expected));
  }

  @Test
  public void testTruncateCalendarTime() throws ParseException {
    Calendar expected =
        toCalendar(createDate("2020-02-26 00:00:00.000", "yyyy-MM-dd HH:mm:ss.SSS"));
    Calendar datetime =
        toCalendar(createDate("2020-02-26 23:59:59.999", "yyyy-MM-dd HH:mm:ss.SSS"));
    Calendar actual = DateUtil.truncateTime(datetime);
    assertThat(actual, is(expected));
  }

  @Test
  public void testCopy() throws ParseException {
    Calendar expected =
        toCalendar(createDate("2020-02-26 23:59:59.999", "yyyy-MM-dd HH:mm:ss.SSS"));
    Calendar actual = DateUtil.copy(expected);
    assertThat(actual, is(expected));

    actual.add(Calendar.MILLISECOND, -1);
    assertThat(actual, is(not(expected)));
  }

  /** Create an instance of {@code Date}. */
  private static Date createDate(String date, String formatter) throws ParseException {
    SimpleDateFormat sdf = new SimpleDateFormat(formatter);
    sdf.setLenient(false);
    return sdf.parse(date);
  }

  /** Converts a {@code Date} value to a {@code Calendar}. */
  private static Calendar toCalendar(Date date) {
    final Calendar c = Calendar.getInstance();
    c.setLenient(false);
    c.setTime(date);
    return c;
  }
}
