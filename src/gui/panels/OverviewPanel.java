package gui.panels;

import gui.MainFrame;
import gui.dialogs.editings.TransactionAddEditDialog;
import gui.handlers.FunctionsHandler;
import gui.tables.TransactionTableData;
import settings.Settings;
import settings.styles.ImageIconStyle;

/**
 * The OverviewPanel class represents a panel
 * for displaying an overview of last transactions in the GUI.
 */
public class OverviewPanel extends RightPanel {

  /**
   * Constructs an OverviewPanel with the specified MainFrame.
   *
   * @param frame the MainFrame to associate with the panel
   */
  public OverviewPanel(MainFrame frame) {
    super(frame,
      new TransactionTableData(new FunctionsHandler(frame, new TransactionAddEditDialog(frame)),
        Settings.COUNT_OVERVIEW_ROWS),
        "LAST_TRANSACTIONS", ImageIconStyle.ICON_PANEL_OVERVIEW);
  }
}
