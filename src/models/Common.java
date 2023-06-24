package models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import datastorages.SaveData;
import lombok.NoArgsConstructor;

/**
 * The Common class is an abstract class that provides common functionality and methods
 * for other model classes.
 */
@NoArgsConstructor
public abstract class Common {

  @JsonIgnore
  public String getValueFromComboBox() {
    return null;
  }

  public void postAdd(SaveData saveData) { }

  public void postEdit(SaveData saveData) { }

  public void postRemove(SaveData saveData) { }
}
