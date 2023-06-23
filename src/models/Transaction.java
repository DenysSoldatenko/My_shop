package models;

import datastorages.SaveData;
import exceptions.ModelException;
import java.util.Date;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public final class Transaction extends Common {

  private Account account;
  private Article article;
  private double amount;
  private String notice;
  private Date date;

  public Transaction(
      final Account account,
      final Article article,
      final double amount,
      final String notice,
      final Date date
  ) throws ModelException {
    if (account == null) {
      throw new ModelException(ModelException.ACCOUNT_EMPTY);
    }
    if (article == null) {
      throw new ModelException(ModelException.ARTICLE_EMPTY);
    }
    if (date == null) {
      throw new ModelException(ModelException.DATE_FORMAT);
    }
    this.account = account;
    this.article = article;
    this.amount = amount;
    this.notice = notice;
    this.date = date;
  }

  public Transaction(
      final Account account,
      final Article article,
      final double amount,
      final String notice
  ) throws ModelException {
    this(account, article, amount, notice, new Date());
  }

  public Transaction(
      final Account account,
      final Article article,
      final double amount,
      final Date date
  ) throws ModelException {
    this(account, article, amount, "", date);
  }

  public Transaction(
      final Account account,
      final Article article,
      final double amount
  ) throws ModelException {
    this(account, article, amount, "", new Date());
  }

  private void setAmounts(SaveData sd) {
    for (Account a : sd.getAccounts()) {
      a.setAmountFromTransactionsAndTransfers(
          sd.getTransactions(),
          sd.getTransfers()
      );
    }
  }

  @Override
  public void postAdd(SaveData sd) {
    setAmounts(sd);
  }

  @Override
  public void postEdit(SaveData sd) {
    setAmounts(sd);
  }

  @Override
  public void postRemove(SaveData sd) {
    setAmounts(sd);
  }
}
