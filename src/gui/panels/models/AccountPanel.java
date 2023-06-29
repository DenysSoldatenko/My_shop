package gui.panels.models;

import gui.MainFrame;
import gui.dialogs.editings.AccountAddEditDialog;
import gui.handlers.FunctionsHandler;
import gui.panels.RightPanel;
import gui.tables.AccountTableData;
import gui.toolbars.FunctionsToolBar;
import settings.styles.ImageIconStyle;

/**
 * The AccountPanel class represents a panel for displaying account information.
 */
public class AccountPanel extends RightPanel {

  /**
   * Constructs an AccountPanel with the specified MainFrame.
   *
   * @param frame the MainFrame to associate with the panel
   */
  public AccountPanel(MainFrame frame) {
    super(frame, new AccountTableData(new FunctionsHandler(frame, new AccountAddEditDialog(frame))),
        "ACCOUNTS", ImageIconStyle.ICON_PANEL_ACCOUNTS,
      new FunctionsToolBar(new FunctionsHandler(frame, new AccountAddEditDialog(frame))));
  }
}
