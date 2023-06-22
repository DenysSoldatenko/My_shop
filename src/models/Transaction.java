package models;

import exceptions.ModelException;
import java.util.Date;

public final class Transaction extends Common {

	private Account account;
	private Article article;
	private double amount;
	private String notice;
	private Date date;

	public Transaction(
		final Account acc,
		final Article art,
		final double amt,
		final String note,
		final Date transDate
	) throws ModelException {
		if (acc == null) {
			throw new ModelException(ModelException.ACCOUNT_EMPTY);
		}
		if (art == null) {
			throw new ModelException(ModelException.ARTICLE_EMPTY);
		}
		if (transDate == null) {
			throw new ModelException(ModelException.DATE_FORMAT);
		}
		this.account = acc;
		this.article = art;
		this.amount = amt;
		this.notice = note;
		this.date = transDate;
	}

	public Transaction(
		final Account acc,
		final Article art,
		final double amt,
		final String note
	) throws ModelException {
		this(acc, art, amt, note, new Date());
	}

	public Transaction(
		final Account acc,
		final Article art,
		final double amt,
		final Date transDate
	) throws ModelException {
		this(acc, art, amt, "", transDate);
	}

	public Transaction(
		final Account acc,
		final Article art,
		final double amt
	) throws ModelException {
		this(acc, art, amt, "", new Date());
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(final Account acc) {
		this.account = acc;
	}

	public Article getArticle() {
		return article;
	}

	public void setArticle(final Article art) {
		this.article = art;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(final double amt) {
		this.amount = amt;
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
}
