package models;

import datastorages.SaveData;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import settings.exceptions.ModelException;

/**
 * Represents an article in the application.
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public final class Article extends Common {
  private String title;

  /**
   * Constructs an article with the specified title.
   *
   * @param title the title of the article
   * @throws ModelException if the title is empty
   */
  public Article(final String title) throws ModelException {
    if (title.length() == 0) {
      throw new ModelException(ModelException.TITLE_EMPTY);
    }
    this.title = title;
  }

  @Override
  public String getValueFromComboBox() {
    return title;
  }

  @Override
  public void postEdit(SaveData sd) {
    for (Transaction t : sd.getTransactions()) {
      if (t.getArticle().equals(sd.getOldCommon())) {
        t.setArticle(this);
      }
    }
  }
}
