package com.JavOpen.contest.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // 모든 엔드포인트 허용
                .allowedOrigins("http://testmynewbuket456.s3-website.ap-northeast-2.amazonaws.com/",
                        "https://dl0y1h8935ths.cloudfront.net",
                        "http://dl0y1h8935ths.cloudfront.net",
                        "http://10.101.134.118:3000") // React 개발 서버 URL
                .allowedMethods("*") // 모든 HTTP 메서드 허용
                .allowedHeaders("*") // 모든 헤더 허용
                .allowCredentials(true); // 쿠키 및 인증 정보 허용
    }
}