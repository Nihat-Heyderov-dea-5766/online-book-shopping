package az.developia.compshopNihatHeyderov.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter{
@Override
protected void configure(HttpSecurity http) throws Exception {
	http.csrf().disable().authorizeRequests().
	antMatchers(HttpMethod.GET,"/").permitAll()
	.antMatchers(HttpMethod.GET,"/show-creataccount").permitAll()
	.antMatchers(HttpMethod.POST,"/new-creataccount-proccess").permitAll()
	.anyRequest().authenticated().and().formLogin()
	.loginPage("/show-login").loginProcessingUrl("/authenticate-user").permitAll().
	and().logout().permitAll();
	
}
@Autowired
DataSource datasource;
@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication().dataSource(datasource);
		
	}
}
