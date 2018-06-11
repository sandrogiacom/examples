package com.fluig.card.desafio.api.v1.controller;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fluig.api.BaseController;
import com.fluig.api.date.DateParam;
import com.fluig.api.expandable.ExpandableParam;
import com.fluig.api.pagination.PaginationParam;
import com.fluig.api.response.ErrorResponse;
import com.fluig.card.desafio.api.v1.dto.person.PersonCreateDTO;
import com.fluig.card.desafio.api.v1.dto.person.PersonResponseDTO;
import com.fluig.card.desafio.api.v1.dto.person.PersonResponseListDTO;
import com.fluig.card.desafio.api.v1.dto.person.PersonUpdateDTO;
import com.fluig.card.desafio.api.v1.mapper.PersonMapper;
import com.fluig.card.desafio.domain.Person;
import com.fluig.card.desafio.service.PersonService;
import com.fluig.card.desafio.service.dto.PersonSearchDTO;
import com.fluig.core.exception.BaseException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(RestPath.BASE_PATH + "/persons")
@Api(description = "Serviço de pessoas", tags = "Pessoas")
public class PersonController extends BaseController {
    private PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }


    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation("Busca uma pessoa pelo ID")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Ok", response = PersonResponseDTO.class),
            @ApiResponse(code = 400, message = "Ocorreu um erro ao tentar buscar pessoa por seu id",
                    response = ErrorResponse.class),
            @ApiResponse(code = 401, message = "O usuario nao esta autenticado", response = ErrorResponse.class),
            @ApiResponse(code = 404, message = "Pessoa nao encontrada", response = ErrorResponse.class),
            @ApiResponse(code = 500, message = "Erro interno do servidor, veja a resposta para mais detalhes",
                    response = ErrorResponse.class)
    })
    public ResponseEntity<PersonResponseDTO> findPerson(@PathVariable(name = "id") String id) throws BaseException {
        return buildSuccessResponse(PersonMapper.personToResponseDTO(personService.findById(id)));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation("Adicionar uma nova pessoa")
    @ApiResponses({
            @ApiResponse(code = 201, message = "Ok", response = PersonResponseDTO.class),
            @ApiResponse(code = 400, message = "Ocorreu um erro ao criar a perssoa", response = ErrorResponse.class),
            @ApiResponse(code = 401, message = "O usuario nao esta autenticado", response = ErrorResponse.class),
            @ApiResponse(code = 500, message = "Erro interno do servidor, veja a resposta para mais detalhes",
                    response = ErrorResponse.class)
    })
    public ResponseEntity<PersonResponseDTO> createPerson(@RequestBody PersonCreateDTO person) throws BaseException {
        PersonResponseDTO newPerson = PersonMapper.personToResponseDTO(
                personService.create(PersonMapper.fromCreateDTO(person)));
        return buildCreatedSuccessResponse(newPerson);
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation("Editar pessoa")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Ok", response = PersonResponseDTO.class),
            @ApiResponse(code = 400, message = "Ocorreu um erro ao tentar editar a pessoa", response = ErrorResponse.class),
            @ApiResponse(code = 401, message = "O usuario nao esta autenticado", response = ErrorResponse.class),
            @ApiResponse(code = 404, message = "Pessoa nao encontrada", response = ErrorResponse.class),
            @ApiResponse(code = 500, message = "Erro interno do servidor, veja a resposta para mais detalhes",
                    response = ErrorResponse.class)
    })
    public ResponseEntity<PersonResponseDTO> updatePerson(@PathVariable("id") String id,
            @RequestBody PersonUpdateDTO personDTO) throws BaseException {
        PersonResponseDTO updatedPerson = PersonMapper.personToResponseDTO(
                personService.update(PersonMapper.fromUpdateDTO(id, personDTO)));
        return buildSuccessResponse(updatedPerson);
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation("Remover pessoa")
    @ApiResponses({
            @ApiResponse(code = 204, message = "Ok"),
            @ApiResponse(code = 400, message = "Ocorreu um erro ao tentar remover a pessoa", response = ErrorResponse.class),
            @ApiResponse(code = 401, message = "O usuario nao esta autenticado", response = ErrorResponse.class),
            @ApiResponse(code = 404, message = "Pessoa nao encontrada", response = ErrorResponse.class),
            @ApiResponse(code = 500, message = "Erro interno do servidor, veja a resposta para mais detalhes",
                    response = ErrorResponse.class)
    })
    public ResponseEntity deletePerson(@PathVariable(name = "id") String id) throws BaseException {
        personService.delete(id);
        return buildSuccessResponseWithNoContent();
    }

}
