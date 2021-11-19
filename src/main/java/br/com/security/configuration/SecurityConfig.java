package br.com.security.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	
	//Autenticação em Memória
	
	  @Override
	  protected void configure(HttpSecurity http) throws Exception{
		  http.csrf().disable().authorizeRequests() //csrf, protocolo de seguraça
		  .antMatchers(HttpMethod.GET, "/").permitAll()
		  .anyRequest().authenticated() .and().formLogin().permitAll()
		  .and().logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout")); //Desconecta usuario
	  }
	 

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("Caio").password("123").roles("USER"); // Caio como Usuario

	}
	
	  @Override public void configure(WebSecurity web) throws Exception{
		  web.ignoring().antMatchers("/materialize/**", "/style/**"); //O Spring  Security vai ignorar páginas staticas como css 
	  }
	 
}
