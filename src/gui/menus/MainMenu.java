package gui.menus;

import gui.MainFrame;
import gui.interfaces.EnableEditDelete;
import gui.interfaces.Refresh;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;
import settings.HandlerCode;
import settings.Text;
import settings.styles.ImageIconStyle;

/**
 * The MainMenu class represents the main menu bar of the application.
 */
public class MainMenu extends JMenuBar implements Refresh, EnableEditDelete {

  private JMenuItem menuEdit;
  private JMenuItem menuDelete;
  private final MainFrame mainFrame;

  public MainMenu(MainFrame mainFrame) {
    super();
    this.mainFrame = mainFrame;
    init();
  }

  private void init() {
    JMenu file = new JMenu(Text.get("MENU_FILE"));
    file.setIcon(ImageIconStyle.ICON_MENU_FILE);
    JMenu edit = new JMenu(Text.get("MENU_EDIT"));
    edit.setIcon(ImageIconStyle.ICON_MENU_EDIT);
    JMenu view = new JMenu(Text.get("MENU_VIEW"));
    view.setIcon(ImageIconStyle.ICON_MENU_VIEW);
    JMenu help = new JMenu(Text.get("MENU_HELP"));
    help.setIcon(ImageIconStyle.ICON_MENU_HELP);

    add(file);
    add(edit);
    add(view);
    add(help);

    addMenuItem(file, Text.get("MENU_FILE_NEW"), ImageIconStyle.ICON_MENU_FILE_NEW,
        HandlerCode.MENU_FILE_NEW, KeyEvent.VK_N);
    addMenuItem(file, Text.get("MENU_FILE_OPEN"), ImageIconStyle.ICON_MENU_FILE_OPEN,
        HandlerCode.MENU_FILE_OPEN, KeyEvent.VK_O);
    addMenuItem(file, Text.get("MENU_FILE_SAVE"), ImageIconStyle.ICON_MENU_FILE_SAVE,
        HandlerCode.MENU_FILE_SAVE, KeyEvent.VK_S);
    addMenuItem(file, Text.get("MENU_FILE_UPDATE_CURRENCIES"),
        ImageIconStyle.ICON_MENU_FILE_UPDATE_CURRENCIES,
        HandlerCode.MENU_FILE_UPDATE_CURRENCIES);
    addMenuItem(file, Text.get("MENU_FILE_EXIT"), ImageIconStyle.ICON_MENU_FILE_EXIT,
        HandlerCode.MENU_FILE_EXIT);

    addMenuItem(edit, Text.get("MENU_EDIT_ADD"), ImageIconStyle.ICON_MENU_EDIT_ADD,
        HandlerCode.MENU_EDIT_ADD);
    menuEdit = addMenuItem(edit, Text.get("MENU_EDIT_EDIT"), ImageIconStyle.ICON_MENU_EDIT_EDIT,
        HandlerCode.MENU_EDIT_EDIT);
    menuDelete = addMenuItem(edit, Text.get("MENU_EDIT_DELETE"),
        ImageIconStyle.ICON_MENU_EDIT_DELETE,
        HandlerCode.MENU_EDIT_DELETE);
    menuEdit.setEnabled(false);
    menuDelete.setEnabled(false);

    addMenuItem(view, Text.get("MENU_VIEW_OVERVIEW"), ImageIconStyle.ICON_MENU_VIEW_OVERVIEW,
        HandlerCode.MENU_VIEW_OVERVIEW);
    addMenuItem(view, Text.get("MENU_VIEW_ACCOUNTS"), ImageIconStyle.ICON_MENU_VIEW_ACCOUNTS,
        HandlerCode.MENU_VIEW_ACCOUNTS);
    addMenuItem(view, Text.get("MENU_VIEW_ARTICLES"), ImageIconStyle.ICON_MENU_VIEW_ARTICLES,
        HandlerCode.MENU_VIEW_ARTICLES);
    addMenuItem(view, Text.get("MENU_VIEW_TRANSACTIONS"),
        ImageIconStyle.ICON_MENU_VIEW_TRANSACTIONS,
        HandlerCode.MENU_VIEW_TRANSACTIONS);
    addMenuItem(view, Text.get("MENU_VIEW_TRANSFERS"), ImageIconStyle.ICON_MENU_VIEW_TRANSFERS,
        HandlerCode.MENU_VIEW_TRANSFERS);
    addMenuItem(view, Text.get("MENU_VIEW_CURRENCIES"), ImageIconStyle.ICON_MENU_VIEW_CURRENCIES,
        HandlerCode.MENU_VIEW_CURRENCIES);
    addMenuItem(view, Text.get("MENU_VIEW_STATISTICS"), ImageIconStyle.ICON_MENU_VIEW_STATISTICS,
        HandlerCode.MENU_VIEW_STATISTICS);

    addMenuItem(help, Text.get("MENU_HELP_ABOUT"), ImageIconStyle.ICON_MENU_HELP_ABOUT,
        HandlerCode.MENU_HELP_ABOUT);
  }

  private JMenuItem addMenuItem(JMenu menu, String title, ImageIcon icon, String action, int key) {
    JMenuItem item = new JMenuItem(title);
    item.setIcon(icon);
    item.setActionCommand(action);
    if (key != 0) {
      KeyStroke shortKey = KeyStroke.getKeyStroke(key,
          Toolkit.getDefaultToolkit().getMenuShortcutKeyMaskEx());
      item.setAccelerator(shortKey);
    }
    menu.add(item);
    return item;
  }

  private JMenuItem addMenuItem(JMenu menu, String title, ImageIcon icon, String action) {
    return addMenuItem(menu, title, icon, action, 0);
  }

  @Override
  public void setEnableEditDelete(boolean enable) {
    menuEdit.setEnabled(enable);
    menuDelete.setEnabled(enable);
  }

  @Override
  public void refresh() {
    removeAll();
    init();
  }
}
