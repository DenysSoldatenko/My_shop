package gui.menus;

import gui.handlers.FunctionsHandler;
import gui.interfaces.Refresh;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import settings.HandlerCode;
import settings.Text;
import settings.styles.ImageIconStyle;

/**
 * The TablePopupMenu class represents a context menu that appears when right-clicking on a table.
 * It provides options for editing and deleting items in the table.
 */
public class TablePopupMenu extends JPopupMenu implements Refresh {

  private final FunctionsHandler handler;

  /**
   * Constructs a TablePopupMenu with the specified FunctionsHandler.
   *
   * @param handler the FunctionsHandler
   */
  public TablePopupMenu(FunctionsHandler handler) {
    super();
    this.handler = handler;
    init();
  }

  @Override
  public void refresh() {
    throw new UnsupportedOperationException("Not supported yet.");
  }

  private void init() {
    JMenuItem editItem = new JMenuItem(Text.get("EDIT"));
    JMenuItem deleteItem = new JMenuItem(Text.get("DELETE"));

    editItem.setActionCommand(HandlerCode.EDIT);
    deleteItem.setActionCommand(HandlerCode.DELETE);

    editItem.addActionListener(handler);
    deleteItem.addActionListener(handler);

    editItem.setIcon(ImageIconStyle.ICON_MENU_POPUP_EDIT);
    deleteItem.setIcon(ImageIconStyle.ICON_MENU_POPUP_DELETE);

    add(editItem);
    add(deleteItem);
  }
}
