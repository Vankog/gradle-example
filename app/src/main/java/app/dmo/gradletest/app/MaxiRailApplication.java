package app.dmo.gradletest.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "app.dmo.gradletest")
public class MaxiRailApplication {
    public static void main(final String... args) {
        SpringApplication.run(MaxiRailApplication.class);
    }
}
