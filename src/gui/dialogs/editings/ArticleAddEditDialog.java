package gui.dialogs.editings;

import gui.MainFrame;
import javax.swing.JTextField;
import models.Article;
import models.Common;
import settings.exceptions.ModelException;
import settings.styles.ImageIconStyle;

/**
 * A dialog for adding or editing an Article.
 */
public class ArticleAddEditDialog extends AddEditDialog {

  public ArticleAddEditDialog(MainFrame frame) {
    super(frame);
  }

  @Override
  protected void init() {
    elements.put("LABEL_TITLE", new JTextField());
    icons.put("LABEL_TITLE", ImageIconStyle.ICON_TITLE);
  }

  @Override
  protected void setValues() {
    Article article = (Article) common;
    values.put("LABEL_TITLE", article.getTitle());
  }

  @Override
  public Common getCommonFromForm() throws ModelException {
    String title = ((JTextField) elements.get("LABEL_TITLE")).getText();
    return new Article(title);
  }
}
