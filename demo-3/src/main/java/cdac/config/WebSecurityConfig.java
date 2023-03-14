/*
 * package cdac.config;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.context.annotation.Bean; import
 * org.springframework.security.authentication.dao.DaoAuthenticationProvider;
 * import
 * org.springframework.security.config.annotation.authentication.builders.
 * AuthenticationManagerBuilder; import
 * org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder; import
 * org.springframework.security.crypto.password.PasswordEncoder;
 * 
 * import cdac.service.UserService;
 * 
 * public class WebSecurityConfig {
 * 
 * @Autowired private UserService userService;
 * 
 * @Bean public BCryptPasswordEncoder passwordEncoder() { return new
 * BCryptPasswordEncoder(); }
 * 
 * @Bean public PasswordEncoder getPasswordEncoder() { return new
 * BCryptPasswordEncoder(11); }
 * 
 * public DaoAuthenticationProvider authenticationProvider() {
 * DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
 * auth.setUserDetailsService(userService);
 * auth.setPasswordEncoder(getPasswordEncoder()); return auth; } protected void
 * configure(AuthenticationManagerBuilder auth) throws Exception {
 * auth.authenticationProvider(authenticationProvider()); } }
 */