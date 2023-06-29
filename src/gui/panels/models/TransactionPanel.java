package gui.panels.models;

import gui.MainFrame;
import gui.dialogs.editings.TransactionAddEditDialog;
import gui.handlers.FunctionsHandler;
import gui.panels.FilterPanel;
import gui.panels.RightPanel;
import gui.tables.TransactionTableData;
import gui.toolbars.FunctionsToolBar;
import javax.swing.JPanel;
import settings.styles.ImageIconStyle;

/**
 * The TransactionPanel class represents a panel for displaying transaction data in the GUI.
 */
public class TransactionPanel extends RightPanel {

  /**
   * Constructs a TransactionPanel with the specified MainFrame.
   *
   * @param frame the MainFrame
   */
  public TransactionPanel(MainFrame frame) {
    super(frame,
        new TransactionTableData(new FunctionsHandler(frame, new TransactionAddEditDialog(frame))),
        "TRANSACTIONS", ImageIconStyle.ICON_PANEL_TRANSACTIONS,
        new JPanel[] {
            new FunctionsToolBar(new FunctionsHandler(frame, new TransactionAddEditDialog(frame))),
            new FilterPanel(frame)
        }
    );
  }
}
