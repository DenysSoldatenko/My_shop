package settings.styles;

import java.awt.Color;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * Provides color styles for the application.
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ColorStyle {

  public static final Color COLOR_BUTTON_BG_NORMAL
      = new Color(240, 240, 240);
  public static final Color COLOR_BUTTON_BG_HOVER
      = Color.GRAY;
  public static final Color COLOR_LEFT_PANEL_BALANCE
      = Color.WHITE;
  public static final Color COLOR_EXP
      = new Color(200, 0, 0);
  public static final Color COLOR_INCOME
      = new Color(0, 100, 0);
  public static final Color COLOR_ON
      = Color.BLACK;
  public static final Color COLOR_OFF
      = new Color(170, 170, 170);
}
