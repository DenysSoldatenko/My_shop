package gui.dialogs.editings;

import gui.MainFrame;
import java.util.Objects;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import models.Common;
import models.Currency;
import settings.Format;
import settings.Settings;
import settings.Text;
import settings.exceptions.ModelException;
import settings.styles.ImageIconStyle;

/**
 * A dialog for adding or editing a Currency.
 */
public class CurrencyAddEditDialog extends AddEditDialog {

  public CurrencyAddEditDialog(MainFrame frame) {
    super(frame);
  }

  @Override
  protected void init() {
    elements.put("LABEL_TITLE", new JTextField());
    elements.put("LABEL_CODE", new JComboBox<>(Settings.CURRENCIES_CODES));
    elements.put("LABEL_RATE", new JTextField());
    elements.put("LABEL_ON", new JComboBox<>(new String[]{Text.get("YES"), Text.get("NO")}));
    elements.put("LABEL_BASE", new JComboBox<>(new String[]{Text.get("YES"), Text.get("NO")}));

    icons.put("LABEL_TITLE", ImageIconStyle.ICON_TITLE);
    icons.put("LABEL_CODE", ImageIconStyle.ICON_CODE);
    icons.put("LABEL_RATE", ImageIconStyle.ICON_RATE);
    icons.put("LABEL_ON", ImageIconStyle.ICON_ON);
    icons.put("LABEL_BASE", ImageIconStyle.ICON_BASE);

    values.put("LABEL_RATE", Format.amount(1));
  }

  @Override
  protected void setValues() {
    Currency currency = (Currency) common;
    values.put("LABEL_TITLE", currency.getTitle());
    values.put("LABEL_CODE", currency.getCode());
    values.put("LABEL_RATE", currency.getRate());
    if (currency.isOn()) {
      values.put("LABEL_ON", Text.get("YES"));
    } else {
      values.put("LABEL_ON", Text.get("NO"));
    }
    if (currency.isBase()) {
      values.put("LABEL_BASE", Text.get("YES"));
    } else {
      values.put("LABEL_BASE", Text.get("NO"));
    }
  }

  @Override
  public Common getCommonFromForm() throws ModelException {
    try {
      String title = ((JTextField) elements.get("LABEL_TITLE")).getText();
      String code = (String) ((JComboBox<?>) elements.get("LABEL_CODE")).getSelectedItem();
      String rate = ((JTextField) elements.get("LABEL_RATE")).getText();
      boolean isOn = Objects.equals(((JComboBox<?>) elements.get("LABEL_ON")).getSelectedItem(),
          Text.get("YES"));
      boolean isBase = Objects.equals(((JComboBox<?>) elements.get("LABEL_BASE")).getSelectedItem(),
          Text.get("YES"));
      if (!isBase && common != null && ((Currency) common).isBase()) {
        throw new ModelException(ModelException.NO_BASE_CURRENCY);
      }
      return new Currency(title, code, Format.fromAmountToNumber(rate), isOn, isBase);
    } catch (NumberFormatException ex) {
      throw new ModelException(ModelException.AMOUNT_FORMAT);
    }
  }
}

