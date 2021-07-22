package psa.hours;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collection;
import java.util.Optional;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@Api(tags = "Hours Controller", description = "PSA Hours API")
@EnableAutoConfiguration
@SpringBootApplication
@RestController
@EnableSwagger2
public class HoursApplication {

    @Autowired
    private HourService hourService;

    public static void main(String[] args) {
        SpringApplication.run(HoursApplication.class, args);
    }

    @PostMapping("/hour")
    @ResponseStatus(HttpStatus.CREATED)
    public Hours createHours(@RequestBody Hours hour){
        return hourService.createHours(hour);
    }

    @GetMapping("/hour")
    public Collection<Hours> getHours(){
        return hourService.getHours();
    }

    @PutMapping("/hour/{id}")
    public ResponseEntity<Hours> updateHours(@RequestBody Hours hour, @PathVariable Long id){

        Optional<Hours> optionalHours = hourService.findHoursById(id);
        if(!optionalHours.isPresent()){
            return ResponseEntity.notFound().build();
        }

        hour.setId(id);
        hourService.createHours(hour);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/hour/{id}")
    public void deleteHour(@PathVariable Long id){
        hourService.deleteById(id);
    }

    @Bean
    public Docket apiDocket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("psa.hours"))
                .paths(PathSelectors.any())
                .build();
    }



}
