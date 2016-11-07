package hello;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GreetingController {

    @RequestMapping("/greeting")
    public String greeting(@RequestParam(value="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "greeting";
    }
    
    @RequestMapping("/web-portal")
    public String portal(HttpServletRequest request, HttpServletResponse httpServletResponse) {
    	StringBuffer requestURL = request.getRequestURL();
    	Enumeration headerNames = request.getHeaderNames();
    	while(headerNames.hasMoreElements()) {
    	  String headerName = (String)headerNames.nextElement();
    	  System.out.println("" + headerName);
    	  System.out.println("" + request.getHeader(headerName));
    	}
	    String queryString = request.getQueryString();
	    
	    System.out.println("requestURL::"+requestURL);
	    System.out.println("queryString::"+queryString);
        return "index";
    }

}
