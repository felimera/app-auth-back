package com.proyecto.appauth.model.builder;

import com.proyecto.appauth.model.RouterLink;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RouterLinkBuilder {
    private Integer id;
    private String label;
    private String icon;
    private String url;
    private String description;

    private RouterLinkBuilder toRouterLinkBuilder() {
        return RouterLinkBuilder.builder()
                .id(1)
                .label("Dashboard")
                .icon("folder")
                .url("/dashboard")
                .description("Neque porro quisquam est qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit...")
                .build();
    }

    public RouterLink toRouterLink() {
        RouterLinkBuilder builder = toRouterLinkBuilder();
        return new RouterLink(
                builder.id,
                builder.label,
                builder.icon,
                builder.url,
                builder.description
        );
    }
}
