package models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import datastorages.SaveData;
import lombok.NoArgsConstructor;

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
