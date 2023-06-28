package gui.panels;

import gui.MainFrame;
import gui.tables.TransactionTableData;
import gui.toolbars.FunctionsToolBar;
import javax.swing.JPanel;
import settings.styles.ImageIconStyle;

/**
 * The TransactionPanel class represents a panel for displaying transaction data in the GUI.
 */
public class TransactionPanel extends RightPanel {

  public TransactionPanel(MainFrame frame) {
    super(frame, new TransactionTableData(),
        "TRANSACTIONS", ImageIconStyle.ICON_PANEL_TRANSACTIONS,
      new JPanel[] {new FunctionsToolBar(), new FilterPanel(frame)});
  }
}
