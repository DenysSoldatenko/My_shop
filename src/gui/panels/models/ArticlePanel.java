package gui.panels.models;

import gui.MainFrame;
import gui.dialogs.editings.ArticleAddEditDialog;
import gui.handlers.FunctionsHandler;
import gui.panels.RightPanel;
import gui.tables.ArticleTableData;
import gui.toolbars.FunctionsToolBar;
import settings.styles.ImageIconStyle;

/**
 * The ArticlePanel class represents a panel for displaying articles.
 */
public class ArticlePanel extends RightPanel {

  /**
   * Constructs an ArticlePanel object.
   *
   * @param frame the MainFrame instance
   */
  public ArticlePanel(MainFrame frame) {
    super(frame, new ArticleTableData(new FunctionsHandler(frame, new ArticleAddEditDialog(frame))),
        "ARTICLES", ImageIconStyle.ICON_PANEL_ARTICLES,
      new FunctionsToolBar(new FunctionsHandler(frame, new ArticleAddEditDialog(frame))));
  }
}
