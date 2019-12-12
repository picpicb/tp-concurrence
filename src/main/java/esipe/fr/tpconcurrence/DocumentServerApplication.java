package esipe.fr.tpconcurrence;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class DocumentServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(DocumentServerApplication.class, args);
    }
//totot
}
