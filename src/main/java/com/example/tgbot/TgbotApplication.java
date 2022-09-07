package com.example.tgbot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;


//По умолчанию планирование отключено.
// Перед добавлением любых запланированных заданий нам необходимо явно включить планирование
//нужно подрубить эту аннотацию
@EnableScheduling
@SpringBootApplication
public class TgbotApplication {

	public static void main(String[] args) {
		SpringApplication.run(TgbotApplication.class, args);
	}

}
