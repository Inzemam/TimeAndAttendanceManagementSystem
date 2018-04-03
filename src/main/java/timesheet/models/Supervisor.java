package timesheet.models;

import javax.persistence.*;


@Entity
//@Table(name="supervisor")
@DiscriminatorValue("supervisor")
public class Supervisor extends User{

	String fullname;
	
	

	public Supervisor() {
		super();
	}

	public Supervisor(String username, String password, String fullname) {
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
		return "Supervisor [fullname=" + fullname + "]";
	}
		
}
