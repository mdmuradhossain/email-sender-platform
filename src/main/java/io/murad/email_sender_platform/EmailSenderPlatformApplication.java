package io.murad.email_sender_platform;

import io.murad.email_sender_platform.utils.ReadFromFile;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

import java.io.IOException;

@SpringBootApplication
@ComponentScan("io.murad")
public class EmailSenderPlatformApplication extends SpringBootServletInitializer {

	public static void main(String[] args) throws IOException {
		SpringApplication.run(EmailSenderPlatformApplication.class, args);
	}

}
