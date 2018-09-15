package aSpringBootStart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

/**
 * Created by drudg on 2017/5/18.
 */
@SpringBootApplication
@EntityScan(basePackages ={ "aASpringBootStart","bASpringBootStart"})
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
