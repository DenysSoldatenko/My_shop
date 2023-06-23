package models;

import datastorages.SaveData;
import exceptions.ModelException;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public final class Article extends Common {
  private String title;

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
