package gui.menus;

import gui.MainFrame;
import gui.handlers.Handler;
import gui.handlers.MenuEditHandler;
import gui.handlers.MenuFileHandler;
import gui.handlers.MenuHelpHandler;
import gui.handlers.MenuSettingsHandler;
import gui.handlers.MenuViewHandler;
import gui.interfaces.EnableEditDelete;
import gui.interfaces.Refresh;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.KeyStroke;
import settings.HandlerCode;
import settings.Settings;
import settings.Text;
import settings.styles.ImageIconStyle;

/**
 * The MainMenu class represents the main menu bar of the application.
 */
public class MainMenu extends JMenuBar implements Refresh, EnableEditDelete {

  private JMenuItem menuEdit;
  private JMenuItem menuDelete;
  private final MainFrame frame;

  /**
   * Creates a new MainMenu instance.
   *
   * @param mainFrame the main frame of the application
   */
  public MainMenu(MainFrame mainFrame) {
    super();
    this.frame = mainFrame;
    init();
  }

  private void init() {
    JMenu file = new JMenu(Text.get("MENU_FILE"));
    file.setIcon(ImageIconStyle.ICON_MENU_FILE);
    JMenu edit = new JMenu(Text.get("MENU_EDIT"));
    edit.setIcon(ImageIconStyle.ICON_MENU_EDIT);
    JMenu view = new JMenu(Text.get("MENU_VIEW"));
    view.setIcon(ImageIconStyle.ICON_MENU_VIEW);
    JMenu settings = new JMenu(Text.get("MENU_SETTINGS"));
    settings.setIcon(ImageIconStyle.ICON_MENU_SETTINGS);
    JMenu help = new JMenu(Text.get("MENU_HELP"));
    help.setIcon(ImageIconStyle.ICON_MENU_HELP);

    add(file);
    add(edit);
    add(view);
    add(settings);
    add(help);

    MenuFileHandler fileHandler = new MenuFileHandler(frame);
    addMenuItem(file, fileHandler,
        Text.get("MENU_FILE_NEW"), ImageIconStyle.ICON_MENU_FILE_NEW,
        HandlerCode.MENU_FILE_NEW, KeyEvent.VK_N);
    addMenuItem(file, fileHandler,
        Text.get("MENU_FILE_OPEN"), ImageIconStyle.ICON_MENU_FILE_OPEN,
        HandlerCode.MENU_FILE_OPEN, KeyEvent.VK_O);
    addMenuItem(file, fileHandler,
        Text.get("MENU_FILE_SAVE"), ImageIconStyle.ICON_MENU_FILE_SAVE,
        HandlerCode.MENU_FILE_SAVE, KeyEvent.VK_S);
    addMenuItem(file, fileHandler,
        Text.get("MENU_FILE_UPDATE_CURRENCIES"),
        ImageIconStyle.ICON_MENU_FILE_UPDATE_CURRENCIES,
        HandlerCode.MENU_FILE_UPDATE_CURRENCIES);
    addMenuItem(file, fileHandler,
        Text.get("MENU_FILE_EXIT"), ImageIconStyle.ICON_MENU_FILE_EXIT,
        HandlerCode.MENU_FILE_EXIT);

    MenuEditHandler editHandler = new MenuEditHandler(frame);
    addMenuItem(edit, editHandler,
        Text.get("MENU_EDIT_ADD"), ImageIconStyle.ICON_MENU_EDIT_ADD,
        HandlerCode.MENU_EDIT_ADD);
    menuEdit = addMenuItem(edit, editHandler,
        Text.get("MENU_EDIT_EDIT"), ImageIconStyle.ICON_MENU_EDIT_EDIT,
        HandlerCode.MENU_EDIT_EDIT);
    menuDelete = addMenuItem(edit, editHandler,
        Text.get("MENU_EDIT_DELETE"),
        ImageIconStyle.ICON_MENU_EDIT_DELETE,
        HandlerCode.MENU_EDIT_DELETE);
    menuEdit.setEnabled(false);
    menuDelete.setEnabled(false);

    MenuViewHandler viewHandler = new MenuViewHandler(frame);
    addMenuItem(view, viewHandler,
        Text.get("MENU_VIEW_OVERVIEW"), ImageIconStyle.ICON_MENU_VIEW_OVERVIEW,
        HandlerCode.MENU_VIEW_OVERVIEW);
    addMenuItem(view, viewHandler,
        Text.get("MENU_VIEW_ACCOUNTS"), ImageIconStyle.ICON_MENU_VIEW_ACCOUNTS,
        HandlerCode.MENU_VIEW_ACCOUNTS);
    addMenuItem(view, viewHandler,
        Text.get("MENU_VIEW_ARTICLES"), ImageIconStyle.ICON_MENU_VIEW_ARTICLES,
        HandlerCode.MENU_VIEW_ARTICLES);
    addMenuItem(view, viewHandler,
        Text.get("MENU_VIEW_TRANSACTIONS"),
        ImageIconStyle.ICON_MENU_VIEW_TRANSACTIONS,
        HandlerCode.MENU_VIEW_TRANSACTIONS);
    addMenuItem(view, viewHandler,
        Text.get("MENU_VIEW_TRANSFERS"), ImageIconStyle.ICON_MENU_VIEW_TRANSFERS,
        HandlerCode.MENU_VIEW_TRANSFERS);
    addMenuItem(view, viewHandler,
        Text.get("MENU_VIEW_CURRENCIES"), ImageIconStyle.ICON_MENU_VIEW_CURRENCIES,
        HandlerCode.MENU_VIEW_CURRENCIES);
    addMenuItem(view, viewHandler,
        Text.get("MENU_VIEW_STATISTICS"), ImageIconStyle.ICON_MENU_VIEW_STATISTICS,
        HandlerCode.MENU_VIEW_STATISTICS);

    MenuSettingsHandler settingsHandler = new MenuSettingsHandler(frame);
    JMenu language = new JMenu(Text.get("MENU_SETTINGS_LANGUAGE"));
    language.setIcon(ImageIconStyle.ICON_MENU_SETTINGS_LANGUAGE);
    settings.add(language);

    ButtonGroup group = new ButtonGroup();
    JRadioButtonMenuItem menuUkrainian = new JRadioButtonMenuItem(
        Text.get("MENU_SETTINGS_LANGUAGE_UKRAINIAN"));
    JRadioButtonMenuItem menuEnglish = new JRadioButtonMenuItem(
        Text.get("MENU_SETTINGS_LANGUAGE_ENGLISH"));
    menuUkrainian.addActionListener(settingsHandler);
    menuEnglish.addActionListener(settingsHandler);

    group.add(menuUkrainian);
    group.add(menuEnglish);

    menuUkrainian.setIcon(ImageIconStyle.ICON_MENU_SETTINGS_LANGUAGE_UKRAINIAN);
    menuEnglish.setIcon(ImageIconStyle.ICON_MENU_SETTINGS_LANGUAGE_ENGLISH);
    menuUkrainian.setActionCommand(HandlerCode.MENU_SETTINGS_LANGUAGE_UKRAINIAN);
    menuEnglish.setActionCommand(HandlerCode.MENU_SETTINGS_LANGUAGE_ENGLISH);

    if (Settings.getLanguage().equals("uk")) {
      menuUkrainian.setSelected(true);
    } else if (Settings.getLanguage().equals("en")) {
      menuEnglish.setSelected(true);
    }

    language.add(menuUkrainian);
    language.add(menuEnglish);

    MenuHelpHandler helpHandler = new MenuHelpHandler(frame);
    addMenuItem(help, helpHandler,
        Text.get("MENU_HELP_ABOUT"), ImageIconStyle.ICON_MENU_HELP_ABOUT,
        HandlerCode.MENU_HELP_ABOUT);
  }

  private JMenuItem addMenuItem(JMenu menu, Handler listener, String title,
                                ImageIcon icon, String action, int key
  ) {
    JMenuItem item = new JMenuItem(title);
    item.setIcon(icon);
    item.setActionCommand(action);
    item.addActionListener(listener);
    if (key != 0) {
      KeyStroke shortKey = KeyStroke.getKeyStroke(key,
          Toolkit.getDefaultToolkit().getMenuShortcutKeyMaskEx());
      item.setAccelerator(shortKey);
    }
    menu.add(item);
    return item;
  }

  private JMenuItem addMenuItem(JMenu menu, Handler listener,
                                String title, ImageIcon icon, String action
  ) {
    return addMenuItem(menu, listener, title, icon, action, 0);
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
