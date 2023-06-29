package gui.handlers;

import gui.MainFrame;
import gui.panels.OverviewPanel;
import gui.panels.StatisticsPanel;
import gui.panels.models.AccountPanel;
import gui.panels.models.ArticlePanel;
import gui.panels.models.CurrencyPanel;
import gui.panels.models.TransactionPanel;
import gui.panels.models.TransferPanel;
import java.awt.event.ActionEvent;
import settings.HandlerCode;

/**
 * The MenuViewHandler class handles the action events for the menu view options.
 */
public class MenuViewHandler extends Handler {

  public MenuViewHandler(MainFrame frame) {
    super(frame);
  }

  @Override
  public void actionPerformed(ActionEvent ae) {
    switch (ae.getActionCommand()) {
      case HandlerCode.MENU_VIEW_OVERVIEW -> showOverviewPanel();
      case HandlerCode.MENU_VIEW_ACCOUNTS -> showAccountPanel();
      case HandlerCode.MENU_VIEW_ARTICLES -> showArticlePanel();
      case HandlerCode.MENU_VIEW_TRANSACTIONS -> showTransactionPanel();
      case HandlerCode.MENU_VIEW_TRANSFERS -> showTransferPanel();
      case HandlerCode.MENU_VIEW_CURRENCIES -> showCurrencyPanel();
      case HandlerCode.MENU_VIEW_STATISTICS -> showStatisticsPanel();
      default -> {
        return;
      }
    }
    super.actionPerformed(ae);
  }

  protected void showOverviewPanel() {
    frame.setRightPanel(new OverviewPanel(frame));
  }

  protected void showAccountPanel() {
    frame.setRightPanel(new AccountPanel(frame));
  }

  protected void showArticlePanel() {
    frame.setRightPanel(new ArticlePanel(frame));
  }

  protected void showTransactionPanel() {
    frame.setRightPanel(new TransactionPanel(frame));
  }

  protected void showTransferPanel() {
    frame.setRightPanel(new TransferPanel(frame));
  }

  protected void showCurrencyPanel() {
    frame.setRightPanel(new CurrencyPanel(frame));
  }

  protected void showStatisticsPanel() {
    frame.setRightPanel(new StatisticsPanel(frame));
  }
}