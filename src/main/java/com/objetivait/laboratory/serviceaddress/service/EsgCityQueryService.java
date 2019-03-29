package com.objetivait.laboratory.serviceaddress.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.objetivait.laboratory.serviceaddress.domain.EsgCity;
import com.objetivait.laboratory.serviceaddress.domain.EsgUF;
import com.objetivait.laboratory.serviceaddress.repository.EsgCityRepository;
import com.objetivait.laboratory.serviceaddress.service.dto.EsgCityCriteria;
import com.objetivait.laboratory.serviceaddress.service.dto.EsgCityDTO;
import com.objetivait.laboratory.serviceaddress.service.dto.EsgCity_;
import com.objetivait.laboratory.serviceaddress.service.dto.EsgUF_;

import io.github.jhipster.service.QueryService;

@Service
@Transactional(readOnly = true)
public class EsgCityQueryService extends QueryService<EsgCity> {

    private final Logger log = LoggerFactory.getLogger(EsgCityQueryService.class);

    private final EsgCityRepository esgCityRepository;


    public EsgCityQueryService(EsgCityRepository esgCityRepository) {
        this.esgCityRepository = esgCityRepository;
    }

    /**
     * Return a {@link List} of {@link EsgCityDTO} which matches the criteria from the database
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public List<EsgCityDTO> findByCriteria(EsgCityCriteria criteria) {
        log.debug("find by criteria : {}", criteria);
        final Specification<EsgCity> specification = createSpecification(criteria);
        
        List<EsgCity> listAll = esgCityRepository.findAll(specification);
        List<EsgCityDTO> returnList = new ArrayList<>();
        for (EsgCity esgCity : listAll) {
            EsgCityDTO dto = new EsgCityDTO();
            dto.setCdCity(esgCity.getCdCity());
            dto.setEsgUFId(esgCity.getEsgUF().getId());
            dto.setEsgUFNmUF(esgCity.getEsgUF().getNmUF());
        }
        return returnList;
    }

    /**
     * Return a {@link Page} of {@link EsgCityDTO} which matches the criteria from the database
     * @param criteria The object which holds all the filters, which the entities should match.
     * @param page The page, which should be returned.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public Page<EsgCity> findByCriteria(EsgCityCriteria criteria, Pageable page) {
        log.debug("find by criteria : {}, page: {}", criteria, page);
        final Specification<EsgCity> specification = createSpecification(criteria);
        return esgCityRepository.findAll(specification, page);
    }

    /**
     * Return the number of matching entities in the database
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the number of matching entities.
     */
    @Transactional(readOnly = true)
    public long countByCriteria(EsgCityCriteria criteria) {
        log.debug("count by criteria : {}", criteria);
        final Specification<EsgCity> specification = createSpecification(criteria);
        return esgCityRepository.count(specification);
    }

    /**
     * Function to convert EsgCityCriteria to a {@link Specification}
     */
    private Specification<EsgCity> createSpecification(EsgCityCriteria criteria) {
        Specification<EsgCity> specification = Specification.where(null);
//        Specification<EsgCity> specification = getSpecificationJoinEsgUF();
        if (criteria != null) {
            if (criteria.getId() != null) {
                specification = specification.and(buildSpecification(criteria.getId(), EsgCity_.id));
            }
            if (criteria.getNmCity() != null) {
                specification = specification.and(buildStringSpecification(criteria.getNmCity(), EsgCity_.nmCity));
            }
            if (criteria.getCdCity() != null) {
                specification = specification.and(buildStringSpecification(criteria.getCdCity(), EsgCity_.cdCity));
            }
            if (criteria.getEsgUFId() != null) {
                specification = specification.and(buildSpecification(criteria.getEsgUFId(),
                    root -> root.join(EsgCity_.esgUF, JoinType.LEFT).get(EsgUF_.id)) );
            }
        }
        return specification;
    }

    private Specification<EsgCity> getSpecificationJoinEsgUF() {
        Specification<EsgCity> specification = new Specification<EsgCity>() {
            private static final long serialVersionUID = 1L;

            @Override
            public Predicate toPredicate(Root<EsgCity> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                Join<EsgCity, EsgUF> ufJoin = root.join(EsgCity_.esgUF, JoinType.LEFT);
                return ufJoin.getOn();
            }
        };
        return specification;
    }
}
