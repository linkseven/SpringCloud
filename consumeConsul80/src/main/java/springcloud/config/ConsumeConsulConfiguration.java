package springcloud.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ConsumeConsulConfiguration {
    @Bean
    //@LoadBalanced
    public RestTemplate getRest(){
        return new RestTemplate();
    }
}
