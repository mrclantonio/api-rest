package com.objetivait.laboratory.serviceaddress.service.impl;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.objetivait.laboratory.serviceaddress.domain.EsgCity;
import com.objetivait.laboratory.serviceaddress.domain.EsgUF;
import com.objetivait.laboratory.serviceaddress.repository.EsgCityRepository;
import com.objetivait.laboratory.serviceaddress.service.EsgCityService;
import com.objetivait.laboratory.serviceaddress.service.dto.EsgCityDTO;

/**
 * Service Implementation for managing EsgCity.
 */
@Service
@Transactional
public class EsgCityServiceImpl implements EsgCityService {

    private final Logger log = LoggerFactory.getLogger(EsgCityServiceImpl.class);

    private final EsgCityRepository esgCityRepository;

    public EsgCityServiceImpl(EsgCityRepository esgCityRepository) {
        this.esgCityRepository = esgCityRepository;
    }

    /**
     * Save a esgCity.
     *
     * @param esgCityDTO the entity to save
     * @return the persisted entity
     */
    @Override
    public EsgCity save(EsgCityDTO esgCityDTO) {
        log.debug("Request to save EsgCity : {}", esgCityDTO);
        EsgCity esgCity = new EsgCity();
        EsgUF esgUF = new EsgUF();
        esgCity.setEsgUF(esgUF);
        esgCity.setCdCity(esgCityDTO.getCdCity());
        esgCity.setNmCity(esgCityDTO.getNmCity());
        esgCity.getEsgUF().setId(esgCityDTO.getEsgUFId());
        esgCity = esgCityRepository.save(esgCity);
        return esgCity;
    }

    /**
     * Get all the esgCities.
     *
     * @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public List<EsgCity> findAll() {
        log.debug("Request to get all EsgCities");
        return esgCityRepository.findAll().stream()
            .collect(Collectors.toCollection(LinkedList::new));
    }


    /**
     * Get one esgCity by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<EsgCity> findOne(Long id) {
        log.debug("Request to get EsgCity : {}", id);
        return esgCityRepository.findById(id);
    }

    /**
     * Delete the esgCity by id.
     *
     * @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete EsgCity : {}", id);
        esgCityRepository.deleteById(id);
    }
}
