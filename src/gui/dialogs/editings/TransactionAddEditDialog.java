package gui.dialogs.editings;

import datastorages.SaveData;
import gui.MainDatePicker;
import gui.MainFrame;
import gui.dialogs.CommonComboBox;
import java.util.Date;
import javax.swing.JTextField;
import models.Account;
import models.Article;
import models.Common;
import models.Transaction;
import org.jdatepicker.impl.JDatePickerImpl;
import settings.Format;
import settings.exceptions.ModelException;
import settings.styles.ImageIconStyle;

/**
 * A dialog for adding or editing a Transaction.
 */
public class TransactionAddEditDialog extends AddEditDialog {

  public TransactionAddEditDialog(MainFrame frame) {
    super(frame);
  }

  @Override
  protected void init() {
    elements.put("LABEL_DATE", new MainDatePicker().getDatePicker());
    elements.put("LABEL_ACCOUNT", new CommonComboBox(SaveData.getInstance().getAccounts()
        .toArray((new Common[0]))));
    elements.put("LABEL_ARTICLE", new CommonComboBox(SaveData.getInstance().getArticles()
        .toArray((new Common[0]))));
    elements.put("LABEL_AMOUNT", new JTextField());
    elements.put("LABEL_NOTICE", new JTextField());

    icons.put("LABEL_DATE", ImageIconStyle.ICON_DATE);
    icons.put("LABEL_ACCOUNT", ImageIconStyle.ICON_ACCOUNT);
    icons.put("LABEL_ARTICLE", ImageIconStyle.ICON_ARTICLE);
    icons.put("LABEL_AMOUNT", ImageIconStyle.ICON_AMOUNT);
    icons.put("LABEL_NOTICE", ImageIconStyle.ICON_NOTICE);

    values.put("LABEL_DATE", new Date());
    values.put("LABEL_AMOUNT", Format.amount(0));
  }

  @Override
  protected void setValues() {
    Transaction transaction = (Transaction) common;
    values.put("LABEL_DATE", transaction.getDate());
    values.put("LABEL_ACCOUNT", transaction.getAccount());
    values.put("LABEL_ARTICLE", transaction.getArticle());
    values.put("LABEL_AMOUNT", transaction.getAmount());
    values.put("LABEL_NOTICE", transaction.getNotice());
  }

  @Override
  public Common getCommonFromForm() throws ModelException {
    try {
      Account acc = (Account) ((CommonComboBox) elements.get("LABEL_ACCOUNT")).getSelectedItem();
      Article art = (Article) ((CommonComboBox) elements.get("LABEL_ARTICLE")).getSelectedItem();
      String notice = ((JTextField) elements.get("LABEL_NOTICE")).getText();
      String amount = ((JTextField) elements.get("LABEL_AMOUNT")).getText();
      Date date = (Date) ((JDatePickerImpl) elements.get("LABEL_DATE")).getModel().getValue();
      return new Transaction(acc, art, Format.fromAmountToNumber(amount), notice, date);
    } catch (NumberFormatException ex) {
      throw new ModelException(ModelException.AMOUNT_FORMAT);
    }
  }
}
