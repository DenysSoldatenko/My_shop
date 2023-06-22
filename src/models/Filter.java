package models;

import java.time.YearMonth;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public final class Filter {
	public static final int STEP_DAY = 0;
	public static final int STEP_MONTH = 1;
	public static final int STEP_YEAR = 2;
	private int step;
	private Date from;
	private Date to;

	public Filter() {
		this(STEP_MONTH);
	}

	public Filter(final int newStep) {
		this.step = newStep;
		setFromTo(new GregorianCalendar());
	}

	public int getStep() {
		return step;
	}

	public Date getFrom() {
		return from;
	}

	public Date getTo() {
		return to;
	}

	public void next() {
		offset(1);
	}

	public void prev() {
		offset(-1);
	}

	public void nextPeriod() {
		step += 1;
		if (step > STEP_YEAR) {
			step = STEP_DAY;
		}
		setFromTo(new GregorianCalendar());
	}

	public boolean check(final Date date) {
		return (date.compareTo(from) > 0) && (date.compareTo(to) < 0);
	}
	private static final int HOUR_FROM_DATE = 0;
	private static final int MINUTE_FROM_DATE = 0;
	private static final int SECOND_FROM_DATE = 0;
	private static final int HOUR_TO_DATE = 23;
	private static final int MINUTE_TO_DATE = 59;
	private static final int SECOND_TO_DATE = 59;
	private static final int DAY_OF_MONTH_FROM_DATE = 1;
	private static final int DAY_OF_MONTH_TO_DATE = 31;

	private void setFromTo(final Calendar calendar) {
		switch (step) {
			case STEP_DAY -> {
				this.from = new GregorianCalendar(
					calendar.get(Calendar.YEAR),
					calendar.get(Calendar.MONTH),
					calendar.get(Calendar.DAY_OF_MONTH),
					HOUR_FROM_DATE,
					MINUTE_FROM_DATE,
					SECOND_FROM_DATE).getTime();
				this.to = new GregorianCalendar(
					calendar.get(Calendar.YEAR),
					calendar.get(Calendar.MONTH),
					calendar.get(Calendar.DAY_OF_MONTH),
					HOUR_TO_DATE,
					MINUTE_TO_DATE,
					SECOND_TO_DATE).getTime();
			}
			case STEP_MONTH -> {
				YearMonth yearMonth = YearMonth.of(
					calendar.get(Calendar.YEAR),
					calendar.get(Calendar.MONTH) + 1
				);
				this.from = new GregorianCalendar(
					calendar.get(Calendar.YEAR),
					calendar.get(Calendar.MONTH),
					DAY_OF_MONTH_FROM_DATE,
					HOUR_FROM_DATE,
					MINUTE_FROM_DATE,
					SECOND_FROM_DATE).getTime();
				this.to = new GregorianCalendar(
					calendar.get(Calendar.YEAR),
					calendar.get(Calendar.MONTH),
					yearMonth.lengthOfMonth(),
					HOUR_TO_DATE,
					MINUTE_TO_DATE,
					SECOND_TO_DATE).getTime();
			}
			case STEP_YEAR -> {
				this.from = new GregorianCalendar(
					calendar.get(Calendar.YEAR),
					Calendar.JANUARY,
					DAY_OF_MONTH_FROM_DATE,
					HOUR_FROM_DATE,
					MINUTE_FROM_DATE,
					SECOND_FROM_DATE).getTime();
				this.to = new GregorianCalendar(
					calendar.get(Calendar.YEAR),
					Calendar.DECEMBER,
					DAY_OF_MONTH_TO_DATE,
					HOUR_TO_DATE,
					MINUTE_TO_DATE,
					SECOND_TO_DATE).getTime();
			}
			default -> { }
		}
	}

	private void offset(final int i) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(from);
		switch (step) {
			case STEP_DAY -> calendar.add(Calendar.DAY_OF_MONTH, i);
			case STEP_MONTH -> calendar.add(Calendar.MONTH, i);
			case STEP_YEAR -> calendar.add(Calendar.YEAR, i);
			default -> { }
		}
		setFromTo(calendar);
	}
}
