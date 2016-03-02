package my.persistence.library.entities;

import javax.persistence.*;

@Entity
public class Author {
	@Id
	@GeneratedValue
	private int id;
	private String name;
	private String surname;
	@Embedded
	private Contact contact;
	@ManyToOne
	@JoinColumn
	private Style style;

	
	public Author() {
		super();
	}
	public Author(int id, String name, String surname, Contact contact, Style style) {
		super();
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.contact = contact;
		this.style = style;
	}
	
	public String getName() {
		return name;
	}
	public String getSurname() {
		return surname;
	}
	public Contact getContact(){
		return contact;
	}
	public Style getStyle(){
		return style;
	}
	@Override
	public String toString() {
		return "Author [id=" + id + ", name=" + name + ", surname=" + surname + ", contact=" + contact + ", style="
				+ style + "]";
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
		Author other = (Author) obj;
		if (contact == null) {
			if (other.contact != null)
				return false;
		} else if (!contact.equals(other.contact))
			return false;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (style == null) {
			if (other.style != null)
				return false;
		} else if (!style.equals(other.style))
			return false;
		if (surname == null) {
			if (other.surname != null)
				return false;
		} else if (!surname.equals(other.surname))
			return false;
		return true;
	}
	
	
	
}
