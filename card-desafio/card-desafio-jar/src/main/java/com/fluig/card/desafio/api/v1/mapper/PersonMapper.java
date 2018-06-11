package com.fluig.card.desafio.api.v1.mapper;

import java.lang.reflect.Type;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.modelmapper.convention.MatchingStrategies;

import com.fluig.card.desafio.api.v1.dto.person.PersonResponseListDTO;
import com.fluig.card.desafio.api.v1.dto.person.PersonCreateDTO;
import com.fluig.card.desafio.api.v1.dto.person.PersonResponseDTO;
import com.fluig.card.desafio.api.v1.dto.person.PersonUpdateDTO;
import com.fluig.card.desafio.domain.Person;


public class PersonMapper {
    private static final ModelMapper modelMapper = new ModelMapper();

    static {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
    }

    private PersonMapper() {
    }

    public static List<PersonResponseDTO> personsToResponseDTO(List<Person> persons) {
        Type targetListType = new TypeToken<List<PersonResponseDTO>>() {}.getType();
        return modelMapper.map(persons, targetListType);
    }
    public static PersonResponseDTO personToResponseDTO(Person entity) {
        return modelMapper.map(entity, PersonResponseDTO.class);
    }

    public static Person fromCreateDTO(PersonCreateDTO person) {
        return modelMapper.map(person, Person.class);
    }

    public static Person fromUpdateDTO(Person entity, PersonUpdateDTO personDTO) {
        modelMapper.map(personDTO, entity);
        return entity;
    }

    public static Person fromUpdateDTO(String id, PersonUpdateDTO personDTO) {
        return fromUpdateDTO(new Person(id), personDTO);
    }

}
