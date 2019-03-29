package com.objetivait.laboratory.serviceaddress.domain;


import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
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

/**
 * Class EsgUF.
 * @author marcelo.alves
 */
//@ApiModel(description = "Class EsgUF. @author marcelo.alves")
@Entity
@Table(name = "esg_uf")
public class EsgUF implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @NotNull
    @Size(max = 100)
    @Column(name = "nm_uf", length = 100, nullable = false)
    private String nmUF;

    @NotNull
    @Size(max = 10)
    @Column(name = "cd_uf", length = 10, nullable = false, unique = true)
    private String cdUF;

    @NotNull
    @Size(max = 10)
    @Column(name = "ac_uf", length = 10, nullable = false, unique = true)
    private String acUF;

    @ManyToOne
    @JoinColumn(name="esg_contry_id",columnDefinition="esg_contry_id", referencedColumnName="id")
    @JsonIgnoreProperties("esgUFS")
    private EsgContry esgContry;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNmUF() {
        return nmUF;
    }

    public EsgUF nmUF(String nmUF) {
        this.nmUF = nmUF;
        return this;
    }

    public void setNmUF(String nmUF) {
        this.nmUF = nmUF;
    }

    public String getCdUF() {
        return cdUF;
    }

    public EsgUF cdUF(String cdUF) {
        this.cdUF = cdUF;
        return this;
    }

    public void setCdUF(String cdUF) {
        this.cdUF = cdUF;
    }

    public String getAcUF() {
        return acUF;
    }

    public EsgUF acUF(String acUF) {
        this.acUF = acUF;
        return this;
    }

    public void setAcUF(String acUF) {
        this.acUF = acUF;
    }

    public EsgContry getEsgContry() {
        return esgContry;
    }

    public EsgUF esgContry(EsgContry esgContry) {
        this.esgContry = esgContry;
        return this;
    }

    public void setEsgContry(EsgContry esgContry) {
        this.esgContry = esgContry;
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
        EsgUF esgUF = (EsgUF) o;
        if (esgUF.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), esgUF.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "EsgUF{" +
            "id=" + getId() +
            ", nmUF='" + getNmUF() + "'" +
            ", cdUF='" + getCdUF() + "'" +
            ", acUF='" + getAcUF() + "'" +
            "}";
    }
}
