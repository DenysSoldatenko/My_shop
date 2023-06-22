package models;

import exceptions.ModelException;
import java.util.List;
import java.util.Objects;

public final class Account extends Common {
	private String title;
	private Currency currency;
	private double startAmount;
	private double amount;

	public Account(
		final String accountTitle,
		final Currency cur,
		final double startAmt
	) throws ModelException {
		if (accountTitle.length() == 0) {
			throw new ModelException(ModelException.TITLE_EMPTY);
		}
		if (cur == null) {
			throw new ModelException(ModelException.CURRENCY_EMPTY);
		}
		this.title = accountTitle;
		this.currency = cur;
		this.startAmount = startAmt;
	}

	public double getAmount() {
		return amount;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(final String newTitle) {
		this.title = newTitle;
	}

	public Currency getCurrency() {
		return currency;
	}

	public void setCurrency(final Currency newCurrency) {
		this.currency = newCurrency;
	}

	public double getStartAmount() {
		return startAmount;
	}

	public void setStartAmount(final double newStartAmount) {
		this.startAmount = newStartAmount;
	}
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
	public boolean equals(final Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Account account = (Account) o;
		return Objects.equals(title, account.title);
	}

	@Override
	public int hashCode() {
		return Objects.hash(title);
	}

	@Override
	public String getValueFromComboBox() {
		return title;
	}

	@Override
	public String toString() {
		return "Account{" + "title=" + title + ", currency="
			+ currency + ", startAmount=" + startAmount
			+ ", amount=" + amount + '}';
	}
}
