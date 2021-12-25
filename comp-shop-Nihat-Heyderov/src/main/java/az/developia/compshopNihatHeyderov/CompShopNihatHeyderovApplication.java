package az.developia.compshopNihatHeyderov;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import az.developia.compshopNihatHeyderov.file.StorageProperties;
import az.developia.compshopNihatHeyderov.file.StorageService;



@SpringBootApplication
@EnableConfigurationProperties(StorageProperties.class)
public class CompShopNihatHeyderovApplication {

	public static void main(String[] args) {
		SpringApplication.run(CompShopNihatHeyderovApplication.class, args);
	}
	
	@Bean
	CommandLineRunner init(StorageService storageService){
	return (args) ->{
	storageService.init();
	};
	}
}
