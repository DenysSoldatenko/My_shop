package datastorages;

import java.util.ArrayList;
import java.util.List;
import models.Account;
import models.Article;
import models.Currency;
import models.Transaction;
import models.Transfer;

public final class SaveData {
	private SaveData() { }
	private static SaveData instance;
	private List<Article> articles = new ArrayList<>();
	private List<Currency> currencies = new ArrayList<>();
	private List<Account> accounts = new ArrayList<>();
	private List<Transaction> transactions = new ArrayList<>();
	private List<Transfer> transfers = new ArrayList<>();

	public static SaveData getInstance() {
		if (instance == null) {
			instance = new SaveData();
		}
		return instance;
	}

	public List<Article> getArticles() {
		return articles;
	}

	public List<Currency> getCurrencies() {
		return currencies;
	}

	public List<Account> getAccounts() {
		return accounts;
	}

	public List<Transaction> getTransactions() {
		return transactions;
	}

	public List<Transfer> getTransfers() {
		return transfers;
	}

	public void setArticles(final List<Article> newArticles) {
		if (articles != null) {
			this.articles = newArticles;
		}
	}

	public void setCurrencies(final List<Currency> newCurrencies) {
		if (currencies != null) {
			this.currencies = newCurrencies;
		}
	}

	public void setAccounts(final List<Account> newAccounts) {
		if (accounts != null) {
			this.accounts = newAccounts;
		}
	}

	public void setTransactions(final List<Transaction> newTransactions) {
		if (transactions != null) {
			this.transactions = newTransactions;
		}
	}

	public void setTransfers(final List<Transfer> newTransfers) {
		if (transfers != null) {
			this.transfers = newTransfers;
		}
	}
	public Currency getBaseCurrency() {
		for (Currency c : currencies) {
			if (c.isBase()) {
				return c;
			}
		}
		return new Currency();
	}
}
