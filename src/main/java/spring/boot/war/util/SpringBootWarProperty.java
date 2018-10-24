package spring.boot.war.util;

import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

@Component
public class SpringBootWarProperty {
	
private static Logger logger = Logger.getLogger(SpringBootWarProperty.class);
	
	final String propertyPrefix = "SpringBootToWar.";
	
	Properties properties;
	
	SpringBootWarProperty() {
		setSpringBootWarProperty();
	}
	
	public void setSpringBootWarProperty() {
		try {
			InputStream  inputStream = SpringBootWarProperty.class.getResourceAsStream("/SpringBootToWar.properties");
			properties = new Properties();
			properties.load(inputStream);
		} catch (Exception e) {
			logger.error(e, e);
			//do nothing
		}
	}
	
	@SuppressWarnings({ "unchecked" })
	public <C extends Object> C getProperty(String property, Class<C> clazz) {
		C obj = (C) properties.get(propertyPrefix + property);
		if (obj == null) {
			obj = (C) properties.get(property);
		}
		return obj;
	}
	
	public String getProperty(String property) {
		return getProperty(property, String.class);
	}
	
	public Integer getPropertyAsInt(String property) {
		return getProperty(property, Integer.class);
	}
	
	public Properties getProperties() {
		return properties;
	}
	
	@Override
	public String toString() {
		return "SpringBootWarProperty [properties=" + properties + "]";
	}
}
