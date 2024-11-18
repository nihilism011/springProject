package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public BCryptPasswordEncoder bcrypt(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(authorizeRequests ->
                        authorizeRequests
                                .requestMatchers("/").permitAll()
                                .requestMatchers("/user/**").permitAll()
                                .requestMatchers("/admin/**").permitAll()
                                .anyRequest().authenticated()
                )
                .formLogin(formLoginConfig ->
                        formLoginConfig
                                .loginPage("/login")// 커스텀 로그인 페이지 경로
                                .loginProcessingUrl("/login")
                                .defaultSuccessUrl("/user/board")
                                .permitAll()  // 누구나 접근 가능
                )
                .logout(logoutConfig ->
                        logoutConfig
                                .logoutUrl("/logout")  // 커스텀 로그아웃 경로
                                .logoutSuccessUrl("/login?logout")  // 로그아웃 후 리디렉션할 URL
                                .permitAll()  // 누구나 로그아웃 경로에 접근 가능
                );
        return http.build();
    }
}
