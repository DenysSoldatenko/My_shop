package settings.styles;

import java.awt.Font;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * Provides font styles for the application.
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class FontStyle {

  public static final Font FONT_BUTTON_TOOLBAR
      = new Font("Roboto-Light", Font.BOLD, 14);
  public static final Font FONT_MAIN_BUTTON
      = new Font("Roboto-Light", Font.BOLD, 14);
  public static final Font FONT_DIALOG_LABEL
      = new Font("Roboto-Light", Font.BOLD, 12);
  public static final Font FONT_LABEL_HEADER
      = new Font("Roboto-Light", Font.BOLD, 16);
  public static final Font FONT_LABEL_LEFT_PANEL_CURRENCY
      = new Font("Roboto-Light", Font.BOLD, 14);
  public static final Font FONT_LABEL_LEFT_PANEL_AMOUNT
      = new Font("Roboto-Light", Font.PLAIN, 14);
  public static final Font FONT_TABLE_HEADER
      = new Font("Roboto-Light", Font.BOLD, 16);
  public static final Font FONT_TABLE
      = new Font("Roboto-Light", Font.PLAIN, 14);
  public static final Font FONT_BUTTON_FILTER
      = new Font("Roboto-Light", Font.BOLD, 12);
}
