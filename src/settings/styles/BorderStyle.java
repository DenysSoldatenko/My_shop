package settings.styles;

import javax.swing.border.EmptyBorder;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * Provides border styles for the application.
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class BorderStyle {

  public static final EmptyBorder BORDER_PANEL
      = new EmptyBorder(10, 10, 10, 10);
  public static final EmptyBorder BORDER_LEFT_PANEL
      = new EmptyBorder(0, 10, 10, 10);
  public static final EmptyBorder BORDER_MAIN_TOOLBAR
      = new EmptyBorder(10, 10, 10, 10);
  public static final EmptyBorder BORDER_FUNCTIONS_TOOLBAR
      = new EmptyBorder(5, 5, 5, 5);
  public static final EmptyBorder BORDER_DIALOG
      = new EmptyBorder(10, 10, 10, 10);
  public static final EmptyBorder BORDER_FILTER_PANEL
      = new EmptyBorder(5, 0, 7, 0);
}
