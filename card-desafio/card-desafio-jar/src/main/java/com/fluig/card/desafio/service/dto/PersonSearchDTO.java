package com.fluig.card.desafio.service.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.fluig.api.date.DateParam;

public class PersonSearchDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private int page = 1;

    private int pageSize = 1000;

    private String id;

    private String firstName;

    private String lastName;

    private List<String> order;

    private List<String> expand;

    private Date birthStart;

    private Date birthEnd;

    public PersonSearchDTO() {
    }

    public PersonSearchDTO(int page, int pageSize) {
        this.page = page;
        this.pageSize = pageSize;
    }

    public PersonSearchDTO(int page, int pageSize, String id, String firstName, String lastName,
            List<String> order, List<String> expand, DateParam birthStart, DateParam birthFinish) {
        this.page = page;
        this.pageSize = pageSize;
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.order = order;
        this.expand = expand;
        this.birthStart = (birthStart != null ? birthStart.toDate() : null);
        this.birthEnd = (birthFinish != null ? birthFinish.toDate() : null);
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public List<String> getOrder() {
        return order;
    }

    public void setOrder(List<String> order) {
        this.order = order;
    }

    public Date getBirthEnd() {
        return birthEnd;
    }

    public void setBirthEnd(Date birthEnd) {
        this.birthEnd = birthEnd;
    }

    public Date getBirthStart() {
        return birthStart;
    }

    public void setBirthStart(Date birthStart) {
        this.birthStart = birthStart;
    }

    public List<String> getExpand() {
        return expand;
    }

    public void setExpand(List<String> expand) {
        this.expand = expand;
    }

    @Override
    public String toString() {
        return "PersonSearchDTO{" +
                "page=" + page +
                ", pageSize=" + pageSize +
                ", id='" + id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", order=" + order +
                '}';
    }
}
