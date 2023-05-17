package com.example.sbb.user;

import lombok.Getter;

@Getter
public enum UserRole {
    ADMIN("ROLE_ADMIN"), USER("ROLE_USER");

    UserRole(String Value){
        this.value = value;
    }

    private String value;
}

