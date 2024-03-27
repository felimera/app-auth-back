package com.proyecto.appauth.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "tbl_role_type")
public class RoleType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rt_id")
    private Integer id;
    @Column(name = "rt_name")
    private String name;
    @Column(name = "rt_acronym")
    private String acronym;
    @Column(name = "rt_description")
    private String description;
}
