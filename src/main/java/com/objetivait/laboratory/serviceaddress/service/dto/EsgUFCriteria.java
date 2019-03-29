package com.objetivait.laboratory.serviceaddress.service.dto;

import java.io.Serializable;
import java.util.Objects;

import io.github.jhipster.service.filter.LongFilter;
import io.github.jhipster.service.filter.StringFilter;

public class EsgUFCriteria implements Serializable {

    private static final long serialVersionUID = 1L;

    private LongFilter id;

    private StringFilter nmUF;

    private StringFilter cdUF;

    private LongFilter esgContryId;

    public LongFilter getId() {
        return id;
    }

    public void setId(LongFilter id) {
        this.id = id;
    }

    public StringFilter getNmUF() {
        return nmUF;
    }

    public void setNmUF(StringFilter nmUF) {
        this.nmUF = nmUF;
    }

    public StringFilter getCdUF() {
        return cdUF;
    }

    public void setCdUF(StringFilter cdUF) {
        this.cdUF = cdUF;
    }

    public LongFilter getEsgContryId() {
        return esgContryId;
    }

    public void setEsgContryId(LongFilter esgContryId) {
        this.esgContryId = esgContryId;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final EsgUFCriteria that = (EsgUFCriteria) o;
        return
            Objects.equals(id, that.id) &&
            Objects.equals(nmUF, that.nmUF) &&
            Objects.equals(cdUF, that.cdUF) &&
            Objects.equals(esgContryId, that.esgContryId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
        id,
        nmUF,
        cdUF,
        esgContryId
        );
    }

    @Override
    public String toString() {
        return "EsgUFCriteria{" +
                (id != null ? "id=" + id + ", " : "") +
                (nmUF != null ? "nmUF=" + nmUF + ", " : "") +
                (cdUF != null ? "cdUF=" + cdUF + ", " : "") +
                (esgContryId != null ? "esgContryId=" + esgContryId + ", " : "") +
            "}";
    }

}
