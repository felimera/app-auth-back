package com.proyecto.appauth.model;

import jakarta.annotation.Generated;
import jakarta.persistence.metamodel.EntityType;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(RouterLink.class)
@Generated("org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
public abstract class RouterLink_ {

	
	/**
	 * @see com.proyecto.appauth.model.RouterLink#icon
	 **/
	public static volatile SingularAttribute<RouterLink, String> icon;
	
	/**
	 * @see com.proyecto.appauth.model.RouterLink#description
	 **/
	public static volatile SingularAttribute<RouterLink, String> description;
	
	/**
	 * @see com.proyecto.appauth.model.RouterLink#id
	 **/
	public static volatile SingularAttribute<RouterLink, Integer> id;
	
	/**
	 * @see com.proyecto.appauth.model.RouterLink#label
	 **/
	public static volatile SingularAttribute<RouterLink, String> label;
	
	/**
	 * @see com.proyecto.appauth.model.RouterLink
	 **/
	public static volatile EntityType<RouterLink> class_;
	
	/**
	 * @see com.proyecto.appauth.model.RouterLink#url
	 **/
	public static volatile SingularAttribute<RouterLink, String> url;

	public static final String ICON = "icon";
	public static final String DESCRIPTION = "description";
	public static final String ID = "id";
	public static final String LABEL = "label";
	public static final String URL = "url";

}

