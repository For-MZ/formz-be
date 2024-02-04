package ForMZ.Server.global.config;

import ForMZ.Server.global.auth.oauth2.service.CustomOAuth2UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.servlet.handler.HandlerMappingIntrospector;

import java.util.stream.Stream;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final CustomOAuth2UserService customOAuth2UserService;
    //private final MyAuthenticationSuccessHandler oAuth2LoginSuccessHandler;
    //private final MyAuthenticationFailureHandler oAuth2LoginFailureHandler;

    public static String[] PERMIT_ALL_PATTERNS = {
            "/admin/access-token",
            "/admin/login-info",
            "/admin/logout",
            "/test"
    };

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http, HandlerMappingIntrospector handlerMappingIntrospector) throws Exception {
        //.and()
        //.failureHandler(oAuth2LoginFailureHandler) // OAuth2 로그인 실패시 처리할 핸들러를 지정해준다.
        //.successHandler(oAuth2LoginSuccessHandler); // OAuth2 로그인 성공시 처리할 핸들러를 지정해준다.


        // JWT 인증 필터를 UsernamePasswordAuthenticationFilter 앞에 추가한다.
        return http
                .authorizeHttpRequests(request ->
                        request
                                .requestMatchers( // <== 여기
                                        Stream
                                                .of(PERMIT_ALL_PATTERNS)
                                                .map(AntPathRequestMatcher::antMatcher)
                                                .toArray(AntPathRequestMatcher[]::new)
                                )
                                .permitAll()
                                .requestMatchers(AntPathRequestMatcher.antMatcher("/api/**"))
                                .authenticated()
                ).
        build();
    }
}
