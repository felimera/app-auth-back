package com.proyecto.appauth.model;

import jakarta.annotation.Generated;
import jakarta.persistence.metamodel.EntityType;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(RoleType.class)
@Generated("org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
public abstract class RoleType_ {

	
	/**
	 * @see com.proyecto.appauth.model.RoleType#acronym
	 **/
	public static volatile SingularAttribute<RoleType, String> acronym;
	
	/**
	 * @see com.proyecto.appauth.model.RoleType#name
	 **/
	public static volatile SingularAttribute<RoleType, String> name;
	
	/**
	 * @see com.proyecto.appauth.model.RoleType#description
	 **/
	public static volatile SingularAttribute<RoleType, String> description;
	
	/**
	 * @see com.proyecto.appauth.model.RoleType#id
	 **/
	public static volatile SingularAttribute<RoleType, Integer> id;
	
	/**
	 * @see com.proyecto.appauth.model.RoleType
	 **/
	public static volatile EntityType<RoleType> class_;

	public static final String ACRONYM = "acronym";
	public static final String NAME = "name";
	public static final String DESCRIPTION = "description";
	public static final String ID = "id";

}

