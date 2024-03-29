package com.proyecto.appauth.model.builder;

import com.proyecto.appauth.model.AccessPermits;
import com.proyecto.appauth.model.RoleType;
import com.proyecto.appauth.model.RouterLink;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AccessPermitsBuilder {
    private Integer id;
    private RouterLink routerLink;
    private RoleType roleType;

    private AccessPermitsBuilder toAccessPermitsBuilder() {
        return AccessPermitsBuilder.builder()
                .id(1)
                .routerLink(null)
                .roleType(null)
                .build();
    }

    public AccessPermits toAccessPermits() {
        AccessPermitsBuilder builder = toAccessPermitsBuilder();
        return new AccessPermits(
                builder.id,
                builder.routerLink,
                builder.roleType
        );
    }
}
