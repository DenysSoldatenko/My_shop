package gui.panels;

import gui.MainFrame;
import gui.tables.ArticleTableData;
import gui.toolbars.FunctionsToolBar;
import settings.styles.ImageIconStyle;

/**
 * The ArticlePanel class represents a panel for displaying articles.
 */
public class ArticlePanel extends RightPanel {

  public ArticlePanel(MainFrame frame) {
    super(frame, new ArticleTableData(),
        "ARTICLES", ImageIconStyle.ICON_PANEL_ARTICLES,
         new FunctionsToolBar());
  }
}
