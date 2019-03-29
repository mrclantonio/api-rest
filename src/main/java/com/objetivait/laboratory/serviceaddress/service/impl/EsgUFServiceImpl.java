package com.objetivait.laboratory.serviceaddress.service.impl;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.objetivait.laboratory.serviceaddress.domain.EsgUF;
import com.objetivait.laboratory.serviceaddress.repository.EsgUFRepository;
import com.objetivait.laboratory.serviceaddress.service.EsgUFService;

/**
 * Service Implementation for managing EsgUF.
 */
@Service
@Transactional
public class EsgUFServiceImpl implements EsgUFService {

    private final Logger log = LoggerFactory.getLogger(EsgUFServiceImpl.class);

    private final EsgUFRepository esgUFRepository;

    public EsgUFServiceImpl(EsgUFRepository esgUFRepository) {
        this.esgUFRepository = esgUFRepository;
    }

    /**
     * Save a esgUF.
     *
     * @param esgUFDTO the entity to save
     * @return the persisted entity
     */
    @Override
    public EsgUF save(EsgUF esgUF) {
        log.debug("Request to save EsgUF : {}", esgUF);
        esgUF = esgUFRepository.save(esgUF);
        return esgUF;
    }

    /**
     * Get all the esgUFS.
     *
     * @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public List<EsgUF> findAll() {
        log.debug("Request to get all EsgUFS");
        return esgUFRepository.findAll().stream()
            .collect(Collectors.toCollection(LinkedList::new));
    }


    /**
     * Get one esgUF by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<EsgUF> findOne(Long id) {
        log.debug("Request to get EsgUF : {}", id);
        return esgUFRepository.findById(id);
    }

    /**
     * Delete the esgUF by id.
     *
     * @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete EsgUF : {}", id);
        esgUFRepository.deleteById(id);
    }
}
