package com.baisi.security.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 配置类
 */
@Configuration
public class UserConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/user/**");
    }
//    //注入 UserDetailsService 对象
//    @Autowired
//    private UserDetailsService userService;
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(userService).passwordEncoder(password());
//    }


//    protected void configurer(HttpSecurity http) throws Exception {
//        http.authorizeHttpRequests()
//                .antMatchers("/css/**","/js/**","/img/**").permitAll()
//                .antMatchers("/**/*.jpg","/**/*.png").permitAll();
//    }

//    @Bean
//    PasswordEncoder password(){
//        return new BCryptPasswordEncoder();
//    }

}
