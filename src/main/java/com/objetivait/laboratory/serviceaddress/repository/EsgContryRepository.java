package com.objetivait.laboratory.serviceaddress.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.objetivait.laboratory.serviceaddress.domain.EsgContry;


/**
 * Spring Data  repository for the EsgContry entity.
 */
@SuppressWarnings("unused")
@Repository
public interface EsgContryRepository extends JpaRepository<EsgContry, Long> {

}
