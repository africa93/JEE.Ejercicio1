package my.persistence.library.entities;

import java.util.List;

import javax.persistence.*;

@Entity
public class Book {
	@Id
    @GeneratedValue
	private int id;
	private String isbn;
	private String title;
	
	@ManyToMany(fetch = FetchType.EAGER)
	private List<Author> authors;
	
	@ManyToMany(fetch = FetchType.EAGER)
	private List<Theme> themes;
	
	public Book() {}

	public Book(int id, String isbn, String title, List<Author> authors,List<Theme> themes) {
		this.id = id;
		this.isbn = isbn;
		this.title = title;
		this.authors = authors;
		this.themes = themes;
	}

	public int getId() {
		return id;
	}

	public String getIsbn() {
		return isbn;
	}

	public String getTitle() {
		return title;
	}
	
	public List<Author> getAuthors() {
		return authors;
	}

	public List<Theme> getThemes() {
		return themes;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", isbn=" + isbn + ", title=" + title + ", authors=" + authors + ", themes=" + themes
				+ "]";
	}

	@Override
	public int hashCode() {
		return id;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		if (authors == null) {
			if (other.authors != null)
				return false;
		} else if (!authors.equals(other.authors))
			return false;
		if (id != other.id)
			return false;
		if (isbn == null) {
			if (other.isbn != null)
				return false;
		} else if (!isbn.equals(other.isbn))
			return false;
		if (themes == null) {
			if (other.themes != null)
				return false;
		} else if (!themes.equals(other.themes))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

	
}
