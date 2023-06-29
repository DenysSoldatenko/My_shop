package gui.tables;

import gui.handlers.FunctionsHandler;
import gui.tables.models.ArticleTableModel;
import javax.swing.ImageIcon;
import settings.styles.ImageIconStyle;

/**
 * The ArticleTableData class represents a table data model for displaying articles.
 */
public class ArticleTableData extends TableData {

  private static final String[] columns = new String[]{"TITLE"};
  private static final ImageIcon[] icons = new ImageIcon[]{ImageIconStyle.ICON_TITLE};

  public ArticleTableData(FunctionsHandler handler) {
    super(new ArticleTableModel(columns), handler, columns, icons);
  }
}
