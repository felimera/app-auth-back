package com.proyecto.appauth.controller.mapper;

import com.proyecto.appauth.controller.dto.RouterLinkDto;
import com.proyecto.appauth.model.RouterLink;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-04-01T08:45:26-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.2 (Oracle Corporation)"
)
public class RouterLinkMapperImpl implements RouterLinkMapper {

    @Override
    public RouterLink toEntity(RouterLinkDto dto) {
        if ( dto == null ) {
            return null;
        }

        RouterLink routerLink = new RouterLink();

        routerLink.setLabel( dto.getEtiqueta() );
        routerLink.setIcon( dto.getIcono() );
        routerLink.setDescription( dto.getDescripcion() );
        routerLink.setId( dto.getId() );
        routerLink.setUrl( dto.getUrl() );

        return routerLink;
    }

    @Override
    public RouterLinkDto toDto(RouterLink entity) {
        if ( entity == null ) {
            return null;
        }

        RouterLinkDto routerLinkDto = new RouterLinkDto();

        routerLinkDto.setEtiqueta( entity.getLabel() );
        routerLinkDto.setIcono( entity.getIcon() );
        routerLinkDto.setDescripcion( entity.getDescription() );
        routerLinkDto.setId( entity.getId() );
        routerLinkDto.setUrl( entity.getUrl() );

        return routerLinkDto;
    }
}
