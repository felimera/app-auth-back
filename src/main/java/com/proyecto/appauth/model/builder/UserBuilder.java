package com.proyecto.appauth.model.builder;

import com.proyecto.appauth.model.RoleType;
import com.proyecto.appauth.model.auth.User;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserBuilder {
    private Integer id;
    private String fullName;
    private String email;
    private String password;
    private RoleType roleType;

    private UserBuilder toUserBuilder() {
        return UserBuilder.builder()
                .id(1)
                .fullName("username")
                .email("user@user.com")
                .password("password")
                .roleType(new RoleType())
                .build();
    }

    public User toUser() {
        UserBuilder builder = toUserBuilder();
        return new User(
                builder.id,
                builder.fullName,
                builder.email,
                builder.password,
                builder.roleType
        );
    }

    public User toEditEmail(String email) {
        UserBuilder builder = toUserBuilder();
        return new User(
                builder.id,
                builder.fullName,
                email,
                builder.password,
                builder.roleType
        );
    }
}
