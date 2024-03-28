package com.proyecto.appauth.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AccessPermitsDto {
    private Integer idRol;
    private String nombreRol;
    private String acronimoRol;
    private String descripcionRol;
    private List<RouterLinkDto> linkList;
}
