package net.mwgr.testing.github.greeting.webapp;

import java.io.Closeable;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import net.mwgr.testing.github.greeting.lib.Greeter;

@SpringBootApplication
public class GreetingWebApplication implements Closeable {

	private static ConfigurableApplicationContext application;

	public static void main(String[] args) {
		application = SpringApplication.run(GreetingWebApplication.class, args);
	}

	@Override
	public void close() {
		application.close();
	}

	@Bean
	public Greeter createGreeter() {
		return new Greeter();
	}

}
