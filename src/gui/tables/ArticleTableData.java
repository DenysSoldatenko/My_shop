package gui.tables;

import gui.tables.models.ArticleTableModel;
import javax.swing.ImageIcon;
import settings.styles.ImageIconStyle;

/**
 * The ArticleTableData class represents a table data model for displaying articles.
 */
public class ArticleTableData extends TableData {

  private static final String[] columns = new String[]{"TITLE"};
  private static final ImageIcon[] icons = new ImageIcon[]{ImageIconStyle.ICON_TITLE};

  public ArticleTableData() {
    super(new ArticleTableModel(columns), columns, icons);
  }
}
