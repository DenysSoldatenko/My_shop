package gui.dialogs;

import datastorages.SaveData;
import gui.MainFrame;
import javax.swing.JTextField;
import models.Account;
import models.Common;
import models.Currency;
import settings.Format;
import settings.exceptions.ModelException;
import settings.styles.ImageIconStyle;

/**
 * A dialog for adding or editing an account.
 */
public class AccountAddEditDialog extends AddEditDialog {

  public AccountAddEditDialog(MainFrame frame) {
    super(frame);
  }

  @Override
  protected void init() {
    elements.put("LABEL_TITLE", new JTextField());
    elements.put("LABEL_CURRENCY", new CommonComboBox(SaveData.getInstance()
          .getEnableCurrencies().toArray((new Common[0]))));
    elements.put("LABEL_START_AMOUNT", new JTextField());

    icons.put("LABEL_TITLE", ImageIconStyle.ICON_TITLE);
    icons.put("LABEL_CURRENCY", ImageIconStyle.ICON_CURRENCY);
    icons.put("LABEL_START_AMOUNT", ImageIconStyle.ICON_AMOUNT);

    values.put("LABEL_START_AMOUNT", Format.amount(0));
  }

  @Override
  protected void setValues() {
    Account account = (Account) common;
    values.put("LABEL_TITLE", account.getTitle());
    values.put("LABEL_CURRENCY", account.getCurrency());
    values.put("LABEL_START_AMOUNT", account.getStartAmount());
  }

  @Override
  public Common getCommonFromForm() throws ModelException {
    try {
      String title = ((JTextField) elements.get("LABEL_TITLE")).getText();
      String startAmount = ((JTextField) elements.get("LABEL_START_AMOUNT")).getText();
      Currency currency = (Currency) ((CommonComboBox) elements.get("LABEL_CURRENCY"))
          .getSelectedItem();
      return new Account(title, currency, Format.fromAmountToNumber(startAmount));
    } catch (NumberFormatException ex) {
      throw new ModelException(ModelException.AMOUNT_FORMAT);
    }
  }
}
