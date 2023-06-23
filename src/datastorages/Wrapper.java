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
