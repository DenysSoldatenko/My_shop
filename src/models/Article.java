package models;

import exceptions.ModelException;
import java.util.Objects;

public final class Article extends Common {
	private String title;

	public Article(final String newTitle) throws ModelException {
		if (newTitle.length() == 0) {
			throw new ModelException(ModelException.TITLE_EMPTY);
		}
		this.title = newTitle;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(final String newTitle) {
		this.title = newTitle;
	}

	@Override
	public String toString() {
		return "Article{" + "title=" + title + '}';
	}

	@Override
	public boolean equals(final Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Article article = (Article) o;
		return Objects.equals(title, article.title);
	}

	@Override
	public int hashCode() {
		return Objects.hash(title);
	}

	@Override
	public String getValueFromComboBox() {
		return title;
	}
}
