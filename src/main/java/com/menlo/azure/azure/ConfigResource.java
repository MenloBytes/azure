package com.menlo.azure.azure;

import java.util.Properties;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author viswa
 *
 */
@Controller
@RequestMapping("/config")
public class ConfigResource {
	
	@RequestMapping(produces = "application/json" ,
					method = RequestMethod.GET,
					value ="/config")
	public @ResponseBody Properties getConfig () throws Exception {
		Properties prop = new Properties();
		prop.put("azure", "user");
		return prop;
	}
	
}
