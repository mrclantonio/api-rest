package com.objetivait.laboratory.serviceaddress.service.dto;

import java.io.Serializable;
import java.util.Objects;

import io.github.jhipster.service.filter.LongFilter;
import io.github.jhipster.service.filter.StringFilter;


public class EsgCityCriteria implements Serializable {

    private static final long serialVersionUID = 1L;

    private LongFilter id;

    private StringFilter nmCity;

    private StringFilter cdCity;

    private LongFilter esgUFId;

    public LongFilter getId() {
        return id;
    }

    public void setId(LongFilter id) {
        this.id = id;
    }

    public StringFilter getNmCity() {
        return nmCity;
    }

    public void setNmCity(StringFilter nmCity) {
        this.nmCity = nmCity;
    }

    public StringFilter getCdCity() {
        return cdCity;
    }

    public void setCdCity(StringFilter cdCity) {
        this.cdCity = cdCity;
    }

    public LongFilter getEsgUFId() {
        return esgUFId;
    }

    public void setEsgUFId(LongFilter esgUFId) {
        this.esgUFId = esgUFId;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final EsgCityCriteria that = (EsgCityCriteria) o;
        return
            Objects.equals(id, that.id) &&
            Objects.equals(nmCity, that.nmCity) &&
            Objects.equals(cdCity, that.cdCity) &&
            Objects.equals(esgUFId, that.esgUFId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
        id,
        nmCity,
        cdCity,
        esgUFId
        );
    }

    @Override
    public String toString() {
        return "EsgCityCriteria{" +
                (id != null ? "id=" + id + ", " : "") +
                (nmCity != null ? "nmCity=" + nmCity + ", " : "") +
                (cdCity != null ? "cdCity=" + cdCity + ", " : "") +
                (esgUFId != null ? "esgUFId=" + esgUFId + ", " : "") +
            "}";
    }

}
