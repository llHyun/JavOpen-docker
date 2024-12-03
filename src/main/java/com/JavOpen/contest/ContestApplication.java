package com.JavOpen.contest;

import java.lang.System;
import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ContestApplication {

	public static void main(String[] args) {
		// .env 파일 로드 (컨테이너 내 경로로 수정)
		Dotenv dotenv = Dotenv.configure().directory("/app").load();

		// .env에서 환경 변수 읽기
		String dbUrl = dotenv.get("DB_URL");
		String dbUsername = dotenv.get("DB_USERNAME");
		String dbPassword = dotenv.get("DB_PASSWORD");

		// 환경 변수들을 System 프로퍼티로 설정 (Spring에서 사용할 수 있도록)
		System.setProperty("DB_URL", dbUrl);
		System.setProperty("DB_USERNAME", dbUsername);
		System.setProperty("DB_PASSWORD", dbPassword);

		// Spring 애플리케이션 시작
		SpringApplication.run(ContestApplication.class, args);
	}

}
