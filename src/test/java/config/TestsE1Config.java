package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import injection.e1e2e4.MessageServiceMock;

@Configuration
@ComponentScan(basePackages = "injection.e1e2e4")
public class TestsE1Config {
    @Bean
    public MessageServiceMock messageService() {
        return new MessageServiceMock();
    }
}
