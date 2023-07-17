package com.dinger.onlinehousingshow;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.socket.config.annotation.EnableWebSocket;

@SpringBootApplication
@EnableWebSocket
public class OnlineHousingShowApplication {

    public static void main(String[] args) {
        SpringApplication.run(OnlineHousingShowApplication.class, args);
    }

}
