package weblogin;

import javax.persistence.*;

@Entity
@Table(name="Employee")
public class Employee {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    int id;

    String username;
    String password;
    //String type;
    
    
    
    public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	String fullname;
    Employee() {}
    Employee(String f, String u, String p) {
        fullname = f;
        username = u;
        password = p;
    }
    public String toString() {
        return fullname + "(" + username + ")";
    }
    public String getFullName() { return fullname;}
}
