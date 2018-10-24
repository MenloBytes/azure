package spring.boot.war.rest;

import java.util.Properties;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import spring.boot.war.util.SpringBootWarProperty;

@Component
@Controller
@RequestMapping("/spring/war/hello")
public class SampleRest {
	private static Logger LOGGER = Logger.getLogger(SampleRest.class);
	
	@Autowired
	private SpringBootWarProperty springBootWarProperty;
	
	@RequestMapping(produces = "text/plain" ,method = RequestMethod.GET)
	public @ResponseBody String sayHello () {
		return "Welcome to spring boot war " + springBootWarProperty.getProperty("sample_property");
	}
	
	@RequestMapping(produces = "application/json" ,
			method = RequestMethod.GET,
			value ="/config")
	public @ResponseBody Properties getConfig () {
		return springBootWarProperty.getProperties();
	}
	
	@RequestMapping(produces = "application/json" ,
			method = RequestMethod.GET,
			value ="/config/refresh")
	public @ResponseBody Properties refreshConfig () {
		springBootWarProperty.setSpringBootWarProperty();
		LOGGER.info("Refreshing properties done.");
		return springBootWarProperty.getProperties();
	}
}
