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
@Table(name = "tbl_router_link")
public class RouterLink {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rl_id")
    private Integer id;
    @Column(name = "rl_label")
    private String label;
    @Column(name = "rl_icon")
    private String icon;
    @Column(name = "rl_url")
    private String url;
    @Column(name = "rl_description")
    private String description;
}
