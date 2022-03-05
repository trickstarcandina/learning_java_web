package tacos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	
	private Environment env;
	
	//@Value("${JAVA_PATH}")
	//private String myVariable;
	@Autowired
	HomeController(Environment env){
		this.env = env;
	}
	
	@GetMapping("/")
	public String home() {
		//System.out.println("==========> " + myVariable);
		System.out.println("+++++++++++ " + env.getProperty("JAVA_HOME"));
		return "home";
	}
}