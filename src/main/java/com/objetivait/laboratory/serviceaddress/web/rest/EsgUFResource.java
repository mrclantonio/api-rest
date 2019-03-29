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

import com.objetivait.laboratory.serviceaddress.domain.EsgUF;
import com.objetivait.laboratory.serviceaddress.service.EsgUFService;
import com.objetivait.laboratory.serviceaddress.web.rest.errors.BADURISyntaxException;
import com.objetivait.laboratory.serviceaddress.web.rest.errors.ErrorConstants;
import com.objetivait.laboratory.serviceaddress.web.rest.utils.HeaderUtil;

import io.github.jhipster.web.util.ResponseUtil;

/**
 * REST controller for managing EsgUF.
 */
@RestController
@RequestMapping("/api")
public class EsgUFResource {

    private final Logger log = LoggerFactory.getLogger(EsgUFResource.class);

    private static final String ENTITY_NAME = "easyEsgManagerEsgUf";

    private final EsgUFService esgUFService;

    public EsgUFResource(EsgUFService esgUFService) {
        this.esgUFService = esgUFService;
    }

    /**
     * POST  /esg-ufs : Create a new esgUF.
     *
     * @param esgUFDTO the esgUFDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new esgUFDTO, or with status 400 (Bad Request) if the esgUF has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/esg-ufs")
    public ResponseEntity<EsgUF> createEsgUF(@Valid @RequestBody EsgUF esgUFDTO) throws URISyntaxException {
        log.debug("REST request to save EsgUF : {}", esgUFDTO);
        if (esgUFDTO.getId() != null) {
            throw new BADURISyntaxException("A new esgUF cannot already have an ID idexists", ErrorConstants.ENTITY_EXISTS_MSG);
        }
        EsgUF result = esgUFService.save(esgUFDTO);
        return ResponseEntity.created(new URI("/api/esg-ufs/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /esg-ufs : Updates an existing esgUF.
     *
     * @param esgUFDTO the esgUFDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated esgUFDTO,
     * or with status 400 (Bad Request) if the esgUFDTO is not valid,
     * or with status 500 (Internal Server Error) if the esgUFDTO couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/esg-ufs")
    public ResponseEntity<EsgUF> updateEsgUF(@Valid @RequestBody EsgUF esgUFDTO) throws URISyntaxException {
        log.debug("REST request to update EsgUF : {}", esgUFDTO);
        if (esgUFDTO.getId() == null) {
            throw new BADURISyntaxException("Invalid id idnull", ErrorConstants.ERR_VALIDATION);
        }
        EsgUF result = esgUFService.save(esgUFDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, esgUFDTO.getId().toString()))
            .body(result);
    }

    /**
     * GET  /esg-ufs : get all the esgUFS.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of esgUFS in body
     */
    @GetMapping("/esg-ufs")
    public List<EsgUF> getAllEsgUFS() {
        log.debug("REST request to get all EsgUFS");
        return esgUFService.findAll();
    }

    /**
     * GET  /esg-ufs/:id : get the "id" esgUF.
     *
     * @param id the id of the esgUFDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the esgUFDTO, or with status 404 (Not Found)
     */
    @GetMapping("/esg-ufs/{id}")
    public ResponseEntity<EsgUF> getEsgUF(@PathVariable Long id) {
        log.debug("REST request to get EsgUF : {}", id);
        Optional<EsgUF> esgUFDTO = esgUFService.findOne(id);
        return ResponseUtil.wrapOrNotFound(esgUFDTO);
    }

    /**
     * DELETE  /esg-ufs/:id : delete the "id" esgUF.
     *
     * @param id the id of the esgUFDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/esg-ufs/{id}")
    public ResponseEntity<Void> deleteEsgUF(@PathVariable Long id) {
        log.debug("REST request to delete EsgUF : {}", id);
        esgUFService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}
