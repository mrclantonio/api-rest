package com.objetivait.laboratory.serviceaddress.service;

import java.util.List;
import java.util.Optional;

import com.objetivait.laboratory.serviceaddress.domain.EsgContry;

/**
 * Service Interface for managing EsgContry.
 */
public interface EsgContryService {

    /**
     * Save a esgContry.
     *
     * @param EsgContry the entity to save
     * @return the persisted entity
     */
    EsgContry save(EsgContry EsgContry);

    /**
     * Get all the esgContries.
     *
     * @return the list of entities
     */
    List<EsgContry> findAll();


    /**
     * Get the "id" esgContry.
     *
     * @param id the id of the entity
     * @return the entity
     */
    Optional<EsgContry> findOne(Long id);

    /**
     * Delete the "id" esgContry.
     *
     * @param id the id of the entity
     */
    void delete(Long id);
}
