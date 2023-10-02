package villar.financial.financialcontrol;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
@OpenAPIDefinition
public class FinancialControlApplication {

    public static void main(String[] args) {
        SpringApplication.run(FinancialControlApplication.class, args);
    }

}
