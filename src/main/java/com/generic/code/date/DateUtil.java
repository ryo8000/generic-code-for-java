package com.generic.code.date;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import com.generic.code.date.formatter.Formatters;

/**
 * Utility class for using {@link java.util.Calendar} and {@link java.util.Date} object.
 */
public final class DateUtil {

  /**
   * constructor.
   */
  private DateUtil() {}

  /**
   * Obtains an instance of {@code Date} from year, month and day, setting the hour, minute, second
   * and millisecond to zero.
   *
   * @param year the year to represent
   * @param month the month-of-year to represent, from 1 (January) to 12 (December)
   * @param dayOfMonth the day-of-month to represent, from 1 to 31
   * @return an instance of {@code Date}
   */
  public static Date createDate(int year, int month, int dayOfMonth) {
    return createCalendar(year, month, dayOfMonth).getTime();
  }

  /**
   * Obtains an instance of {@code Date} from year, month,day, hour, minute and second, setting the
   * millisecond to zero.
   *
   * @param year the year to represent
   * @param month the month-of-year to represent, from 1 (January) to 12 (December)
   * @param dayOfMonth the day-of-month to represent, from 1 to 31
   * @param hour the hour-of-day to represent, from 0 to 23
   * @param minute the minute-of-hour to represent, from 0 to 59
   * @param second the second-of-minute to represent, from 0 to 59
   * @return an instance of {@code Date}
   */
  public static Date createDate(int year, int month, int dayOfMonth, int hour, int minute,
      int second) {
    return createCalendar(year, month, dayOfMonth, hour, minute, second).getTime();
  }

  /**
   * Obtains an instance of {@code Date} from year, month, day, hour, minute, second and
   * millisecond.
   *
   * @param year the year to represent
   * @param month the month-of-year to represent, from 1 (January) to 12 (December)
   * @param dayOfMonth the day-of-month to represent, from 1 to 31
   * @param hour the hour-of-day to represent, from 0 to 23
   * @param minute the minute-of-hour to represent, from 0 to 59
   * @param second the second-of-minute to represent, from 0 to 59
   * @param millisecond the milli-of-second to represent, from 0 to 999
   * @return an instance of {@code Date}
   */
  public static Date createDate(int year, int month, int dayOfMonth, int hour, int minute,
      int second, int millisecond) {
    return createCalendar(year, month, dayOfMonth, hour, minute, second, millisecond).getTime();
  }

  /**
   * Obtains an instance of {@code Calendar} from year, month and day, setting the hour, minute,
   * second and millisecond to zero.
   *
   * @param year the year to represent
   * @param month the month-of-year to represent, from 1 (January) to 12 (December)
   * @param dayOfMonth the day-of-month to represent, from 1 to 31
   * @return an instance of {@code Calendar}
   */
  public static Calendar createCalendar(int year, int month, int dayOfMonth) {
    return createCalendar(year, month, dayOfMonth, 0, 0, 0, 0);
  }

  /**
   * Obtains an instance of {@code Calendar} from year, month,day, hour, minute and second, setting
   * the millisecond to zero.
   *
   * @param year the year to represent
   * @param month the month-of-year to represent, from 1 (January) to 12 (December)
   * @param dayOfMonth the day-of-month to represent, from 1 to 31
   * @param hour the hour-of-day to represent, from 0 to 23
   * @param minute the minute-of-hour to represent, from 0 to 59
   * @param second the second-of-minute to represent, from 0 to 59
   * @return an instance of {@code Calendar}
   */
  public static Calendar createCalendar(int year, int month, int dayOfMonth, int hour, int minute,
      int second) {
    return createCalendar(year, month, dayOfMonth, hour, minute, second, 0);
  }

  /**
   * Obtains an instance of {@code Calendar} from year, month, day, hour, minute, second and
   * millisecond.
   *
   * @param year the year to represent
   * @param month the month-of-year to represent, from 1 (January) to 12 (December)
   * @param dayOfMonth the day-of-month to represent, from 1 to 31
   * @param hour the hour-of-day to represent, from 0 to 23
   * @param minute the minute-of-hour to represent, from 0 to 59
   * @param second the second-of-minute to represent, from 0 to 59
   * @param millisecond the milli-of-second to represent, from 0 to 999
   * @return an instance of {@code Calendar}
   */
  public static Calendar createCalendar(int year, int month, int dayOfMonth, int hour, int minute,
      int second, int millisecond) {
    final Calendar c = Calendar.getInstance();
    c.clear();
    c.setLenient(false);
    c.set(year, (month - 1), dayOfMonth, hour, minute, second);
    c.set(Calendar.MILLISECOND, millisecond);
    return c;
  }

  /**
   * Converts a {@code Date} value to a {@code String}.
   *
   * <p>
   * Converts the date-time into a {@code String}, such as '2011-12-03T10:15:30.123'.
   *
   * @param date an instance of {@code Date}
   * @return the parsed date string
   */
  public static String parseString(Date date) {
    return parseString(date, Formatters.ISO_LOCAL_DATE_TIME);
  }

  /**
   * Converts a {@code Date} value to a {@code String}.
   *
   * @param date an instance of {@code Date}
   * @param formatter the formatter to use
   * @return the parsed date string
   */
  public static String parseString(Date date, String formatter) {
    SimpleDateFormat sdf = new SimpleDateFormat(formatter);
    sdf.setLenient(false);
    return sdf.format(date);
  }

  /**
   * Converts a {@code Calendar} value to a {@code String}.
   *
   * <p>
   * Converts the date-time into a {@code String}, such as '2011-12-03T10:15:30.123'.
   *
   * @param calendar an instance of {@code Calendar}
   * @return the parsed date string
   */
  public static String parseString(Calendar calendar) {
    return parseString(calendar.getTime(), Formatters.ISO_LOCAL_DATE_TIME);
  }

  /**
   * Converts a {@code Calendar} value to a {@code String}.
   *
   * @param calendar an instance of {@code Calendar}
   * @param formatter the formatter to use
   * @return the parsed date string
   */
  public static String parseString(Calendar calendar, String formatter) {
    return parseString(calendar.getTime(), formatter);
  }

  /**
   * Converts a {@code Date} value to a {@code Calendar}.
   *
   * @param date an instance of {@code Date}
   * @return an instance of {@code Calendar}
   */
  public static Calendar parseCalendar(Date date) {
    final Calendar c = Calendar.getInstance();
    c.setLenient(false);
    c.setTime(date);
    return c;
  }

  /**
   * Truncates time information held by the {@code Date} instance.
   *
   * @param date an instance of {@code Date}
   * @return an instance of {@code Date} with time information of 00:00:00.000
   */
  public static Date truncateTime(Date date) {
    return truncateTime(parseCalendar(date)).getTime();
  }

  /**
   * Truncates time information held by the {@code Calendar} instance.
   *
   * @param calendar an instance of {@code Calendar}
   * @return an instance of {@code Calendar} with time information of 00:00:00.000
   */
  public static Calendar truncateTime(Calendar calendar) {
    Calendar c = copy(calendar);
    c.set(Calendar.HOUR_OF_DAY, 0);
    c.clear(Calendar.MINUTE);
    c.clear(Calendar.SECOND);
    c.clear(Calendar.MILLISECOND);
    return c;
  }

  /**
   * Copy an instance of {@code Calendar}.
   *
   * @param calendar copy source instance
   * @return copied instances
   */
  public static Calendar copy(Calendar calendar) {
    final Calendar c = (Calendar) calendar.clone();
    c.setLenient(false);
    return c;
  }
}
