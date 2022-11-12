package az.orient.bankboot55client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class Bankboot55clientApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(Bankboot55clientApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {

        return application.sources(Bankboot55clientApplication.class);
    }

}
