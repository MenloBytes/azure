package spring.boot.war;

import java.util.Properties;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;

public class ServletInitializer extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder springApplicationBuilder) {
		return springApplicationBuilder
                .sources(SpringBootWarApplication.class)
                .properties(getProperties());
	}

   static Properties getProperties() {
      Properties props = new Properties();
      props.put("logging.file", "${catalina.base}/logs/springwar.log");
      props.put("logging.level.*", "INFO");
      return props;
   }
}
