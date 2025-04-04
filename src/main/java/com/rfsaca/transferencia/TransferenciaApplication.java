package com.rfsaca.transferencia;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class TransferenciaApplication {

	public static void main(String[] args) {
		SpringApplication.run(TransferenciaApplication.class, args);
	}

}
