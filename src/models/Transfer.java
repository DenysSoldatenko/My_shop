package models;

import exceptions.ModelException;
import java.util.Date;

public final class Transfer extends Common {
	private Account fromAccount;
	private Account toAccount;
	private double fromAmount;
	private double toAmount;
	private String notice;
	private Date date;

	public Transfer(
		final Account fromAcc,
		final Account toAcc,
		final double fromAmt,
		final double toAmt,
		final String note,
		final Date transferDate
	) throws ModelException {
		if (fromAcc == null) {
			throw new ModelException(ModelException.ACCOUNT_EMPTY);
		}
		if (toAcc == null) {
			throw new ModelException(ModelException.ACCOUNT_EMPTY);
		}
		if (fromAmt < 0 || toAmt < 0) {
			throw new ModelException(ModelException.AMOUNT_FORMAT);
		}
		if (transferDate == null) {
			throw new ModelException(ModelException.DATE_FORMAT);
		}
		this.fromAccount = fromAcc;
		this.toAccount = toAcc;
		this.fromAmount = fromAmt;
		this.toAmount = toAmt;
		this.notice = note;
		this.date = transferDate;
	}

	public Transfer(
		final Account fromAcc,
		final Account toAcc,
		final double fromAmt,
		final double toAmt,
		final String note
	) throws ModelException {
		this(fromAcc, toAcc, fromAmt, toAmt, note, new Date());
	}

	public Transfer(
		final Account fromAcc,
		final Account toAcc,
		final double fromAmt,
		final double toAmt,
		final Date transferDate
	) throws ModelException {
		this(fromAcc, toAcc, fromAmt, toAmt, "", transferDate);
	}

	public Transfer(
		final Account fromAcc,
		final Account toAcc,
		final double fromAmt,
		final double toAmt) throws ModelException {
		this(fromAcc, toAcc, fromAmt, toAmt, "", new Date());
	}

	public Account getFromAccount() {
		return fromAccount;
	}

	public void setFromAccount(final Account fromAcc) {
		this.fromAccount = fromAcc;
	}

	public Account getToAccount() {
		return toAccount;
	}

	public void setToAccount(final Account toAcc) {
		this.toAccount = toAcc;
	}

	public double getFromAmount() {
		return fromAmount;
	}

	public void setFromAmount(final double fromAmt) {
		this.fromAmount = fromAmt;
	}

	public double getToAmount() {
		return toAmount;
	}

	public void setToAmount(final double toAmt) {
		this.toAmount = toAmt;
	}

	public String getNotice() {
		return notice;
	}

	public void setNotice(final String newNotice) {
		this.notice = newNotice;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(final Date newDate) {
		this.date = newDate;
	}

	@Override
	public String toString() {
		return "Transfer{" + "fromAccount=" + fromAccount
			+ ", toAccount=" + toAccount + ", fromAmount="
			+ fromAmount + ", toAmount=" + toAmount + ", notice="
			+ notice + ", date=" + date + '}';
	}
}

