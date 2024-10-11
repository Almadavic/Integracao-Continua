package com.almada.manage_people.dto.response;


import com.almada.manage_people.entity.Person;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class PersonResponseDTO {

    private final Long id;

    private final String name;

    private final String email;

    private final Integer age;

    private final String maritalStatus;

    private final LocalDate created;

    public PersonResponseDTO(final Person person) {
        this.id = person.getId();
        this.name = person.getName();
        this.email = person.getEmail();
        this.age = person.getAge();
        this.maritalStatus = person.getMaritalStatus().toString();
        this.created = person.getCreated();
    }

}
