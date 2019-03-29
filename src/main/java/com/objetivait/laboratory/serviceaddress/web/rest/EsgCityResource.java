package com.objetivait.laboratory.serviceaddress.web.rest;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.objetivait.laboratory.serviceaddress.domain.EsgCity;
import com.objetivait.laboratory.serviceaddress.service.EsgCityQueryService;
import com.objetivait.laboratory.serviceaddress.service.EsgCityService;
import com.objetivait.laboratory.serviceaddress.service.dto.EsgCityCriteria;
import com.objetivait.laboratory.serviceaddress.service.dto.EsgCityDTO;
import com.objetivait.laboratory.serviceaddress.web.rest.errors.BADURISyntaxException;
import com.objetivait.laboratory.serviceaddress.web.rest.errors.ErrorConstants;
import com.objetivait.laboratory.serviceaddress.web.rest.utils.HeaderUtil;

import io.github.jhipster.web.util.ResponseUtil;

/**
 * REST controller for managing EsgCity.
 */
@RestController
@RequestMapping("/api")
public class EsgCityResource {

    private final Logger log = LoggerFactory.getLogger(EsgCityResource.class);

    private static final String ENTITY_NAME = "easyEsgManagerEsgCity";

    private final EsgCityService esgCityService;

    private final EsgCityQueryService esgCityQueryService;

    public EsgCityResource(EsgCityService esgCityService, EsgCityQueryService esgCityQueryService) {
        this.esgCityService = esgCityService;
        this.esgCityQueryService = esgCityQueryService;
    }

    /**
     * POST  /esg-cities : Create a new esgCity.
     *
     * @param esgCityDTO the esgCityDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new esgCityDTO, or with status 400 (Bad Request) if the esgCity has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/esg-cities")
    public ResponseEntity<EsgCity> createEsgCity(@Valid @RequestBody EsgCityDTO esgCityDTO) throws URISyntaxException {
        log.debug("REST request to save EsgCity : {}", esgCityDTO);
        if (esgCityDTO.getId() != null) {
            throw new BADURISyntaxException("A new esgCity cannot already have an ID idexists", ErrorConstants.ENTITY_EXISTS_MSG);
        }
        EsgCity result = esgCityService.save(esgCityDTO);
        return ResponseEntity.created(new URI("/api/esg-cities/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /esg-cities : Updates an existing esgCity.
     *
     * @param esgCityDTO the esgCityDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated esgCityDTO,
     * or with status 400 (Bad Request) if the esgCityDTO is not valid,
     * or with status 500 (Internal Server Error) if the esgCityDTO couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/esg-cities")
    public ResponseEntity<EsgCity> updateEsgCity(@Valid @RequestBody EsgCityDTO esgCityDTO) throws URISyntaxException {
        log.debug("REST request to update EsgCity : {}", esgCityDTO);
        if (esgCityDTO.getId() == null) {
            throw new BADURISyntaxException("Invalid id idnull", ErrorConstants.ERR_VALIDATION);
        }
        EsgCity result = esgCityService.save(esgCityDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, esgCityDTO.getId().toString()))
            .body(result);
    }

    /**
     * GET  /esg-cities : get all the esgCities.
     *
     * @param criteria the criterias which the requested entities should match
     * @return the ResponseEntity with status 200 (OK) and the list of esgCities in body
     */
    @GetMapping("/esg-cities")
    public ResponseEntity<List<EsgCityDTO>> getAllEsgCities(EsgCityCriteria criteria) {
        log.debug("REST request to get EsgCities by criteria: {}", criteria);
        List<EsgCityDTO> entityList = esgCityQueryService.findByCriteria(criteria);
        return ResponseEntity.ok().body(entityList);
    }

    /**
    * GET  /esg-cities/count : count all the esgCities.
    *
    * @param criteria the criterias which the requested entities should match
    * @return the ResponseEntity with status 200 (OK) and the count in body
    */
    @GetMapping("/esg-cities/count")
    public ResponseEntity<Long> countEsgCities(EsgCityCriteria criteria) {
        log.debug("REST request to count EsgCities by criteria: {}", criteria);
        return ResponseEntity.ok().body(esgCityQueryService.countByCriteria(criteria));
    }

    /**
     * GET  /esg-cities/:id : get the "id" esgCity.
     *
     * @param id the id of the esgCityDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the esgCityDTO, or with status 404 (Not Found)
     */
    @GetMapping("/esg-cities/{id}")
    public ResponseEntity<EsgCity> getEsgCity(@PathVariable Long id) {
        log.debug("REST request to get EsgCity : {}", id);
        Optional<EsgCity> esgCityDTO = esgCityService.findOne(id);
        return ResponseUtil.wrapOrNotFound(esgCityDTO);
    }

    /**
     * DELETE  /esg-cities/:id : delete the "id" esgCity.
     *
     * @param id the id of the esgCityDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/esg-cities/{id}")
    public ResponseEntity<Void> deleteEsgCity(@PathVariable Long id) {
        log.debug("REST request to delete EsgCity : {}", id);
        esgCityService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}
