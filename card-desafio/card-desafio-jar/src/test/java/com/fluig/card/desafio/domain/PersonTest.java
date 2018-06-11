package com.fluig.card.desafio.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import org.junit.BeforeClass;
import org.junit.Test;
import org.modelmapper.ModelMapper;

public class PersonTest {
    private static final Date birthDate = new Date();

    private static Person personId;
    private static Person personNormal;
    private static Person personFull;

    @BeforeClass
    public static void initialize() {
        personId = new Person("1");
        personNormal = new Person("t1", "Nome", "Sobrenome", birthDate);
        personFull = new Person("2", "t2", "Nome", "Sobrenome", birthDate);
    }

    @Test
    public void whenCreatePersonConstructorById() {
        assertThat(personId.getId()).isEqualTo("1");
        assertThat(personId.getTenantId()).isNull();
        assertThat(personId.getFirstName()).isNull();
        assertThat(personId.getLastName()).isNull();
        assertThat(personId.getBirthDate()).isNull();
    }

    @Test
    public void whenCreatePersonFullConstructor() {
        assertThat(personFull.getId()).isEqualTo("2");
        assertThat(personFull.getTenantId()).isEqualTo("t2");
        assertThat(personFull.getFirstName()).isEqualTo("Nome");
        assertThat(personFull.getLastName()).isEqualTo("Sobrenome");
        assertThat(personFull.getBirthDate()).isEqualTo(birthDate);
    }

    @Test
    public void whenCreatePersonNormalConstructor() {
        assertThat(personNormal.getId()).isNull();
        assertThat(personNormal.getTenantId()).isEqualTo("t1");
        assertThat(personNormal.getFirstName()).isEqualTo("Nome");
        assertThat(personNormal.getLastName()).isEqualTo("Sobrenome");
        assertThat(personNormal.getBirthDate()).isEqualTo(birthDate);
    }

    @Test
    public void whenSetProperties() {
        Person person = new Person();
        person.setId("1");
        person.setTenantId("t1");
        person.setFirstName("Nome");
        person.setLastName("Sobrenome");
        person.setBirthDate(birthDate);

        assertThat(person.getId()).isEqualTo("1");
        assertThat(person.getTenantId()).isEqualTo("t1");
        assertThat(person.getFirstName()).isEqualTo("Nome");
        assertThat(person.getLastName()).isEqualTo("Sobrenome");
        assertThat(person.getBirthDate()).isEqualTo(birthDate);
    }

    @Test
    public void testEquals() {
        ModelMapper mapper = new ModelMapper();
        Person person = new Person();
        mapper.map(personFull, person);

        assertThat(personId.equals(personId)).isTrue();
        assertThat(person.equals(personFull)).isTrue();
        assertThat(personId.equals(personFull)).isFalse();
        assertThat(personId.equals(personNormal)).isFalse();
        assertThat(personId.equals("teste")).isFalse();
    }

    @Test
    public void testHashCode() {
        assertThat(personId.hashCode()).isEqualTo(Objects.hash("1"));
        assertThat(new Person().hashCode()).isNotEqualTo(0);
    }

    @Test
    public void testToString() {
        assertThat(personId.toString()).isNotEmpty();
    }
}