package com.example.MarketAnalizeSite.models.users;

import org.springframework.security.core.GrantedAuthority;

public enum Roles implements GrantedAuthority {
    ROLE_USER,
    ROLE_ADMIN,
    ROLE_SUPERADMIN;

    @Override
    public String getAuthority() {
        return name();
    }
}
