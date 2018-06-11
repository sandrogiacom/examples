package com.fluig.card.desafio.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Date;
import java.util.List;

import org.junit.Test;

import com.fluig.card.desafio.domain.Person;
import com.fluig.core.exception.BaseException;
import com.fluig.core.exception.NotFoundException;


public class PersonServiceTest {
    private static final Date birthDate = new Date();

    private PersonService personService = new PersonService();

    @Test
    public void create() throws BaseException {
        Person person = getPerson(null);
        Person personSaved = personService.create(person);
        assertThat(personSaved.getId()).isNotBlank();
    }

    @Test
    public void update() throws BaseException {
        Person person = getPerson("p1");
        Person personSaved = personService.update(person);
        assertThat(personSaved.getId()).isNotNull();
    }

    @Test(expected = NotFoundException.class)
    public void updatePersonNotFound() throws BaseException {
        Person person = getPerson("p2");
        personService.update(person);
    }

    @Test
    public void delete() throws BaseException {
        personService.delete("p1");
    }

    @Test
    public void findById() throws BaseException {
        Person person = personService.findById("p1");
        assertThat("p1").isEqualTo(person.getId());
    }

    @Test(expected = NotFoundException.class)
    public void findByIdException() throws BaseException {
        personService.findById("abc");
    }

    @Test
    public void findAll() {
        List<Person> personList = personService.findAll();
        assertThat(personList).hasSize(3);
    }
    private Person getPerson(String id) {
        return (id != null)
                ? new Person(id, "t1", "Nome", "Sobrenome", birthDate)
                : new Person("t1", "Nome", "Sobrenome", birthDate);
    }

}