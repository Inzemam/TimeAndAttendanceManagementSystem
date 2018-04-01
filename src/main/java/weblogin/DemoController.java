package weblogin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@SessionAttributes("user")
public class DemoController {

    @Autowired
    UserStore userStore;

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
        User user = userStore.findByUsername(userName);
        if (user != null) {
            model.addAttribute("message", user.fullname + ": welcome back !");
            model.addAttribute("user", user);
            return "content";
        } else {
            model.addAttribute("message", "Username/password not found");
            return "login";
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
                                  Model model) {
        User user = userStore.findByUsername(userName);
        if (user != null) {
            model.addAttribute("message", "Username unavailable");
            return "register";
        } else {
            userStore.save(new User(fullName, userName, password));
            model.addAttribute("message", "New user registered: " + userName);
            return "home";
        }
    }

    @GetMapping("/register")
    public String showRegister(Model model) {
        if (model.asMap().containsKey("user")) {
            return "register";
        } else {
            model.addAttribute("message", "Please login first");
            return "index";
        }
    }

    @RequestMapping("/logout")
    public String logout(Model model, SessionStatus sessionStatus) {
        sessionStatus.setComplete();
        model.addAttribute("message", "You have been logged out");
        model.addAttribute("user", null);
        return "home";
    }

}
