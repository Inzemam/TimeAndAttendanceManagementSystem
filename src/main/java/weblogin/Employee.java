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
    String type;
    String fullname;
    String address;
    String email;
    long phone_no;
    String job_title;
    int salary;
    long SSN;
    
    
    
    public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getPhone_no() {
		return phone_no;
	}
	public void setPhone_no(long phone_no) {
		this.phone_no = phone_no;
	}
	public String getJob_title() {
		return job_title;
	}
	public void setJob_title(String job_title) {
		this.job_title = job_title;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public long getSSN() {
		return SSN;
	}
	public void setSSN(long sSN) {
		SSN = sSN;
	}
	public Employee(String username, String password, String type, String fullname, String address,
			String email, long phone_no, String job_title, int salary, long sSN) {
		//super();
		//this.id = id;
		this.username = username;
		this.password = password;
		this.type = type;
		this.fullname = fullname;
		this.address = address;
		this.email = email;
		this.phone_no = phone_no;
		this.job_title = job_title;
		this.salary = salary;
		SSN = sSN;
	}
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

    Employee() {}
   
    public String toString() {
        return fullname + "(" + username + ")";
    }
    public String getFullName() { return fullname;}
}
