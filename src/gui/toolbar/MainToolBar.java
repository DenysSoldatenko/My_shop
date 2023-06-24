package gui.toolbar;

import settings.HandlerCode;
import settings.Text;
import settings.styles.BorderStyle;
import settings.styles.ImageIconStyle;

import javax.swing.*;

public final class MainToolBar extends AbstractToolBar {

  public MainToolBar() {
    super();
    setBorder(BorderStyle.BORDER_MAIN_TOOLBAR);
    init();
  }

  @Override
  protected void init() {
    addButton(Text.get("TOOLBAR_OVERVIEW"), ImageIconStyle.ICON_TOOLBAR_OVERVIEW,
         HandlerCode.TOOLBAR_OVERVIEW, true);
    add(Box.createHorizontalStrut(1));
    addButton(Text.get("TOOLBAR_ACCOUNTS"), ImageIconStyle.ICON_TOOLBAR_ACCOUNTS,
         HandlerCode.TOOLBAR_ACCOUNTS, true);
    add(Box.createHorizontalStrut(1));
    addButton(Text.get("TOOLBAR_ARTICLES"), ImageIconStyle.ICON_TOOLBAR_ARTICLES,
         HandlerCode.TOOLBAR_ARTICLES, true);
    add(Box.createHorizontalStrut(1));
    addButton(Text.get("TOOLBAR_TRANSACTIONS"), ImageIconStyle.ICON_TOOLBAR_TRANSACTIONS,
              HandlerCode.TOOLBAR_TRANSACTIONS, true);
    add(Box.createHorizontalStrut(1));
    addButton(Text.get("TOOLBAR_TRANSFERS"), ImageIconStyle.ICON_TOOLBAR_TRANSFERS,
        HandlerCode.TOOLBAR_TRANSFERS, true);
    add(Box.createHorizontalStrut(1));
    addButton(Text.get("TOOLBAR_CURRENCIES"), ImageIconStyle.ICON_TOOLBAR_CURRENCIES,
        HandlerCode.TOOLBAR_CURRENCIES, true);
    add(Box.createHorizontalStrut(1));
    addButton(Text.get("TOOLBAR_STATISTICS"), ImageIconStyle.ICON_TOOLBAR_STATISTICS,
        HandlerCode.TOOLBAR_STATISTICS, true);
  }
}
