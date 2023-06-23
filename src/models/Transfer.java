package models;

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
public final class Transfer extends Common {
  private Account fromAccount;
  private Account toAccount;
  private double fromAmount;
  private double toAmount;
  private String notice;
  private Date date;

  public Transfer(
      final Account fromAccount,
      final Account toAccount,
      final double fromAmount,
      final double toAmount,
      final String notice,
      final Date date
  ) throws ModelException {
    if (fromAccount == null) {
      throw new ModelException(ModelException.ACCOUNT_EMPTY);
    }
    if (toAccount == null) {
      throw new ModelException(ModelException.ACCOUNT_EMPTY);
    }
    if (fromAmount < 0 || toAmount < 0) {
      throw new ModelException(ModelException.AMOUNT_FORMAT);
    }
    if (date == null) {
      throw new ModelException(ModelException.DATE_FORMAT);
    }
    this.fromAccount = fromAccount;
    this.toAccount = toAccount;
    this.fromAmount = fromAmount;
    this.toAmount = toAmount;
    this.notice = notice;
    this.date = date;
  }

  public Transfer(
      final Account fromAccount,
      final Account toAccount,
      final double fromAmount,
      final double toAmount,
      final String notice
  ) throws ModelException {
    this(fromAccount, toAccount, fromAmount, toAmount, notice, new Date());
  }

  public Transfer(
      final Account fromAccount,
      final Account toAccount,
      final double fromAmount,
      final double toAmount,
      final Date date
  ) throws ModelException {
    this(fromAccount, toAccount, fromAmount, toAmount, "", date);
  }

  public Transfer(
      final Account fromAccount,
      final Account toAccount,
      final double fromAmount,
      final double toAmount
  ) throws ModelException {
    this(fromAccount, toAccount, fromAmount, toAmount, "", new Date());
  }
}
