package medicare;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import medicare.models.Admin;
import medicare.services.AdminService;

@SpringBootApplication
public class DiagnosticMedicareCenterApplication {
	
	private static final Logger log = LoggerFactory.getLogger(DiagnosticMedicareCenterApplication.class);
	//logger helps to trace out errors easily
	public static void main(String[] args) {
		SpringApplication.run(DiagnosticMedicareCenterApplication.class, args);//running the spring boot application
	}

	@Bean
	public CommandLineRunner demo(AdminService srv) {
	    return (args) -> {
	    	if(srv.countUser()==0) {
	    		Admin user=new Admin("admin","admin");
	    		srv.saveAdmin(user);//sending the model object to the service
	    		log.info("Admin user created successfully");
	    	}else {
	    		log.info("Admin user already created");
	    	}
	    };
	}
}
