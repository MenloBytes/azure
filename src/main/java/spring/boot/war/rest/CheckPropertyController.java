package spring.boot.war.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import spring.boot.war.util.SpringBootWarProperty;

@Component
@Controller
@RequestMapping("/spring/check")
public class CheckPropertyController {
	
	@Autowired
	private SpringBootWarProperty bootWarProperty;
	
	@RequestMapping(produces = "application/json" ,
			method = RequestMethod.GET,
			value ="/config")
	public @ResponseBody String getConfig () {
		
		return bootWarProperty.toString();
	}
}
