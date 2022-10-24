/**
 * 
 */
package ar.edu.unju.fi.clinica.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.fasterxml.classmate.TypeResolver;

import ar.edu.unju.fi.clinica.Entity.Doctor;
import ar.edu.unju.fi.clinica.Entity.MedicalPlan;
import ar.edu.unju.fi.clinica.Entity.Meeting;
import ar.edu.unju.fi.clinica.Entity.Office;
import ar.edu.unju.fi.clinica.Entity.Patient;
import ar.edu.unju.fi.clinica.Entity.Role;
import ar.edu.unju.fi.clinica.Entity.User;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.data.rest.configuration.SpringDataRestConfiguration;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * @author Diaz, Sebastián Darío
 *
 */
@Configuration
@Import(SpringDataRestConfiguration.class)
public class SwaggerConfig {

	@Autowired
	private TypeResolver typeResolver;
	
	@Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
        		.additionalModels(
        			     typeResolver.resolve(Doctor.class),
        			     typeResolver.resolve(MedicalPlan.class),
        			     typeResolver.resolve(Meeting.class),
        			     typeResolver.resolve(Office.class),
        			     typeResolver.resolve(Patient.class),
        			     typeResolver.resolve(Role.class),
        			     typeResolver.resolve(User.class)
        			 )
                .select()
                .apis(RequestHandlerSelectors.basePackage("ar.edu.unju.fi.clinica.Controller"))
                //.apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build()
                .useDefaultResponseMessages(false)
                .apiInfo(apiInfo());
    }
	
	private ApiInfo apiInfo() {
	    return new ApiInfoBuilder()
	            .title("Clínica REST API")
	            .description("Proyecto Clínica")
	            .version("1.0.0")
	            .license("Apache License Version 2.0")
	            .licenseUrl("https://www.apache.org/licenses/LICENSE-2.0")
	            .contact(new Contact("Diaz, Sebastián Darío", "https://contacto.com.ar", "sebastiandario.sdd@gmail.com"))
	            .build();
	}

}
