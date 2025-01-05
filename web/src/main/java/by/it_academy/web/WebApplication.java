package by.it_academy.web;

import by.it_academy.data.configuration.AuditConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@Import(AuditConfiguration.class)
@SpringBootApplication(scanBasePackages = {"by.it_academy.data", "by.it_academy.service", "by.it_academy.web"})
public class WebApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebApplication.class, args);
    }

}
