package gui.panels;

import gui.MainFrame;
import gui.tables.TransferTableData;
import gui.toolbars.FunctionsToolBar;
import javax.swing.JPanel;
import settings.styles.ImageIconStyle;

/**
 * The TransferPanel class represents a panel for displaying transfers data in the GUI.
 */
public class TransferPanel extends RightPanel {

  public TransferPanel(MainFrame frame) {
    super(frame, new TransferTableData(),
        "TRANSFERS", ImageIconStyle.ICON_PANEL_TRANSFERS,
      new JPanel[] {new FunctionsToolBar(), new FilterPanel(frame)});
  }
}
