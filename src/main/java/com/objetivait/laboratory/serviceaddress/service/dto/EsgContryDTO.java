package com.objetivait.laboratory.serviceaddress.service.dto;
import java.io.Serializable;
import java.util.Objects;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;

/**
 * A DTO for the EsgContry entity.
 */
@ApiModel(description = "Class EsgContry @author marcelo.alves")
public class EsgContryDTO implements Serializable {

    private Long id;

    @NotNull
    @Size(max = 100)
    private String nmContry;

    @Size(max = 20)
    private String cdContry;

    @Size(max = 10)
    private String acContry;

    @Max(value = 5)
    private Integer cdDDI;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNmContry() {
        return nmContry;
    }

    public void setNmContry(String nmContry) {
        this.nmContry = nmContry;
    }

    public String getCdContry() {
        return cdContry;
    }

    public void setCdContry(String cdContry) {
        this.cdContry = cdContry;
    }

    public String getAcContry() {
        return acContry;
    }

    public void setAcContry(String acContry) {
        this.acContry = acContry;
    }

    public Integer getCdDDI() {
        return cdDDI;
    }

    public void setCdDDI(Integer cdDDI) {
        this.cdDDI = cdDDI;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        EsgContryDTO esgContryDTO = (EsgContryDTO) o;
        if (esgContryDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), esgContryDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "EsgContryDTO{" +
            "id=" + getId() +
            ", nmContry='" + getNmContry() + "'" +
            ", cdContry='" + getCdContry() + "'" +
            ", acContry='" + getAcContry() + "'" +
            ", cdDDI=" + getCdDDI() +
            "}";
    }
}
