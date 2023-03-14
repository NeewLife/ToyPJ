package com.project.Board.config.Security;

import com.project.Board.security.ExService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


@EnableWebSecurity		//spring security 를 적용한다는 Annotation
@RequiredArgsConstructor
public class SecurityConfig {
    private final ExService exService;
    /**
     * 규칙 설정
     * @param http
     * @throws Exception
     */
    @Bean
    protected SecurityFilterChain filterChainSecurityConfig(HttpSecurity http) throws Exception {
        return http.authorizeRequests()
                .antMatchers("/userAccess").hasRole("USER")
                .antMatchers("/signUp").anonymous()
                .and()
                .formLogin()
                .and()
                .csrf().disable();		//로그인 창
    }

    /**
     * 로그인 인증 처리 메소드
     * @param auth
     * @throws Exception
     */
    @Bean
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        return auth.userDetailsService(exService).passwordEncoder(new BCryptPasswordEncoder());
    }
}