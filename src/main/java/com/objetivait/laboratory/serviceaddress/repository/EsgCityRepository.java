package com.objetivait.laboratory.serviceaddress.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.objetivait.laboratory.serviceaddress.domain.EsgCity;


/**
 * Spring Data  repository for the EsgCity entity.
 */
@SuppressWarnings("unused")
@Repository
public interface EsgCityRepository extends JpaRepository<EsgCity, Long>, JpaSpecificationExecutor<EsgCity> {

}
