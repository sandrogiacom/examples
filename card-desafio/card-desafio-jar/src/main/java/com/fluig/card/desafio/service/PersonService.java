package com.fluig.card.desafio.service;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.fluig.card.desafio.domain.Person;
import com.fluig.core.exception.BaseException;
import com.fluig.core.exception.NotFoundException;

@Service
public class PersonService {
    private static final Logger LOG = LoggerFactory.getLogger(PersonService.class);

    @Transactional(propagation = Propagation.REQUIRED)
    public Person create(Person person) {
        if (LOG.isDebugEnabled()) {
            LOG.debug("create(" + person + ")");
        }
        person.setId(UUID.randomUUID().toString());
        return person;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public Person update(Person person) throws BaseException {
        if (LOG.isDebugEnabled()) {
            LOG.debug("update(" + person + ")");
        }
        findById(person.getId());
        return person;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void delete(String id) throws BaseException {
        if (LOG.isDebugEnabled()) {
            LOG.debug("delete(" + id + ")");
        }
        Person p = findById(id);
    }

    @Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
    public Person findById(String id) throws BaseException {
        if (LOG.isDebugEnabled()) {
            LOG.debug("findById(" + id + ")");
        }
        if (id == null || id.isEmpty() || !id.equals("p1")) {
            throw new NotFoundException("FLUIG_CORE_404", new Object[]{id});
        }
        Person person = new Person(id);
        return person;
    }

    @Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
    public List<Person> findAll() {
        if (LOG.isDebugEnabled()) {
            LOG.debug("findAll()");
        }
        return Arrays.asList(new Person("p1"), new Person("p2"), new Person("p3"));
    }

}
