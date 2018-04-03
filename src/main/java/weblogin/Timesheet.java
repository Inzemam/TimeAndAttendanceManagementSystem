package weblogin;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="timesheet")
public class Timesheet {
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	int id;
	
	@OneToOne
	@JoinColumn(name="id")
	private Employee employee;
	@OneToOne
	@JoinColumn(name="id")
	private Project project;
	
	Date date;
	String from_time;
	String to_time;
	long hours;
	
	
	SimpleDateFormat format=new SimpleDateFormat("HH:mm");
	Date d1;
	Date d2;
	
	{
	try {
	
	d1=format.parse(from_time);
	d2=format.parse(to_time);	
	hours=((d2.getTime()-d1.getTime())/(60*60*1000))%24;
	}
	catch(Exception e){
		e.printStackTrace();
	}
	}
	public Timesheet(Employee employee, Project project, Date date, String from_time, String to_time,
			SimpleDateFormat format, Date d1, Date d2) {
		this.employee = employee;
		this.project = project;
		this.date = date;
		this.from_time = from_time;
		this.to_time = to_time;
		this.format = format;
		this.d1 = d1;
		this.d2 = d2;
	}

	public int getId() {
		return id;
	}

	public Employee getEmployee() {
		return employee;
	}

	public Project getProject() {
		return project;
	}

	public Date getDate() {
		return date;
	}

	public String getFrom_time() {
		return from_time;
	}

	public String getTo_time() {
		return to_time;
	}

	public SimpleDateFormat getFormat() {
		return format;
	}

	public long gethours() {
		return hours;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public void setFrom_time(String from_time) {
		this.from_time = from_time;
	}

	public void setTo_time(String to_time) {
		this.to_time = to_time;
	}

	public void setFormat(SimpleDateFormat format) {
		this.format = format;
	}

	public void sethours(long hours) {
		this.hours = hours;
	}

	@Override
	public String toString() {
		return "Timesheet [id=" + id + ", project=" + project + ", date=" + date + ", from_time=" + from_time
				+ ", to_time=" + to_time + ", format=" + format + ", Hours=" + hours + "]";
	}
	
	
	
	
	

}

