import datastorages.SaveData;
import gui.MainFrame;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Account;
import models.Article;
import models.Currency;
import models.Transaction;
import models.Transfer;
import settings.Settings;
import settings.Text;
import settings.exceptions.ModelException;

/**
 * The Main class serves as the entry point of the application.
 */
public class Main {
  public static void main(String[] args) {
    init();
    MainFrame mainFrame = new MainFrame();
  }

  private static void init() {
    try {
      Settings.init();
      Text.init();
      GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
      ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, Settings.FONT_ROBOTO_LIGHT));
    } catch (FontFormatException | IOException ex) {
      Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
    }
  }

  private static void testModels() throws ModelException {
    Currency c1 = new Currency("Долар", "USD", 36, true, false);
    Currency c2 = new Currency("Євро", "EUR", 40, false, false);
    Currency c3 = new Currency("Гривня", "UAH", 1, true, true);

    Account ac1 = new Account("Гаманець", c3, 1000);
    Account ac2 = new Account("Карта Visa", c1, 0);
    Account ac3 = new Account("Депозит у банку (EUR)", c2, 100000);
    Account ac4 = new Account("Депозит у банку (USD)", c1, 0);

    final ArrayList<Currency> currencies = new ArrayList<>(Arrays.asList(c1, c2, c3));
    ArrayList<Account> accounts = new ArrayList<>(Arrays.asList(ac1, ac2, ac3, ac4));
    ArrayList<Article> articles = new ArrayList<>(
        Arrays.asList(
          new Article("Продукти"),
          new Article("Зарплата"),
          new Article("Відсотки за депозитом")
        )
    );

    ArrayList<Transaction> transactions = new ArrayList<>(
        Arrays.asList(
          new Transaction(ac2, articles.get(1), 30000),
          new Transaction(ac2, articles.get(0), -1500, "На вихідні"),
          new Transaction(ac1, articles.get(2), -5500, "Квартира"),
          new Transaction(ac1, articles.get(2), -4000, "Розваги"),
          new Transaction(ac3, articles.get(0), 1000),
          new Transaction(ac2, articles.get(1), 25000,
              new Date((new Date()).getTime() - (long) 86400000 * 30)),
          new Transaction(ac3, articles.get(0), 1000,
              new Date((new Date()).getTime() - (long) 86400000 * 30))
      )
    );

    for (int i = 0; i < 50; i++) {
      Article tempArticle = (Math.random() < 0.5) ? articles.get(0) : articles.get(2);
      Account tempAccount = (Math.random() < 0.5) ? ac1 : ac2;
      double tempAmount = Math.round(Math.random() * (-1000));
      Date tempDate = new Date((long) (new Date().getTime()
          - (long) 86400000 * 30 * Math.random()));
      transactions.add(new Transaction(tempAccount, tempArticle, tempAmount, tempDate));
    }

    ArrayList<Transfer> transfers = new ArrayList<>(
        Arrays.asList(
          new Transfer(ac2, ac1, 25000, 25000),
          new Transfer(ac2, ac3, 3000, 3000),
          new Transfer(ac2, ac4, 6000, 90)
        )
    );

    accounts.forEach(a -> a.setAmountFromTransactionsAndTransfers(transactions, transfers));

    SaveData sd = SaveData.getInstance();
    sd.setArticles(articles);
    sd.setAccounts(accounts);
    sd.setCurrencies(currencies);
    sd.setTransactions(transactions);
    sd.setTransfers(transfers);
    sd.save();
  }
}