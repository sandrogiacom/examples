package com.fluig.card.desafio.api.v1.mapper;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import com.fluig.card.desafio.api.v1.dto.person.PersonCreateDTO;
import com.fluig.card.desafio.api.v1.dto.person.PersonResponseDTO;
import com.fluig.card.desafio.api.v1.dto.person.PersonUpdateDTO;
import com.fluig.card.desafio.domain.Person;

public class PersonMapperTest {
    private static Person person1;
    private static Person person2;
    private static List<Person> people;

    @BeforeClass
    public static void initialize() {
        person1 = new Person("1", "t1", "Nome 1", "Sobrenome 1", new Date());
        person2 = new Person("2", "t1", "Nome 2", "Sobrenome 2", new Date());

        people = new LinkedList<>();
        people.add(person1);
        people.add(person2);
    }

    @Test
    public void peopleToResponseDTO() {
        List<PersonResponseDTO> response = PersonMapper.personsToResponseDTO(people);
        assertThat(response.size()).isEqualTo(2);

        PersonResponseDTO dto = response.get(0);
        assertThat(dto.getId()).isEqualTo(person1.getId());
        assertThat(dto.getFirstName()).isEqualTo(person1.getFirstName());
        assertThat(dto.getLastName()).isEqualTo(person1.getLastName());
        assertThat(dto.getBirthDate()).isEqualTo(person1.getBirthDate());

        dto = response.get(1);
        assertThat(dto.getId()).isEqualTo(person2.getId());
        assertThat(dto.getFirstName()).isEqualTo(person2.getFirstName());
        assertThat(dto.getLastName()).isEqualTo(person2.getLastName());
        assertThat(dto.getBirthDate()).isEqualTo(person2.getBirthDate());
    }

    @Test
    public void personToResponseDTO() {
        PersonResponseDTO dto = PersonMapper.personToResponseDTO(person1);

        assertThat(dto.getId()).isEqualTo(person1.getId());
        assertThat(dto.getFirstName()).isEqualTo(person1.getFirstName());
        assertThat(dto.getLastName()).isEqualTo(person1.getLastName());
        assertThat(dto.getBirthDate()).isEqualTo(person1.getBirthDate());

    }

    @Test
    public void fromCreateDTO() {
        PersonCreateDTO dto = new PersonCreateDTO("Nome", "Sobrenome", new Date());
        Person entity = PersonMapper.fromCreateDTO(dto);

        assertThat(entity.getFirstName()).isEqualTo(dto.getFirstName());
        assertThat(entity.getLastName()).isEqualTo(dto.getLastName());
        assertThat(entity.getBirthDate()).isEqualTo(dto.getBirthDate());
    }

    @Test
    public void fromUpdateDTO() {
        PersonUpdateDTO dto = new PersonUpdateDTO("Nome", "Sobrenome", new Date());
        Person entity = PersonMapper.fromUpdateDTO("1", dto);

        assertThat(entity.getId()).isEqualTo("1");
        assertThat(entity.getFirstName()).isEqualTo(dto.getFirstName());
        assertThat(entity.getLastName()).isEqualTo(dto.getLastName());
        assertThat(entity.getBirthDate()).isEqualTo(dto.getBirthDate());
    }

    @Test
    public void fromUpdateDTO1() {
        PersonUpdateDTO dto = new PersonUpdateDTO("Nome", "Sobrenome", new Date());
        Person entity = PersonMapper.fromUpdateDTO(new Person("1"), dto);

        assertThat(entity.getId()).isEqualTo("1");
        assertThat(entity.getFirstName()).isEqualTo(dto.getFirstName());
        assertThat(entity.getLastName()).isEqualTo(dto.getLastName());
        assertThat(entity.getBirthDate()).isEqualTo(dto.getBirthDate());
    }

}