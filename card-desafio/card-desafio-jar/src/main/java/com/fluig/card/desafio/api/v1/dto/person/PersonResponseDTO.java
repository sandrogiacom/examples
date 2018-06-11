package com.fluig.card.desafio.api.v1.dto.person;

import java.util.Date;
import java.util.Objects;

import com.fluig.api.response.BaseDTO;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("PersonResponse")
public class PersonResponseDTO extends BaseDTO {

    @ApiModelProperty(value = "ID do tenante", required = true)
    private String tenantId;

    @ApiModelProperty(value = "Identificador único da pessoa", required = true)
    private String id;

    @ApiModelProperty(value = "Nome", required = true)
    private String firstName;

    @ApiModelProperty(value = "Sobrenome", required = true)
    private String lastName;

    @ApiModelProperty(value = "Data de nascimento", required = true)
    private Date birthDate;

    public PersonResponseDTO() {
    }

    public PersonResponseDTO(String id) {
        this.id = id;
    }

    public PersonResponseDTO(String tenantId, String firstName, String lastName, Date birthDate) {
        this.tenantId = tenantId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        PersonResponseDTO that = (PersonResponseDTO) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "PersonResponseDTO{" +
                "id='" + id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthDate=" + birthDate +
                '}';
    }
}
