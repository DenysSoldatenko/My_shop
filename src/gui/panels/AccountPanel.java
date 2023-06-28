package gui.panels;

import gui.MainFrame;
import gui.tables.AccountTableData;
import gui.toolbars.FunctionsToolBar;
import settings.styles.ImageIconStyle;

/**
 * The AccountPanel class represents a panel for displaying account information.
 */
public class AccountPanel extends RightPanel {

  public AccountPanel(MainFrame frame) {
    super(frame, new AccountTableData(),
        "ACCOUNTS", ImageIconStyle.ICON_PANEL_ACCOUNTS,
        new FunctionsToolBar());
  }
}
