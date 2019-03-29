package com.objetivait.laboratory.serviceaddress.service;

import java.util.List;
import java.util.Optional;

import com.objetivait.laboratory.serviceaddress.domain.EsgCity;
import com.objetivait.laboratory.serviceaddress.service.dto.EsgCityDTO;

/**
 * Service Interface for managing EsgCity.
 */
public interface EsgCityService {

    /**
     * Save a esgCity.
     *
     * @param esgCityDTO the entity to save
     * @return the persisted entity
     */
    EsgCity save(EsgCityDTO esgCityDTO);

    /**
     * Get all the esgCities.
     *
     * @return the list of entities
     */
    List<EsgCity> findAll();


    /**
     * Get the "id" esgCity.
     *
     * @param id the id of the entity
     * @return the entity
     */
    Optional<EsgCity> findOne(Long id);

    /**
     * Delete the "id" esgCity.
     *
     * @param id the id of the entity
     */
    void delete(Long id);
}
