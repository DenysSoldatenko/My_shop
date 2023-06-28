package gui.tables.models;

import datastorages.SaveData;
import models.Article;

/**
 * The ArticleTableModel class represents the table model for article data.
 */
public class ArticleTableModel extends MainTableModel {

  private static final int TITLE = 0;

  public ArticleTableModel(String[] columns) {
    super(SaveData.getInstance().getArticles(), columns);
  }

  @Override
  protected void updateData() {
    data = SaveData.getInstance().getArticles();
  }

  @Override
  public Object getValueAt(int row, int column) {
    if (data.isEmpty()) {
      return null;
    }
    Article article = (Article) data.get(row);
    if (column == TITLE) {
      return article.getTitle();
    }
    return null;
  }
}
