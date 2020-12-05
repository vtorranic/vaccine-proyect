package pe.gob.minsa.recursos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@SpringBootApplication
public class RecursosApplication {

	public static void main(String[] args) {
		SpringApplication.run(RecursosApplication.class, args);
	}
	
	
	public Docket apiDocket() {
		return new Docket(DocumentationType.SWAGGER_2).select().
				apis(RequestHandlerSelectors.basePackage("pe.gob.minsa.recursos.facade")).
				paths(PathSelectors.any()).build();
	}

}
