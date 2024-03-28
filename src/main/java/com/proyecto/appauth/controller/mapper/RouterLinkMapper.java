package com.proyecto.appauth.controller.mapper;

import com.proyecto.appauth.controller.dto.RouterLinkDto;
import com.proyecto.appauth.model.RouterLink;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RouterLinkMapper {
    RouterLinkMapper INSTANCE = Mappers.getMapper(RouterLinkMapper.class);

    @Mapping(target = "label", source = "etiqueta")
    @Mapping(target = "icon", source = "icono")
    @Mapping(target = "description", source = "descripcion")
    RouterLink toEntity(RouterLinkDto dto);

    @InheritInverseConfiguration
    RouterLinkDto toDto(RouterLink entity);
}
