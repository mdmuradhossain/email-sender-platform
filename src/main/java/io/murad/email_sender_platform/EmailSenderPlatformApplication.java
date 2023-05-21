package io.murad.email_sender_platform;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("io.murad")
public class EmailSenderPlatformApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(EmailSenderPlatformApplication.class, args);
	}

}
