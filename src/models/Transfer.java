package models;

import java.util.Date;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import settings.exceptions.ModelException;

/**
 * Represents a transfer between two accounts.
 */
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

  /**
   * Constructs a transfer with the specified parameters.
   *
   * @param fromAccount the account from which the amount is transferred
   * @param toAccount the account to which the amount is transferred
   * @param fromAmount the amount transferred from the fromAmount
   * @param toAmount the amount transferred to the toAccount
   * @param notice the notice or description of the transfer
   * @param date the date of the transfer
   * @throws ModelException if any of the parameters are invalid
   */
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
