package com.proyecto.appauth.model;

import jakarta.annotation.Generated;
import jakarta.persistence.metamodel.EntityType;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(AccessPermits.class)
@Generated("org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
public abstract class AccessPermits_ {

	
	/**
	 * @see com.proyecto.appauth.model.AccessPermits#routerLink
	 **/
	public static volatile SingularAttribute<AccessPermits, RouterLink> routerLink;
	
	/**
	 * @see com.proyecto.appauth.model.AccessPermits#id
	 **/
	public static volatile SingularAttribute<AccessPermits, Integer> id;
	
	/**
	 * @see com.proyecto.appauth.model.AccessPermits#roleType
	 **/
	public static volatile SingularAttribute<AccessPermits, RoleType> roleType;
	
	/**
	 * @see com.proyecto.appauth.model.AccessPermits
	 **/
	public static volatile EntityType<AccessPermits> class_;

	public static final String ROUTER_LINK = "routerLink";
	public static final String ID = "id";
	public static final String ROLE_TYPE = "roleType";

}

