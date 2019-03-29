package com.objetivait.laboratory.serviceaddress.domain;


import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Class EsgContry
 * @author marcelo.alves
 */
//@ApiModel(description = "Class EsgContry @author marcelo.alves")
@Entity
@Table(name = "esg_contry")
public class EsgContry implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @NotNull
    @Size(max = 100)
    @Column(name = "nm_contry", length = 100, nullable = false, unique = true)
    private String nmContry;

    @Size(max = 20)
    @Column(name = "cd_contry", length = 20)
    private String cdContry;

    @Size(max = 10)
    @Column(name = "ac_contry", length = 10)
    private String acContry;

    @Max(value = 5)
    @Column(name = "cd_ddi")
    private Integer cdDDI;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNmContry() {
        return nmContry;
    }

    public EsgContry nmContry(String nmContry) {
        this.nmContry = nmContry;
        return this;
    }

    public void setNmContry(String nmContry) {
        this.nmContry = nmContry;
    }

    public String getCdContry() {
        return cdContry;
    }

    public EsgContry cdContry(String cdContry) {
        this.cdContry = cdContry;
        return this;
    }

    public void setCdContry(String cdContry) {
        this.cdContry = cdContry;
    }

    public String getAcContry() {
        return acContry;
    }

    public EsgContry acContry(String acContry) {
        this.acContry = acContry;
        return this;
    }

    public void setAcContry(String acContry) {
        this.acContry = acContry;
    }

    public Integer getCdDDI() {
        return cdDDI;
    }

    public EsgContry cdDDI(Integer cdDDI) {
        this.cdDDI = cdDDI;
        return this;
    }

    public void setCdDDI(Integer cdDDI) {
        this.cdDDI = cdDDI;
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
        EsgContry esgContry = (EsgContry) o;
        if (esgContry.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), esgContry.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "EsgContry{" +
            "id=" + getId() +
            ", nmContry='" + getNmContry() + "'" +
            ", cdContry='" + getCdContry() + "'" +
            ", acContry='" + getAcContry() + "'" +
            ", cdDDI=" + getCdDDI() +
            "}";
    }
}
