package com.proyecto.appauth.model.builder;

import com.proyecto.appauth.model.RoleType;
import com.proyecto.appauth.util.Constants;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RoleTypeBuilder {
    private Integer id;
    private String name;
    private String acronym;
    private String description;

    private RoleTypeBuilder toRoleTypeBuilder() {
        return RoleTypeBuilder.builder()
                .id(1)
                .name("Administrador")
                .acronym(Constants.A)
                .description("Neque porro quisquam est qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit...")
                .build();
    }

    public RoleType toRoleType() {
        RoleTypeBuilder builder = toRoleTypeBuilder();
        return new RoleType(
                builder.id,
                builder.name,
                builder.acronym,
                builder.description
        );
    }
}
