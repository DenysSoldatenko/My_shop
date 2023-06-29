package settings.styles;

import java.awt.Dimension;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * Provides dimension styles for the application.
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class DimensionStyle {

  public static final Dimension DIMENSION_DIALOG_TEXT_FIELD_SIZE
      = new Dimension(200, 25);
  public static final Dimension DIMENSION_DIALOG_PADDING_BUTTON
      = new Dimension(10, 0);
  public static final Dimension DIMENSION_PADDING_BALANCE
      = new Dimension(10, 0);
  public static final Dimension DIMENSION_TABLE_SHOW_SIZE
      = new Dimension(850, 350);
  public static final Dimension DIMENSION_CHART
      = new Dimension(868, 350);
}
