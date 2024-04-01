package com.proyecto.appauth.model.auth;

import com.proyecto.appauth.model.RoleType;
import jakarta.annotation.Generated;
import jakarta.persistence.metamodel.EntityType;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(User.class)
@Generated("org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
public abstract class User_ {

	
	/**
	 * @see com.proyecto.appauth.model.auth.User#password
	 **/
	public static volatile SingularAttribute<User, String> password;
	
	/**
	 * @see com.proyecto.appauth.model.auth.User#fullName
	 **/
	public static volatile SingularAttribute<User, String> fullName;
	
	/**
	 * @see com.proyecto.appauth.model.auth.User#id
	 **/
	public static volatile SingularAttribute<User, Integer> id;
	
	/**
	 * @see com.proyecto.appauth.model.auth.User#roleType
	 **/
	public static volatile SingularAttribute<User, RoleType> roleType;
	
	/**
	 * @see com.proyecto.appauth.model.auth.User
	 **/
	public static volatile EntityType<User> class_;
	
	/**
	 * @see com.proyecto.appauth.model.auth.User#email
	 **/
	public static volatile SingularAttribute<User, String> email;

	public static final String PASSWORD = "password";
	public static final String FULL_NAME = "fullName";
	public static final String ID = "id";
	public static final String ROLE_TYPE = "roleType";
	public static final String EMAIL = "email";

}

