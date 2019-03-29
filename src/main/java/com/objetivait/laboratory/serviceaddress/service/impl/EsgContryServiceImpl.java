package com.objetivait.laboratory.serviceaddress.service.impl;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.objetivait.laboratory.serviceaddress.domain.EsgContry;
import com.objetivait.laboratory.serviceaddress.repository.EsgContryRepository;
import com.objetivait.laboratory.serviceaddress.service.EsgContryService;
import com.objetivait.laboratory.serviceaddress.service.dto.EsgContryDTO;

/**
 * Service Implementation for managing EsgContry.
 */
@Service
@Transactional
public class EsgContryServiceImpl implements EsgContryService {

    private final Logger log = LoggerFactory.getLogger(EsgContryServiceImpl.class);

    private final EsgContryRepository esgContryRepository;


    public EsgContryServiceImpl(EsgContryRepository esgContryRepository) {
        this.esgContryRepository = esgContryRepository;
    }

    /**
     * Save a esgContry.
     *
     * @param esgContryDTO the entity to save
     * @return the persisted entity
     */
    @Override
    public EsgContry save(EsgContry esgContry) {
        log.debug("Request to save EsgContry : {}", esgContry);
        esgContry = esgContryRepository.save(esgContry);
        return esgContry;
    }

    /**
     * Get all the esgContries.
     *
     * @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public List<EsgContry> findAll() {
        log.debug("Request to get all EsgContries");
        return esgContryRepository.findAll().stream()
            .collect(Collectors.toCollection(LinkedList::new));
    }


    /**
     * Get one esgContry by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<EsgContry> findOne(Long id) {
        log.debug("Request to get EsgContry : {}", id);
        return esgContryRepository.findById(id);
    }

    /**
     * Delete the esgContry by id.
     *
     * @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete EsgContry : {}", id);
        esgContryRepository.deleteById(id);
    }
}
