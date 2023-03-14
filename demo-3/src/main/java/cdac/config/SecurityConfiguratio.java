/*
 * package cdac.config;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.context.annotation.Bean; import
 * org.springframework.context.annotation.ComponentScan; import
 * org.springframework.context.annotation.Configuration; import
 * org.springframework.security.authentication.dao.DaoAuthenticationProvider;
 * import
 * org.springframework.security.config.annotation.authentication.builders.
 * AuthenticationManagerBuilder; import
 * org.springframework.security.config.annotation.web.builders.HttpSecurity;
 * import org.springframework.security.config.annotation.web.configuration.
 * EnableWebSecurity; import
 * org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder; import
 * org.springframework.security.crypto.password.PasswordEncoder; import
 * org.springframework.security.web.SecurityFilterChain; import
 * org.springframework.security.web.util.matcher.AntPathRequestMatcher;
 * 
 * import cdac.service.UserService;
 * 
 * @ComponentScan
 * 
 * @Configuration
 * 
 * @EnableWebSecurity public class SecurityConfiguratio {
 * 
 * @Autowired private UserService userService;
 * 
 * 
 * 
 * 
 * 
 * protected void configure(HttpSecurity http) throws Exception {
 * http.authorizeHttpRequests().anyRequest().permitAll().anyRequest().
 * authenticated().and().formLogin()
 * .loginPage("/login").permitAll().and().logout().invalidateHttpSession(true).
 * clearAuthentication(true) .logoutRequestMatcher(new
 * AntPathRequestMatcher("/logout")).logoutSuccessUrl("/login?logout")
 * .permitAll(); }
 * 
 * 
 * @Bean public SecurityFilterChain filterChain(HttpSecurity http) throws
 * Exception { http.authorizeHttpRequests((authz) ->
 * authz.requestMatchers("/admin").hasRole("ADMIN").requestMatchers("/user")
 * .hasRole("USER").anyRequest().authenticated()).httpBasic(); return
 * http.build(); }
 * 
 * 
 * }
 */