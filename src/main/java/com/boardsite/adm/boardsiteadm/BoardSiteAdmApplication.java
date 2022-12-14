package com.boardsite.adm.boardsiteadm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class BoardSiteAdmApplication {

    public static void main(String[] args) {
        SpringApplication.run(BoardSiteAdmApplication.class, args);
    }

}
