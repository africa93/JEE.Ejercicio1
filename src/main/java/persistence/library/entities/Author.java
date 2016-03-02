package persistence.library.entities;

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
	
	public Author() {
		super();
	}
	public Author(int id, String name, String surname, Contact contact) {
		super();
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.contact = contact;
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
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (surname == null) {
			if (other.surname != null)
				return false;
		} else if (!surname.equals(other.surname))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Author [id=" + id + ", name=" + name + ", surname=" + surname + ", contact=" + contact + "]";
	}
	
	
}
