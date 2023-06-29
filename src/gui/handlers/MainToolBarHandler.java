package gui.handlers;

import gui.MainFrame;
import java.awt.event.ActionEvent;
import settings.HandlerCode;

/**
 * The MainToolBarHandler class handles the actions performed
 * in the main toolbar of the application.
 * It extends the MenuViewHandler class to reuse the methods for showing different panels.
 */
public class MainToolBarHandler extends MenuViewHandler {

  public MainToolBarHandler(MainFrame frame) {
    super(frame);
  }

  @Override
  public void actionPerformed(ActionEvent ae) {
    switch (ae.getActionCommand()) {
      case HandlerCode.TOOLBAR_OVERVIEW -> showOverviewPanel();
      case HandlerCode.TOOLBAR_ACCOUNTS -> showAccountPanel();
      case HandlerCode.TOOLBAR_ARTICLES -> showArticlePanel();
      case HandlerCode.TOOLBAR_TRANSACTIONS -> showTransactionPanel();
      case HandlerCode.TOOLBAR_TRANSFERS -> showTransferPanel();
      case HandlerCode.TOOLBAR_CURRENCIES -> showCurrencyPanel();
      case HandlerCode.TOOLBAR_STATISTICS -> showStatisticsPanel();
      default -> {
        return;
      }
    }
    super.actionPerformed(ae);
  }
}