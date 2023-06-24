package settings.exceptions;

import java.util.HashMap;
import java.util.Map;
import settings.Text;

/**
 * The ModelException class represents an exception specific to the application's models.
 */
public class ModelException extends Exception {
  public static final int TITLE_EMPTY = 1;
  public static final int IS_EXISTS = 2;
  public static final int DATE_FORMAT = 3;
  public static final int CODE_EMPTY = 4;
  public static final int CURRENCY_EMPTY = 5;
  public static final int ARTICLE_EMPTY = 6;
  public static final int ACCOUNT_EMPTY = 7;
  public static final int RATE_INCORRECT = 8;
  public static final int AMOUNT_FORMAT = 9;
  public static final int NO_BASE_CURRENCY = 10;
  private final int code;
  private static final Map<Integer, String> ERROR_MESSAGES
      = new HashMap<>();

  static {
    ERROR_MESSAGES.put(TITLE_EMPTY,
        Text.get("ERROR_TITLE_EMPTY"));
    ERROR_MESSAGES.put(IS_EXISTS,
        Text.get("ERROR_IS_EXISTS"));
    ERROR_MESSAGES.put(DATE_FORMAT,
        Text.get("ERROR_DATE_FORMAT"));
    ERROR_MESSAGES.put(CODE_EMPTY,
        Text.get("ERROR_CODE_EMPTY"));
    ERROR_MESSAGES.put(CURRENCY_EMPTY,
        Text.get("ERROR_CURRENCY_EMPTY"));
    ERROR_MESSAGES.put(ARTICLE_EMPTY,
        Text.get("ERROR_ARTICLE_EMPTY"));
    ERROR_MESSAGES.put(ACCOUNT_EMPTY,
        Text.get("ERROR_ACCOUNT_EMPTY"));
    ERROR_MESSAGES.put(RATE_INCORRECT,
        Text.get("ERROR_RATE_INCORRECT"));
    ERROR_MESSAGES.put(AMOUNT_FORMAT,
        Text.get("ERROR_AMOUNT_FORMAT"));
    ERROR_MESSAGES.put(NO_BASE_CURRENCY,
        Text.get("ERROR_NO_BASE_CURRENCY"));
  }

  public ModelException(final int errorCode) {
    this.code = errorCode;
  }

  /**
  * Retrieves the error message corresponding to the error code.
  *
  * @return the error message.
  */
  @Override
  public String getMessage() {
    return ERROR_MESSAGES.getOrDefault(code, "");
  }
}
