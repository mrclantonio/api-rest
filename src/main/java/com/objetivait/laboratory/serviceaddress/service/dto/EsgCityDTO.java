package com.objetivait.laboratory.serviceaddress.service.dto;
import java.io.Serializable;
import java.util.Objects;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;

/**
 * A DTO for the EsgCity entity.
 */
@ApiModel(description = "Class EsgCity. @author marcelo.alves")
public class EsgCityDTO implements Serializable {

    private Long id;

    @NotNull
    @Size(max = 70)
    private String nmCity;

    @Size(max = 10)
    private String cdCity;


    private Long esgUFId;

    private String esgUFNmUF;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNmCity() {
        return nmCity;
    }

    public void setNmCity(String nmCity) {
        this.nmCity = nmCity;
    }

    public String getCdCity() {
        return cdCity;
    }

    public void setCdCity(String cdCity) {
        this.cdCity = cdCity;
    }

    public Long getEsgUFId() {
        return esgUFId;
    }

    public void setEsgUFId(Long esgUFId) {
        this.esgUFId = esgUFId;
    }

    public String getEsgUFNmUF() {
        return esgUFNmUF;
    }

    public void setEsgUFNmUF(String esgUFNmUF) {
        this.esgUFNmUF = esgUFNmUF;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        EsgCityDTO esgCityDTO = (EsgCityDTO) o;
        if (esgCityDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), esgCityDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "EsgCityDTO{" +
            "id=" + getId() +
            ", nmCity='" + getNmCity() + "'" +
            ", cdCity='" + getCdCity() + "'" +
            ", esgUF=" + getEsgUFId() +
            ", esgUF='" + getEsgUFNmUF() + "'" +
            "}";
    }
}
