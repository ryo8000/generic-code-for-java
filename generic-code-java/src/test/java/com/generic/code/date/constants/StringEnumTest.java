package com.generic.code.date.constants;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;
import org.junit.Test;
import com.generic.code.constants.Enums.StringEnum;

/**
 * Test class for {@link StringEnum}.
 */
public class StringEnumTest {

  /**
   * Test data for {@link StringEnum}.
   */
  private enum ClothingSize implements StringEnum {
    SMALL("S"), MEDIUM("M"), LARGE("L"), EXTRA_LARGE("XL");

    private final String abbreviation;

    private ClothingSize(String abbreviation) {
      this.abbreviation = abbreviation;
    }

    /**
     * Returns an {@code ClothingSize} instance with the specified {@code String} value.
     * 
     * @param abbreviation a {@code String} value
     * @return an instance of {@code ClothingSize}
     */
    public static ClothingSize from(String abbreviation) {
      return StringEnum.from(ClothingSize.class, abbreviation).orElse(null);
    }

    /** {@inheritDoc} */
    public String stringValue() {
      return abbreviation;
    }
  }

  @Test
  public void testFrom() {
    assertThat(ClothingSize.from("S"), is(ClothingSize.SMALL));
    assertThat(ClothingSize.from("M"), is(ClothingSize.MEDIUM));
    assertThat(ClothingSize.from("L"), is(ClothingSize.LARGE));
    assertThat(ClothingSize.from("XL"), is(ClothingSize.EXTRA_LARGE));
    assertThat(ClothingSize.from(""), is(nullValue()));
    assertThat(ClothingSize.from(null), is(nullValue()));
  }

  @Test
  public void testStringValue() {
    assertThat(ClothingSize.SMALL.stringValue(), is("S"));
    assertThat(ClothingSize.MEDIUM.stringValue(), is("M"));
    assertThat(ClothingSize.LARGE.stringValue(), is("L"));
    assertThat(ClothingSize.EXTRA_LARGE.stringValue(), is("XL"));
  }
}
