package gui.toolbars;

import gui.EnableEditDelete;
import gui.MainButton;
import settings.HandlerCode;
import settings.Text;
import settings.styles.ImageIconStyle;

public final class FunctionsToolBar extends AbstractToolBar implements EnableEditDelete {

  private MainButton editButton;
  private MainButton deleteButton;

  public FunctionsToolBar() {
    super();
    init();
  }

  @Override
  protected void init() {
    addButton(Text.get("ADD"), ImageIconStyle.ICON_ADD,
        HandlerCode.ADD, false);
    editButton = addButton(Text.get("EDIT"), ImageIconStyle.ICON_EDIT,
        HandlerCode.EDIT, false);
    deleteButton = addButton(Text.get("DELETE"), ImageIconStyle.ICON_DELETE,
        HandlerCode.DELETE, false);
  }

  @Override
  public void setEnableEditDelete(boolean enable) {
    editButton.setEnabled(enable);
    deleteButton.setEnabled(enable);
  }

}

