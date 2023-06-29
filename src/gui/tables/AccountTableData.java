package gui.tables;

import gui.handlers.FunctionsHandler;
import gui.tables.models.AccountTableModel;
import javax.swing.ImageIcon;
import settings.styles.ImageIconStyle;

/**
 * The AccountTableData class represents a table for displaying account data.
 */
public class AccountTableData extends TableData {

  private static final String[] columns = new String[]{"TITLE", "AMOUNT"};
  private static final ImageIcon[] icons = new ImageIcon[]{
    ImageIconStyle.ICON_TITLE, ImageIconStyle.ICON_AMOUNT};

  public AccountTableData(FunctionsHandler handler) {
    super(new AccountTableModel(columns), handler, columns, icons);
  }
}
