package com.fluig.card.desafio.api.v1.dto.person;

import java.util.List;

import com.fluig.api.response.CollectionResponse;

import io.swagger.annotations.ApiModel;

@ApiModel("PersonResponseList")
public class PersonResponseListDTO extends CollectionResponse<PersonResponseDTO> {

    public PersonResponseListDTO(List<PersonResponseDTO> items, boolean hasNext) {
        super(items, hasNext);
    }
}
