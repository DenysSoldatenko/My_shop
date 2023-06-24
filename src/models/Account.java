package models;

import datastorages.SaveData;
import java.util.List;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import settings.exceptions.ModelException;

/**
 * Represents an account in the application.
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@EqualsAndHashCode(exclude = {
  "currency",
  "startAmount",
  "amount"
}, callSuper = false)
public final class Account extends Common {
  private String title;
  private Currency currency;
  private double startAmount;
  private double amount;

  /**
   * Constructs a new Account with the specified title, currency, and start amount.
   *
   * @param title       the title of the account
   * @param currency    the currency associated with the account
   * @param startAmount the initial amount of the account
   * @throws ModelException if the title is empty or the currency is null
   */
  public Account(
       final String title,
       final Currency currency,
       final double startAmount
  ) throws ModelException {
    if (title.length() == 0) {
      throw new ModelException(ModelException.TITLE_EMPTY);
    }
    if (currency == null) {
      throw new ModelException(ModelException.CURRENCY_EMPTY);
    }
    this.title = title;
    this.currency = currency;
    this.startAmount = startAmount;
  }

  /**
   * Sets the amount of the account based on the provided list of transactions and transfers.
   * The amount is calculated by summing the amounts of the transactions and adjusting for transfers
   * where the account is involved.
   *
   * @param transactions the list of transactions
   * @param transfers    the list of transfers
   */
  public void setAmountFromTransactionsAndTransfers(
      final List<Transaction> transactions,
      final List<Transfer> transfers
  ) {
    this.amount = startAmount;
    for (Transaction transaction : transactions) {
      if (transaction.getAccount().equals(this)) {
        this.amount += transaction.getAmount();
      }
    }

    for (Transfer transfer : transfers) {
      if (transfer.getFromAccount().equals(this)) {
        this.amount -= transfer.getFromAmount();
      }
      if (transfer.getToAccount().equals(this)) {
        this.amount += transfer.getToAmount();
      }
    }
  }

  @Override
  public void postAdd(final SaveData sd) {
    setAmountFromTransactionsAndTransfers(
        sd.getTransactions(),
        sd.getTransfers()
    );
  }

  @Override
  public void postEdit(final SaveData sd) {
    for (Transaction t : sd.getTransactions()) {
      if (t.getAccount().equals(sd.getOldCommon())) {
        t.setAccount(this);
      }
    }
    for (Transfer t : sd.getTransfers()) {
      if (t.getFromAccount().equals(sd.getOldCommon())) {
        t.setFromAccount(this);
      }
      if (t.getToAccount().equals(sd.getOldCommon())) {
        t.setToAccount(this);
      }
    }
    setAmountFromTransactionsAndTransfers(
        sd.getTransactions(),
        sd.getTransfers()
    );
  }

  @Override
  public String getValueFromComboBox() {
    return title;
  }
}
