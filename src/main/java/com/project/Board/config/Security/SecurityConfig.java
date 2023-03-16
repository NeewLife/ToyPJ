package com.project.Board.config.Security;

import com.project.Board.security.ExService;
import jakarta.servlet.DispatcherType;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;


@Configuration
public class SecurityConfig {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeHttpRequests(request -> request
                        .dispatcherTypeMatchers(DispatcherType.FORWARD).permitAll()
                        .requestMatchers("/assets/**", "/post/register.do", "/auth/join").permitAll()
                        .anyRequest().authenticated()
                )
                .formLogin(login -> login
                    .loginPage("/post/login")	            // [A] 커스텀 로그인 페이지 지정
                    .loginProcessingUrl("/login-process")	// [B] submit 받을 url
                    .usernameParameter("userid")	        // [C] submit할 아이디
                    .passwordParameter("pw")	            // [D] submit할 비밀번호
                    .defaultSuccessUrl("/post/index.do", true)
                    .permitAll()
                )
                .logout(withDefaults());
        return http.build();
    }
}