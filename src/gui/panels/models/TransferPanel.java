package gui.panels.models;

import gui.MainFrame;
import gui.dialogs.editings.TransferAddEditDialog;
import gui.handlers.FunctionsHandler;
import gui.panels.FilterPanel;
import gui.panels.RightPanel;
import gui.tables.TransferTableData;
import gui.toolbars.FunctionsToolBar;
import javax.swing.JPanel;
import settings.styles.ImageIconStyle;

/**
 * The TransferPanel class represents a panel for displaying transfers data in the GUI.
 */
public class TransferPanel extends RightPanel {

  /**
   * Constructs a TransferPanel with the specified MainFrame.
   *
   * @param frame the MainFrame
   */
  public TransferPanel(MainFrame frame) {
    super(frame,
        new TransferTableData(new FunctionsHandler(frame, new TransferAddEditDialog(frame))),
        "TRANSFERS", ImageIconStyle.ICON_PANEL_TRANSFERS,
        new JPanel[] {
            new FunctionsToolBar(new FunctionsHandler(frame, new TransferAddEditDialog(frame))),
            new FilterPanel(frame)
        }
    );
  }
}
