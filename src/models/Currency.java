package models;

import exceptions.ModelException;
import java.util.Objects;

public final class Currency extends Common {
	private String title;
	private String code;
	private double rate;
	private boolean on;
	private boolean base;

	public Currency(
		final String currencyTitle,
		final String currencyCode,
		final double currencyRate,
		final boolean currencyOn,
		final boolean currencyBase
	) throws ModelException {
		if (currencyTitle.length() == 0) {
			throw new ModelException(ModelException.TITLE_EMPTY);
		}
		if (currencyCode.length() == 0) {
			throw new ModelException(ModelException.CODE_EMPTY);
		}
		if (currencyRate <= 0) {
			throw new ModelException(ModelException.RATE_INCORRECT);
		}
		this.title = currencyTitle;
		this.code = currencyCode;
		this.rate = currencyRate;
		this.on = currencyOn;
		this.base = currencyBase;
	}

	public Currency() { }

	public String getTitle() {
		return title;
	}

	public void setTitle(final String newTitle) {
		this.title = newTitle;
	}

	public String getCode() {
		return code;
	}

	public void setCode(final String newCode) {
		this.code = newCode;
	}

	public double getRate() {
		return rate;
	}

	public void setRate(final double newRate) {
		this.rate = newRate;
	}

	public boolean isOn() {
		return on;
	}

	public void setOn(final boolean newOn) {
		this.on = newOn;
	}

	public boolean isBase() {
		return base;
	}

	public void setBase(final boolean newBase) {
		this.base = newBase;
	}

	@Override
	public String toString() {
		return "Currency{" + "title=" + title
			+ ", code=" + code + ", rate="
			+ rate + ", isOn=" + on + ", isBase=" + base + '}';
	}

	@Override
	public boolean equals(final Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Currency currency = (Currency) o;
		return Objects.equals(code, currency.code);
	}

	@Override
	public int hashCode() {
		return Objects.hash(code);
	}

	@Override
	public String getValueFromComboBox() {
		return title;
	}

	public double getRateByCurrency(final Currency currency) {
		return rate / currency.rate;
	}
}

