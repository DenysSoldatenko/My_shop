package gui.panels.models;

import gui.MainFrame;
import gui.panels.RightPanel;
import gui.tables.CurrencyTableData;
import gui.toolbars.FunctionsToolBar;
import settings.styles.ImageIconStyle;

/**
 * The CurrencyPanel class represents a panel for displaying currencies data in the GUI.
 */
public class CurrencyPanel extends RightPanel {

  public CurrencyPanel(MainFrame frame) {
    super(frame, new CurrencyTableData(),
        "CURRENCIES", ImageIconStyle.ICON_PANEL_CURRENCIES,
        new FunctionsToolBar());
  }
}
