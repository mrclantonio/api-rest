package com.objetivait.laboratory.serviceaddress.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.objetivait.laboratory.serviceaddress.domain.EsgUF;


/**
 * Spring Data  repository for the EsgUF entity.
 */
@SuppressWarnings("unused")
@Repository
public interface EsgUFRepository extends JpaRepository<EsgUF, Long> {

}
