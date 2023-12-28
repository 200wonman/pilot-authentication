package com.bottlekill.pilotauthentication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

@SpringBootApplication
public class PilotAuthenticationApplication {

    public class EnvironmentLoader {
        public static void loadEnv() throws IOException {
            List<String> lines = Files.readAllLines(Paths.get(".env"));
            for (String line : lines) {
                String[] parts = line.split("=", 2);
                if (parts.length == 2) {
                    System.setProperty(parts[0], parts[1]);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        EnvironmentLoader.loadEnv();
        SpringApplication.run(PilotAuthenticationApplication.class, args);

    }

}
