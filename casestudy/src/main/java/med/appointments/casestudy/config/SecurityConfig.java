package med.appointments.casestudy.config;




import lombok.extern.slf4j.Slf4j;
import med.appointments.casestudy.security.AuthenticationSuccessHandlerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Slf4j
@Configuration
@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true)
//@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
@EnableMethodSecurity(securedEnabled = true, prePostEnabled = true)

class SecurityConfig {


    @Autowired
    private AuthenticationSuccessHandlerImpl authenticationSuccessHandler;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        // boilerplate code to disable csrf and authorize requests
        http.csrf(csrf -> csrf.disable());
        //http.csrf().disable(); deprecated and marked for removal

        // this block of code determines which requests are authenticated
        //  http.authorizeHttpRequests()


        //any path listed here must have its own controller to handle those requests
        http.authorizeRequests()
                .requestMatchers(
                        new AntPathRequestMatcher("/doctor/schedule/**"),
                        new AntPathRequestMatcher("/admin/**"),
                        new AntPathRequestMatcher("/user/**")).authenticated()
                .anyRequest().permitAll();

        // this is telling us the URL for the login page and the URL to submit the login form
        http.formLogin(formLogin -> formLogin
                .successHandler(authenticationSuccessHandler)
                // this is the URL for the login page
                .loginPage("/auth/login")
                // this is the URL to submit the login form
                .loginProcessingUrl("/auth/loginSubmit"));

        // this is telling spring security to logout when we hit the /login/logout URL
        http.logout(formLogout -> formLogout
                .invalidateHttpSession(true)
                // this is the URL to submit the logout form
                .logoutUrl("/logout")
                // this is the URL to go to after logout
                .logoutSuccessUrl("/auth/login"));

        return http.build();
    }






    @Bean(name = "passwordEncoder")
    public PasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }




    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
        return authConfig.getAuthenticationManager();
    }


}

