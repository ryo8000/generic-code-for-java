package com.generic.code.date.constants;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import org.junit.Test;
import com.generic.code.constants.Enums.IntEnum;

/**
 * Test class for {@link IntEnum}.
 */
public class IntEnumTest {

  /**
   * Test data for {@link IntEnum}.
   */
  private enum Ensemble implements IntEnum {
    SOLO(1), DUET(2), QUARTET(4), OCTET(8), TRIPLE_QUARTET(12);

    private final int numberOfMusicians;

    private Ensemble(int numberOfMusicians) {
      this.numberOfMusicians = numberOfMusicians;
    }

    /**
     * Returns an {@code Ensemble} instance with the specified {@code int} value.
     *
     * @param numberOfMusicians an {@code int} value
     * @return an instance of {@code Ensemble}
     * @throws IllegalArgumentException if there is no constant with the specified {@code int} value
     */
    public static Ensemble from(int numberOfMusicians) {
      return IntEnum.from(Ensemble.class, numberOfMusicians)
          .orElseThrow(IllegalArgumentException::new);
    }

    /** {@inheritDoc} */
    public int intValue() {
      return numberOfMusicians;
    }
  }

  @Test
  public void testFrom() {
    assertThat(Ensemble.from(1), is(Ensemble.SOLO));
    assertThat(Ensemble.from(2), is(Ensemble.DUET));
    assertThat(Ensemble.from(4), is(Ensemble.QUARTET));
    assertThat(Ensemble.from(8), is(Ensemble.OCTET));
    assertThat(Ensemble.from(12), is(Ensemble.TRIPLE_QUARTET));
  }

  @Test(expected = IllegalArgumentException.class)
  public void testFromError() {
    Ensemble.from(-1);
  }

  @Test
  public void testIntValue() {
    assertThat(Ensemble.SOLO.intValue(), is(1));
    assertThat(Ensemble.DUET.intValue(), is(2));
    assertThat(Ensemble.QUARTET.intValue(), is(4));
    assertThat(Ensemble.OCTET.intValue(), is(8));
    assertThat(Ensemble.TRIPLE_QUARTET.intValue(), is(12));
  }
}
