package persistence.library.entities;

public class Contact {
	private String email;
	private int phone;
	public Contact() {}
	public Contact(String email, int phone) {
		super();
		this.email = email;
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public int getPhone() {
		return phone;
	}
	@Override
	public String toString() {
		return "Contact [email=" + email + ", phone=" + phone + "]";
	}
	
}
