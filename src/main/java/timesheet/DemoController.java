package timesheet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import timesheet.models.Admin;
import timesheet.models.AdminStore;
import timesheet.models.Employee;
import timesheet.models.EmployeeStore;
import timesheet.models.Supervisor;
import timesheet.models.SupervisorStore;
import timesheet.models.User;
import timesheet.models.UserStore;

@Controller
@SessionAttributes("User")
@ComponentScan("timesheet.models")
public class DemoController {

    @Autowired
    UserStore userStore;
    
    @Autowired
    EmployeeStore employeeStore;
    
    @Autowired
    SupervisorStore supervisorStore;
    
    
    @Autowired
    AdminStore adminStore;
    

    @RequestMapping("/")
    public String home(Model model) {
        return "home";
    }

    @RequestMapping("/content")
    public String content(Model model) {
        if (model.asMap().containsKey(("user"))) {
            return "content";
        } else {
            return "home";
        }
    }

    @PostMapping("/login")
    public String processLogin(@RequestParam(value = "username") String userName,
                               @RequestParam(value = "password") String password,
                               Model model) {
    	
    	String userId ="";
    	String userType = "";
    	try {
    		User user = userStore.findByUsername(userName);
    		
            
            if (user != null) {
            	userId = String.valueOf(user.getUser_id());
            	if(user instanceof Admin)
            		userType = "Admin";
            	else if (user instanceof Employee)
            		userType = "Employee";
            	else if (user instanceof Supervisor)
            		userType = "Supervisor";
            	
                model.addAttribute("message", user.getUsername() + ": welcome back !" + "\n You have logged in as "+userType);
                model.addAttribute("User", user);
                return "content";
            } else {
                model.addAttribute("message", "Username/password not found");
                return "login";
            }
    		
    	}
    	catch(Exception ex) {
    		return "user not found"+ex.getMessage();
    	}
        
    }

    @GetMapping("/login")
    public String showLogin() {
        return "login";
    }

    @PostMapping("/register")
    public String processRegister(@RequestParam(value = "fullname") String fullName,
                                  @RequestParam(value = "username") String userName,
                                  @RequestParam(value = "password") String password,
                                  @RequestParam(value = "type") String type,
                                  @RequestParam(value= "address") String address,
                                  @RequestParam(value="email") String email,
                                  @RequestParam(value="phoneno") long phone_no,
                                  @RequestParam(value="jobtitle") String job_title,
                                  @RequestParam(value="salary") int salary,
                                  @RequestParam(value="sSn") long sSN,
                                  @RequestParam(value="user_type") String user_type,
                                  Model model) {
        User user = userStore.findByUsername(userName);
        if (user != null) {
            model.addAttribute("message", "Username unavailable");
            return "register";
        } else {
        	if(user_type=="employee") {
        		 userStore.save(new Employee(userName, password,fullName, address, email, phone_no, job_title, salary, sSN));
                 model.addAttribute("message", "New Employee Added: " + userName);
                 
        	}
        	else {
        		userStore.save(new Admin(userName, password, fullName));
        	}
        	return "home";
        }
    }

    @GetMapping("/register")
    public String showRegister(Model model) {
        if (model.asMap().containsKey("User")) {
            return "register";
        } else {
        	
            model.addAttribute("message", "Please login first"+model.asMap());
            return "home";
        }
    }

    @RequestMapping("/logout")
    public String logout(Model model, SessionStatus sessionStatus) {
        sessionStatus.setComplete();
        model.addAttribute("message", "You have been logged out");
        model.addAttribute("User", null);
        return "home";
    }

}
