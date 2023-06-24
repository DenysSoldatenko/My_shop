package datastorages;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import lombok.Getter;
import lombok.ToString;
import models.Account;
import models.Article;
import models.Common;
import models.Currency;
import models.Filter;
import models.Transaction;
import models.Transfer;
import settings.exceptions.ModelException;

/**
 * The SaveData class represents the data storage for the application.
 * It holds lists of articles, currencies,accounts, transactions, and transfers.
 * It provides methods for managing and manipulating the data.
 */
@Getter
@ToString
public final class SaveData {

  private static SaveData instance;
  private List<Article> articles = new ArrayList<>();
  private List<Currency> currencies = new ArrayList<>();
  private List<Account> accounts = new ArrayList<>();
  private List<Transaction> transactions = new ArrayList<>();
  private List<Transfer> transfers = new ArrayList<>();

  private final Filter filter;
  private Common oldCommon;
  private boolean saved = true;

  private SaveData() {
    load();
    this.filter = new Filter();
  }

  private void load() {
    SaveLoad.load(this);
    sort();
  }

  /**
   * Saves the data to the storage.
   */
  public void save() {
    SaveLoad.save(this);
    saved = true;
  }

  private void sort() {
    this.articles.sort((Article a, Article a1) -> a.getTitle().compareToIgnoreCase(a1.getTitle()));
    this.accounts.sort((Account a, Account a1) -> a.getTitle().compareToIgnoreCase(a1.getTitle()));
    this.transactions.sort((Transaction t, Transaction t1) -> t1.getDate().compareTo(t.getDate()));
    this.transfers.sort((Transfer t, Transfer t1) -> t1.getDate().compareTo(t.getDate()));
    this.currencies.sort((c, c1) -> {
      if (c.isBase()) {
        return -1;
      }
      if (c1.isBase()) {
        return 1;
      }
      if (c.isOn() ^ c1.isOn()) {
        if (c1.isOn()) {
          return 1;
        } else {
          return -1;
        }
      }
      return c.getTitle().compareToIgnoreCase(c1.getTitle());
    });
  }

  /**
   * Returns the instance of the SaveData class.
   *
   * @return The SaveData instance.
   */
  public static SaveData getInstance() {
    if (instance == null) {
      instance = new SaveData();
    }
    return instance;
  }

  /**
   * Sets the list of articles.
   *
   * @param newArticles The new list of articles.
   */
  public void setArticles(final List<Article> newArticles) {
    if (articles != null) {
      this.articles = newArticles;
    }
  }

  /**
   * Sets the list of currencies.
   *
   * @param newCurrencies The new list of currencies.
   */
  public void setCurrencies(final List<Currency> newCurrencies) {
    if (currencies != null) {
      this.currencies = newCurrencies;
    }
  }

  /**
   * Sets the list of accounts.
   *
   * @param newAccounts The new list of accounts.
   */
  public void setAccounts(final List<Account> newAccounts) {
    if (accounts != null) {
      this.accounts = newAccounts;
    }
  }

  /**
   * Sets the list of transactions.
   *
   * @param newTransactions The new list of transactions.
   */
  public void setTransactions(final List<Transaction> newTransactions) {
    if (transactions != null) {
      this.transactions = newTransactions;
    }
  }

  /**
   * Sets the list of transfers.
   *
   * @param newTransfers The new list of transfers.
   */
  public void setTransfers(final List<Transfer> newTransfers) {
    if (transfers != null) {
      this.transfers = newTransfers;
    }
  }

  /**
   * Returns the base currency.
   *
   * @return The base currency.
   */
  public Currency getBaseCurrency() {
    for (Currency c : currencies) {
      if (c.isBase()) {
        return c;
      }
    }
    return new Currency();
  }

  /**
   * Returns the list of enabled currencies.
   *
   * @return The list of enabled currencies.
   */
  public ArrayList<Currency> getEnableCurrencies() {
    ArrayList<Currency> list = new ArrayList<>();
    for (Currency c : currencies) {
      if (c.isOn()) {
        list.add(c);
      }
    }
    return list;
  }

  /**
   * Returns the list of transactions that match the current filter.
   *
   * @return The list of filtered transactions.
   */
  public List<Transaction> getFilterTransactions() {
    ArrayList<Transaction> list = new ArrayList<>();
    for (Transaction t : transactions) {
      if (filter.check(t.getDate())) {
        list.add(t);
      }
    }
    return list;
  }

  /**
   * Returns the list of transfers that match the current filter.
   *
   * @return The list of filtered transfers.
   */
  public List<Transfer> getFilterTransfers() {
    ArrayList<Transfer> list = new ArrayList<>();
    for (Transfer t : transfers) {
      if (filter.check(t.getDate())) {
        list.add(t);
      }
    }
    return list;
  }

  /**
   * Returns a list of transactions up to the specified count.
   *
   * @param count The maximum number of transactions to return.
   * @return The list of transactions.
   */
  public List<Transaction> getTransactionsOnCount(int count) {
    return new ArrayList<>(transactions.subList(0, Math.min(count, transactions.size())));
  }

  /**
   * Updates the currency rates based on the current rates.
   */
  public void updateCurrencies() {
    HashMap<String, Double> rates = RateCurrency.getRates();
    for (Currency c : currencies) {
      if (!Objects.equals(c.getCode(), "UAH")) {
        c.setRate(rates.get(c.getCode()));
      }
    }
    for (Account a : accounts) {
      if (!Objects.equals(a.getCurrency().getCode(), "UAH")) {
        a.getCurrency().setRate(rates.get(a.getCurrency().getCode()));
      }
    }
    saved = false;
  }

  /**
   * Adds a new common object to the appropriate list.
   *
   * @param c The common object to add.
   * @throws ModelException if the object already exists.
   */
  public void add(Common c) throws ModelException {
    List ref = getRef(c);
    if (ref.contains(c)) {
      throw new ModelException(ModelException.IS_EXISTS);
    }
    ref.add(c);
    c.postAdd(this);
    sort();
    saved = false;
  }

  /**
   * Edits an existing common object with a new one.
   *
   * @param oldC The old common object.
   * @param newC The new common object.
   * @throws ModelException if the new object already exists.
   */
  public void edit(Common oldC, Common newC) throws ModelException {
    List ref = getRef(oldC);
    if (ref.contains(newC) && oldC != ref.get(ref.indexOf(newC))) {
      throw new ModelException(ModelException.IS_EXISTS);
    }
    ref.set(ref.indexOf(oldC), newC);
    oldCommon = oldC;
    newC.postEdit(this);
    sort();
    saved = false;
  }

  /**
   * Removes a common object from the appropriate list.
   *
   * @param c The common object to remove.
   */
  public void remove(Common c) {
    getRef(c).remove(c);
    c.postRemove(this);
    saved = false;
  }

  private List<?> getRef(Common c) {
    if (c instanceof Account) {
      return accounts;
    } else if (c instanceof Article) {
      return articles;
    } else if (c instanceof Currency) {
      return currencies;
    } else if (c instanceof Transaction) {
      return transactions;
    } else if (c instanceof Transfer) {
      return transfers;
    }
    return null;
  }
}
