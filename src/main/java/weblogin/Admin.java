package weblogin;

import javax.persistence.Entity;

@Entity
public class Admin extends User{
	String fullname;

	public Admin(String username, String password, String fullname) {
		super(username, password);
		this.fullname = fullname;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	@Override
	public String toString() {
		return "Admin [fullname=" + fullname + "]";
	}
	
}
