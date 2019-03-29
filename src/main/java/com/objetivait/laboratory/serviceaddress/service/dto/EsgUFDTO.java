package com.objetivait.laboratory.serviceaddress.service.dto;
import java.io.Serializable;
import java.util.Objects;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;

/**
 * A DTO for the EsgUF entity.
 */
@ApiModel(description = "Class EsgUF. @author marcelo.alves")
public class EsgUFDTO implements Serializable {

    private Long id;

    @NotNull
    @Size(max = 100)
    private String nmUF;

    @NotNull
    @Size(max = 10)
    private String cdUF;

    @NotNull
    @Size(max = 10)
    private String acUF;


    private Long esgContryId;

    private String esgContryNmContry;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNmUF() {
        return nmUF;
    }

    public void setNmUF(String nmUF) {
        this.nmUF = nmUF;
    }

    public String getCdUF() {
        return cdUF;
    }

    public void setCdUF(String cdUF) {
        this.cdUF = cdUF;
    }

    public String getAcUF() {
        return acUF;
    }

    public void setAcUF(String acUF) {
        this.acUF = acUF;
    }

    public Long getEsgContryId() {
        return esgContryId;
    }

    public void setEsgContryId(Long esgContryId) {
        this.esgContryId = esgContryId;
    }

    public String getEsgContryNmContry() {
        return esgContryNmContry;
    }

    public void setEsgContryNmContry(String esgContryNmContry) {
        this.esgContryNmContry = esgContryNmContry;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        EsgUFDTO esgUFDTO = (EsgUFDTO) o;
        if (esgUFDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), esgUFDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "EsgUFDTO{" +
            "id=" + getId() +
            ", nmUF='" + getNmUF() + "'" +
            ", cdUF='" + getCdUF() + "'" +
            ", acUF='" + getAcUF() + "'" +
            ", esgContry=" + getEsgContryId() +
            ", esgContry='" + getEsgContryNmContry() + "'" +
            "}";
    }
}
