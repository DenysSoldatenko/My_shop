package gui.tables.models;

import datastorages.SaveData;
import models.Account;
import settings.Format;

/**
 * The AccountTableModel class represents the table model for account data.
 */
public class AccountTableModel extends MainTableModel {

  private static final int TITLE = 0;
  private static final int AMOUNT = 1;

  public AccountTableModel(String[] columns) {
    super(SaveData.getInstance().getAccounts(), columns);
  }

  @Override
  protected void updateData() {
    data = SaveData.getInstance().getAccounts();
  }

  @Override
  public Object getValueAt(int row, int column) {
    if (data.isEmpty()) {
      return null;
    }
    Account account = (Account) data.get(row);
    return switch (column) {
      case TITLE -> account.getTitle();
      case AMOUNT -> Format.amount(account.getAmount(), account.getCurrency());
      default -> null;
    };
  }
}
