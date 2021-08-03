package learning.kubernetes;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@SpringBootApplication
@EnableScheduling
public class FluentdLogPocApplication {

	private final static Logger log = LoggerFactory.getLogger(FluentdLogPocApplication.class);
	

    @Autowired
    private ApplicationContext applicationContext;
	
	public static void main(String[] args) {
		SpringApplication.run(FluentdLogPocApplication.class, args);
	}

	
	@Scheduled(fixedRate=5000)
	public void log() {
		 log.info("This is \na multiline\n\n\nlog");
	}
	
	 @Scheduled(fixedRate = 10000)
	 public void logException() {
	        try {
	            applicationContext.getBean("test");
	        } catch (Exception e) {
	            throw new RuntimeException("Error happened", e);
	        }
	 }
	 
	 
}
