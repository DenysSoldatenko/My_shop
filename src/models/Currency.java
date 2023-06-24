package models;

import datastorages.SaveData;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import settings.exceptions.ModelException;

/**
 * Represents a currency in the application.
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@EqualsAndHashCode(exclude = {
  "title",
  "rate",
  "on",
  "base"
}, callSuper = false)
public final class Currency extends Common {
  private String title;
  private String code;
  private double rate;
  private boolean on;
  private boolean base;

  /**
   * Constructs a currency with the specified parameters.
   *
   * @param title the title of the currency
   * @param code the code of the currency
   * @param rate the exchange rate of the currency
   * @param on a flag indicating if the currency is active
   * @param base a flag indicating if the currency is the base currency
   * @throws ModelException if any of the parameters are invalid
   */
  public Currency(
      final String title,
      final String code,
      final double rate,
      final boolean on,
      final boolean base
  ) throws ModelException {
    if (title.length() == 0) {
      throw new ModelException(ModelException.TITLE_EMPTY);
    }
    if (code.length() == 0) {
      throw new ModelException(ModelException.CODE_EMPTY);
    }
    if (rate <= 0) {
      throw new ModelException(ModelException.RATE_INCORRECT);
    }
    this.title = title;
    this.code = code;
    this.rate = rate;
    this.on = on;
    this.base = base;
  }

  public double getRateByCurrency(final Currency currency) {
    return rate / currency.rate;
  }

  private void clearBase(SaveData sd) {
    if (base) {
      rate = 1;
      Currency old = (Currency) sd.getOldCommon();
      for (Currency c : sd.getCurrencies()) {
        if (!this.equals(c)) {
          c.setBase(false);
          if (old != null) {
            c.setRate(c.rate / old.rate);
          }
        }
      }
    }
  }

  @Override
  public String getValueFromComboBox() {
    return title;
  }

  @Override
  public void postAdd(SaveData sd) {
    clearBase(sd);
  }

  @Override
  public void postEdit(SaveData sd) {
    clearBase(sd);
    for (Currency currency : sd.getCurrencies()) {
      for (Account account : sd.getAccounts()) {
        if (account.getCurrency().equals(currency)) {
          account.setCurrency(currency);
        }
      }
      for (Transaction transaction : sd.getTransactions()) {
        if (transaction.getAccount().getCurrency().equals(currency)) {
          transaction.getAccount().setCurrency(currency);
        }
      }
      for (Transfer transfer : sd.getTransfers()) {
        if (transfer.getFromAccount().getCurrency().equals(currency)) {
          transfer.getFromAccount().setCurrency(currency);
        }
        if (transfer.getToAccount().getCurrency().equals(currency)) {
          transfer.getToAccount().setCurrency(currency);
        }
      }
    }
  }
}
