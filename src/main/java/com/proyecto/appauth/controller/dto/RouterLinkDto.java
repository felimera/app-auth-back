package com.proyecto.appauth.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RouterLinkDto {
    private Integer id;
    private String etiqueta;
    private String icono;
    private String url;
    private String descripcion;
}
