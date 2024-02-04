package ForMZ.Server.global.config;

import ForMZ.Server.global.auth.jwt.handler.CustomAuthenticationFailureHandler;
import ForMZ.Server.global.auth.jwt.handler.CustomAuthenticationSuccessHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

//    public static String[] PERMIT_ALL_PATTERNS = {
//            "/api/**",
//            "/error" // 일반 에러화면을 볼 수 있도록 설정
//    };

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable)
                .headers((headers) -> headers.frameOptions(HeadersConfigurer.FrameOptionsConfig::disable))
                .authorizeHttpRequests(request ->
                        request.requestMatchers(
                                        new AntPathRequestMatcher("/"),
                                        new AntPathRequestMatcher("/css/**"),
                                        new AntPathRequestMatcher("/images/**"),
                                        new AntPathRequestMatcher("/js/**"),
                                        new AntPathRequestMatcher("/h2-console/**"),
                                        new AntPathRequestMatcher("/profile")
                                )
                                .permitAll()
                                .requestMatchers(new AntPathRequestMatcher("/api/v1/**")).hasRole("USER")// 권한 ENUM 추가예정~
                                .anyRequest().authenticated())
                .oauth2Login(oauth2Configure ->
                            oauth2Configure.loginPage("/login")
                                    .successHandler(successHandler()) // 로그인 성공 핸들러
                                    .failureHandler(failureHandler()) // 로그인 실패 핸들러
                                    .defaultSuccessUrl("/", true)
                );


        // JWT 인증 필터를 UsernamePasswordAuthenticationFilter 앞에 추가한다.
//        http.addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class)
//        .build();

        return http.getOrBuild();
    }

    @Bean
    public AuthenticationSuccessHandler successHandler() {
        return new CustomAuthenticationSuccessHandler();
    }

    @Bean
    public AuthenticationFailureHandler failureHandler(){
        return new CustomAuthenticationFailureHandler();
    }
}
