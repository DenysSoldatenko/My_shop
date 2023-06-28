package gui.panels;

import gui.MainFrame;
import gui.tables.TransactionTableData;
import settings.Settings;
import settings.styles.ImageIconStyle;

/**
 * The OverviewPanel class represents a panel
 * for displaying an overview of last transactions in the GUI.
 */
public class OverviewPanel extends RightPanel {

  public OverviewPanel(MainFrame frame) {
    super(frame, new TransactionTableData(Settings.COUNT_OVERVIEW_ROWS),
        "LAST_TRANSACTIONS", ImageIconStyle.ICON_PANEL_OVERVIEW);
  }
}
