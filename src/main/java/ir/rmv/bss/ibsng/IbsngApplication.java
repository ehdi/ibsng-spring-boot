package ir.rmv.bss.ibsng;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
@SpringBootApplication
@EnableConfigurationProperties
public class IbsngApplication {
    public static void main(String[] args) {
        SpringApplication.run(IbsngApplication.class, args);
    }
}
