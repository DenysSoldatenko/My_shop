package datastorages;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import models.Account;
import models.Article;
import models.Currency;
import models.Transaction;
import models.Transfer;

/**
 * The Wrapper class is a data storage class that serves as a wrapper for storing lists of
 * various financial entities such as articles, accounts, transactions, transfers, and currencies.
 * It is primarily used for serialization and deserialization purposes,
 * allowing the data to be easily stored and retrieved in a structured format.
 * The class utilizes the Jackson library annotations for JSON serialization and deserialization.
 */
@Getter
@Setter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public final class Wrapper {

  @JsonProperty("articles")
  private List<Article> articles;

  @JsonProperty("accounts")
  private List<Account> accounts;

  @JsonProperty("transactions")
  private List<Transaction> transactions;

  @JsonProperty("transfers")
  private List<Transfer> transfers;

  @JsonProperty("currencies")
  private List<Currency> currencies;
}
