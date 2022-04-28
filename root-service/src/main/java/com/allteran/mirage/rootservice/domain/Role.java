package com.allteran.mirage.rootservice.domain;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    USER, MANAGER, ENGINEER, HEAD_ENGINEER, ADMIN;

    @Override
    public String getAuthority() {
        return name();
    }
}
