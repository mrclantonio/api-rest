package com.objetivait.laboratory.serviceaddress.service.dto;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

import com.objetivait.laboratory.serviceaddress.domain.EsgCity;
import com.objetivait.laboratory.serviceaddress.domain.EsgUF;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(EsgCity.class)
public abstract class EsgCity_ {

	public static volatile SingularAttribute<EsgCity, Long> id;
	public static volatile SingularAttribute<EsgCity, String> cdCity;
	public static volatile SingularAttribute<EsgCity, String> nmCity;
	public static volatile SingularAttribute<EsgCity, EsgUF> esgUF;

}

