package gui.dialogs.editings;

import datastorages.SaveData;
import gui.MainDatePicker;
import gui.MainFrame;
import gui.dialogs.CommonComboBox;
import java.util.Date;
import javax.swing.JTextField;
import models.Account;
import models.Common;
import models.Transfer;
import org.jdatepicker.impl.JDatePickerImpl;
import settings.Format;
import settings.exceptions.ModelException;
import settings.styles.ImageIconStyle;

/**
 * A dialog for adding or editing a Transfer.
 */
public class TransferAddEditDialog extends AddEditDialog {

  public TransferAddEditDialog(MainFrame frame) {
    super(frame);
  }

  @Override
  protected void init() {
    elements.put("LABEL_DATE", new MainDatePicker().getDatePicker());
    elements.put("LABEL_FROM_ACCOUNT", new CommonComboBox(SaveData.getInstance().getAccounts()
         .toArray((new Common[0]))));
    elements.put("LABEL_TO_ACCOUNT", new CommonComboBox(SaveData.getInstance().getAccounts()
         .toArray((new Common[0]))));
    elements.put("LABEL_FROM_AMOUNT", new JTextField());
    elements.put("LABEL_TO_AMOUNT", new JTextField());
    elements.put("LABEL_NOTICE", new JTextField());

    icons.put("LABEL_DATE", ImageIconStyle.ICON_DATE);
    icons.put("LABEL_FROM_ACCOUNT", ImageIconStyle.ICON_ACCOUNT);
    icons.put("LABEL_TO_ACCOUNT", ImageIconStyle.ICON_ACCOUNT);
    icons.put("LABEL_FROM_AMOUNT", ImageIconStyle.ICON_AMOUNT);
    icons.put("LABEL_TO_AMOUNT", ImageIconStyle.ICON_AMOUNT);
    icons.put("LABEL_NOTICE", ImageIconStyle.ICON_NOTICE);

    values.put("LABEL_DATE", new Date());
    values.put("LABEL_FROM_AMOUNT", Format.amount(0));
    values.put("LABEL_TO_AMOUNT", Format.amount(0));
  }

  @Override
  protected void setValues() {
    Transfer transfer = (Transfer) common;
    values.put("LABEL_DATE", transfer.getDate());
    values.put("LABEL_FROM_ACCOUNT", transfer.getFromAccount());
    values.put("LABEL_TO_ACCOUNT", transfer.getToAccount());
    values.put("LABEL_FROM_AMOUNT", transfer.getFromAmount());
    values.put("LABEL_TO_AMOUNT", transfer.getToAmount());
    values.put("LABEL_NOTICE", transfer.getNotice());
  }

  @Override
  public Common getCommonFromForm() throws ModelException {
    try {
      Account fromAccount = (Account)
          ((CommonComboBox) elements.get("LABEL_FROM_ACCOUNT")).getSelectedItem();
      Account toAccount = (Account)
          ((CommonComboBox) elements.get("LABEL_TO_ACCOUNT")).getSelectedItem();
      String fromAmount = ((JTextField) elements.get("LABEL_FROM_AMOUNT")).getText();
      String toAmount = ((JTextField) elements.get("LABEL_TO_AMOUNT")).getText();
      String notice = ((JTextField) elements.get("LABEL_NOTICE")).getText();
      Date date = (Date) ((JDatePickerImpl) elements.get("LABEL_DATE")).getModel().getValue();
      return new Transfer(fromAccount, toAccount, Format.fromAmountToNumber(fromAmount),
      Format.fromAmountToNumber(toAmount), notice, date);
    } catch (NumberFormatException ex) {
      throw new ModelException(ModelException.AMOUNT_FORMAT);
    }
  }
}
