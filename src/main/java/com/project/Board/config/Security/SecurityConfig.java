package com.project.Board.config.Security;

import jakarta.servlet.DispatcherType;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
public class SecurityConfig {

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeHttpRequests(request -> request
                        .dispatcherTypeMatchers(DispatcherType.FORWARD).permitAll()
                        .requestMatchers( "/assets/**", "/post/register", "/auth/**", "/post/index","/post/post","/post/view").permitAll()
                        .anyRequest().authenticated()
                )
                .formLogin(login -> login
                    .loginPage("/post/login")	            // [A] 커스텀 로그인 페이지 지정
                    .loginProcessingUrl("/auth/login-process")	// [B] submit 받을 url
                    .usernameParameter("userid")	        // [C] submit할 아이디
                    .passwordParameter("password")	            // [D] submit할 비밀번호
                    .defaultSuccessUrl("/post/index", true)
                    .permitAll()
                )
                .logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/post/login");
        return http.build();
    }
}