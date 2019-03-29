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

import com.objetivait.laboratory.serviceaddress.domain.EsgContry;
import com.objetivait.laboratory.serviceaddress.service.EsgContryService;
import com.objetivait.laboratory.serviceaddress.web.rest.errors.BADURISyntaxException;
import com.objetivait.laboratory.serviceaddress.web.rest.errors.ErrorConstants;
import com.objetivait.laboratory.serviceaddress.web.rest.utils.HeaderUtil;

import io.github.jhipster.web.util.ResponseUtil;

/**
 * REST controller for managing EsgContry.
 */
@RestController
@RequestMapping("/api")
public class EsgContryResource {

    private final Logger log = LoggerFactory.getLogger(EsgContryResource.class);

    private static final String ENTITY_NAME = "easyEsgManagerEsgContry";

    private final EsgContryService esgContryService;

    public EsgContryResource(EsgContryService esgContryService) {
        this.esgContryService = esgContryService;
    }

    /**
     * POST  /esg-contries : Create a new esgContry.
     *
     * @param esgContryDTO the esgContryDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new esgContryDTO, or with status 400 (Bad Request) if the esgContry has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/esg-contries")
    public ResponseEntity<EsgContry> createEsgContry(@Valid @RequestBody EsgContry esgContryDTO) throws URISyntaxException {
        log.debug("REST request to save EsgContry : {}", esgContryDTO);
        if (esgContryDTO.getId() != null) {
            throw new BADURISyntaxException("A new esgContry cannot already have an ID idexists", ErrorConstants.ENTITY_EXISTS_MSG);
        }
        EsgContry result = esgContryService.save(esgContryDTO);
        return ResponseEntity.created(new URI("/api/esg-contries/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /esg-contries : Updates an existing esgContry.
     *
     * @param esgContryDTO the esgContryDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated esgContryDTO,
     * or with status 400 (Bad Request) if the esgContryDTO is not valid,
     * or with status 500 (Internal Server Error) if the esgContryDTO couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/esg-contries")
    public ResponseEntity<EsgContry> updateEsgContry(@Valid @RequestBody EsgContry esgContryDTO) throws URISyntaxException {
        log.debug("REST request to update EsgContry : {}", esgContryDTO);
        if (esgContryDTO.getId() == null) {
            throw new BADURISyntaxException("Invalid id idnull", ErrorConstants.ERR_VALIDATION);
        }
        EsgContry result = esgContryService.save(esgContryDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, esgContryDTO.getId().toString()))
            .body(result);
    }

    /**
     * GET  /esg-contries : get all the esgContries.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of esgContries in body
     */
    @GetMapping("/esg-contries")
    public List<EsgContry> getAllEsgContries() {
        log.debug("REST request to get all EsgContries");
        return esgContryService.findAll();
    }

    /**
     * GET  /esg-contries/:id : get the "id" esgContry.
     *
     * @param id the id of the esgContryDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the esgContryDTO, or with status 404 (Not Found)
     */
    @GetMapping("/esg-contries/{id}")
    public ResponseEntity<EsgContry> getEsgContry(@PathVariable Long id) {
        log.debug("REST request to get EsgContry : {}", id);
        Optional<EsgContry> esgContryDTO = esgContryService.findOne(id);
        return ResponseUtil.wrapOrNotFound(esgContryDTO);
    }

    /**
     * DELETE  /esg-contries/:id : delete the "id" esgContry.
     *
     * @param id the id of the esgContryDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/esg-contries/{id}")
    public ResponseEntity<Void> deleteEsgContry(@PathVariable Long id) {
        log.debug("REST request to delete EsgContry : {}", id);
        esgContryService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}
