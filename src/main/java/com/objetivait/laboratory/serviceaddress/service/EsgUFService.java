package com.objetivait.laboratory.serviceaddress.service;

import java.util.List;
import java.util.Optional;

import com.objetivait.laboratory.serviceaddress.domain.EsgUF;

/**
 * Service Interface for managing EsgUF.
 */
public interface EsgUFService {

    /**
     * Save a esgUF.
     *
     * @param esgUFDTO the entity to save
     * @return the persisted entity
     */
    EsgUF save(EsgUF esgUFDTO);

    /**
     * Get all the esgUFS.
     *
     * @return the list of entities
     */
    List<EsgUF> findAll();


    /**
     * Get the "id" esgUF.
     *
     * @param id the id of the entity
     * @return the entity
     */
    Optional<EsgUF> findOne(Long id);

    /**
     * Delete the "id" esgUF.
     *
     * @param id the id of the entity
     */
    void delete(Long id);
}
