package com.objetivait.laboratory.serviceaddress.service.dto;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

import com.objetivait.laboratory.serviceaddress.domain.EsgContry;
import com.objetivait.laboratory.serviceaddress.domain.EsgUF;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(EsgUF.class)
public abstract class EsgUF_ {

	public static volatile SingularAttribute<EsgUF, String> nmUF;
	public static volatile SingularAttribute<EsgUF, Long> id;
	public static volatile SingularAttribute<EsgUF, String> cdUF;
	public static volatile SingularAttribute<EsgUF, String> acUF;
	public static volatile SingularAttribute<EsgUF, EsgContry> esgContry;

}

