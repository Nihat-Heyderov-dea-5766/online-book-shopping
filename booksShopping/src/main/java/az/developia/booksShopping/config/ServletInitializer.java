package az.developia.booksShopping.config;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import az.developia.booksShopping.BookshoppingApplication;

public class ServletInitializer extends SpringBootServletInitializer{
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application){
	return application.sources(BookshoppingApplication.class);
	}
}
