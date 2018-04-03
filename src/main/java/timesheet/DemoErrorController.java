package timesheet;

import org.springframework.boot.autoconfigure.web.ErrorAttributes;
import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
public class DemoErrorController implements ErrorController {

    private static final String PATH = "/error";
    private ErrorAttributes errorAttributes;
    public DemoErrorController(ErrorAttributes errorAttributes) {
        this.errorAttributes = errorAttributes;
    }
    @RequestMapping(value = PATH)
    public ModelAndView error(HttpServletRequest request) {
        RequestAttributes attrs = new ServletRequestAttributes(request);
        Map<String, Object> errMap = errorAttributes.getErrorAttributes(attrs, true);
        // errMap.forEach((k,v) -> System.out.println(k + ": " + v));
        return new ModelAndView("error", errMap);
    }

    @Override
    public String getErrorPath() {
        return PATH;
    }
}
