package com.bottlekill.pilotauthentication;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

@SpringBootApplication
@Slf4j
public class PilotAuthenticationApplication {


    private static void loadEnv() {
        try (BufferedReader reader = new BufferedReader(new FileReader(".env"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("=", 2);
                if (parts.length == 2) {
                    System.setProperty(parts[0], parts[1]);
                }
            }
            log.info("환경 변수 로딩 성공");
        } catch (IOException e) {
            log.error("환경 변수 로딩 중 오류 발생: " + e.getMessage(), e);
        }
    }



    public static void main(String[] args) {
        // 환경 변수 로딩
        loadEnv();

        SpringApplication.run(PilotAuthenticationApplication.class, args);
    }





}
