package ie.atu.pro_test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ProTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProTestApplication.class, args);
    }

}
