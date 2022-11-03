package com.boardsite.adm.boardsiteadm.domain.constant;

import lombok.Getter;

public enum Gender {
    M("MALE"),
    F("FEMALE");


    @Getter
    private final String description;

    Gender(String description) {
        this.description = description;
    }

}
