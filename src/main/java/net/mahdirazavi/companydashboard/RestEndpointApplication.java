package net.mahdirazavi.companydashboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = "net.mahdirazavi.companydashboard.entity")
@EnableJpaRepositories(basePackages = "net.mahdirazavi.companydashboard.repository")
public class RestEndpointApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(RestEndpointApplication.class, args);
    }

//    @Override
//    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
//        return super.configure(builder);
//    }
}

