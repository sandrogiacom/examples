package com.fluig.card.desafio.api.v1.dto.person;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.fluig.api.response.BaseDTO;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("PersonUpdate")
public class PersonUpdateDTO extends BaseDTO {

    @ApiModelProperty(value = "Nome", required = true)
    private String firstName;

    @ApiModelProperty(value = "Sobrenome", required = true)
    private String lastName;

    @ApiModelProperty(value = "Data de nascimento", required = true)
    private Date birthDate;

    public PersonUpdateDTO() {
    }

    public PersonUpdateDTO(String firstName, String lastName, Date birthDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
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

}
