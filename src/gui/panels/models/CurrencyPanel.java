package gui.panels.models;

import gui.MainFrame;
import gui.dialogs.editings.CurrencyAddEditDialog;
import gui.handlers.FunctionsHandler;
import gui.panels.RightPanel;
import gui.tables.CurrencyTableData;
import gui.toolbars.FunctionsToolBar;
import settings.styles.ImageIconStyle;

/**
 * The CurrencyPanel class represents a panel for displaying currency data in the GUI.
 */
public class CurrencyPanel extends RightPanel {

  /**
   * Creates a new CurrencyPanel instance.
   *
   * @param frame the main frame of the GUI
   */
  public CurrencyPanel(MainFrame frame) {
    super(frame, new CurrencyTableData(
        new FunctionsHandler(frame, new CurrencyAddEditDialog(frame))),
        "CURRENCIES", ImageIconStyle.ICON_PANEL_CURRENCIES,
      new FunctionsToolBar(new FunctionsHandler(frame, new CurrencyAddEditDialog(frame)))
    );
  }
}
