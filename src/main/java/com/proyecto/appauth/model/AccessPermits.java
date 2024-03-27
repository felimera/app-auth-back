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
@Table(name = "tbl_access_permits")
public class AccessPermits {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ap_id")
    private Integer id;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ap_router_link_id")
    private RouterLink routerLink;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ap_role_type_id")
    private RoleType roleType;
}
