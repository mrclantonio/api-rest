package com.objetivait.laboratory.serviceaddress.domain;


import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import io.swagger.annotations.ApiModel;

/**
 * Class EsgCity.
 * @author marcelo.alves
 */
@ApiModel(description = "Class EsgCity. @author marcelo.alves")
@Entity
@Table(name = "esg_city")
public class EsgCity implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @NotNull
    @Size(max = 70)
    @Column(name = "nm_city", length = 70, nullable = false)
    private String nmCity;

    @Size(max = 10)
    @Column(name = "cd_city", length = 10)
    private String cdCity;

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="esg_uf_id",columnDefinition="esg_uf_id", referencedColumnName="id")
    @JsonIgnoreProperties("esgCities")
    private EsgUF esgUF;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNmCity() {
        return nmCity;
    }

    public EsgCity nmCity(String nmCity) {
        this.nmCity = nmCity;
        return this;
    }

    public void setNmCity(String nmCity) {
        this.nmCity = nmCity;
    }

    public String getCdCity() {
        return cdCity;
    }

    public EsgCity cdCity(String cdCity) {
        this.cdCity = cdCity;
        return this;
    }

    public void setCdCity(String cdCity) {
        this.cdCity = cdCity;
    }

    public EsgUF getEsgUF() {
        return esgUF;
    }

    public EsgCity esgUF(EsgUF esgUF) {
        this.esgUF = esgUF;
        return this;
    }

    public void setEsgUF(EsgUF esgUF) {
        this.esgUF = esgUF;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        EsgCity esgCity = (EsgCity) o;
        if (esgCity.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), esgCity.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "EsgCity{" +
            "id=" + getId() +
            ", nmCity='" + getNmCity() + "'" +
            ", cdCity='" + getCdCity() + "'" +
            "}";
    }
}
