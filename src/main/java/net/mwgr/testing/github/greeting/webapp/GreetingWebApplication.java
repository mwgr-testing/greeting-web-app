package net.mwgr.testing.greeting.webapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import net.mwgr.testing.greeting.lib.Greeter;

@SpringBootApplication
public class GreetingWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(GreetingWebApplication.class, args);
	}

	@Bean
	public Greeter createGreeter() {
		return new Greeter();
	}

}
